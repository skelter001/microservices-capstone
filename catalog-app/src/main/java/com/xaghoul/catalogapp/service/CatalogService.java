package com.xaghoul.catalogapp.service;

import com.xaghoul.catalogapp.exception.EntityNotFoundException;
import com.xaghoul.catalogapp.mapper.ProductMapper;
import com.xaghoul.catalogapp.repository.CatalogRepository;
import com.xaghoul.common.dto.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
@Slf4j
public class CatalogService {

    private final CatalogRepository catalogRepository;
    private final ProductMapper productMapper;

    public List<ProductDTO> getAllProducts() {
        log.info("Catalog Service: get all products");
        return StreamSupport.stream(catalogRepository.findAll().spliterator(), false)
                .map(productMapper::toModel)
                .collect(Collectors.toList());
    }

    public ProductDTO getProductById(String uniqId) {
        log.info("Catalog Service: get product by id {}", uniqId);
        return catalogRepository.findById(uniqId)
                .map(productMapper::toModel)
                .orElseThrow(EntityNotFoundException::new);
    }

    public List<ProductDTO> getAllBySku(String sku) {
        log.info("Catalog Service: get all products by sku {}", sku);
        return catalogRepository.findAllBySku(sku).stream()
                .map(productMapper::toModel)
                .collect(Collectors.toList());
    }
}
