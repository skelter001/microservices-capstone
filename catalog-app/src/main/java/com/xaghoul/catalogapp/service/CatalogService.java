package com.xaghoul.catalogapp.service;

import com.xaghoul.catalogapp.exception.EntityNotFoundException;
import com.xaghoul.catalogapp.mapper.ProductMapper;
import com.xaghoul.catalogapp.repository.CatalogRepository;
import com.xaghoul.common.dto.ProductDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class CatalogService {

    private CatalogRepository catalogRepository;
    private ProductMapper productMapper;

    public List<ProductDTO> getAllProducts() {
        return StreamSupport.stream(catalogRepository.findAll().spliterator(), false)
                .map(productMapper::toModel)
                .collect(Collectors.toList());
    }

    public ProductDTO getProductById(String uniqId) {
        return catalogRepository.findById(uniqId)
                .map(productMapper::toModel)
                .orElseThrow(EntityNotFoundException::new);
    }

    public List<ProductDTO> getAllBySku(String sku) {
        return catalogRepository.findAllBySku(sku).stream()
                .map(productMapper::toModel)
                .collect(Collectors.toList());
    }
}
