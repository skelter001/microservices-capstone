package com.xaghoul.productapp.service;

import com.xaghoul.common.dto.ProductDTO;
import com.xaghoul.common.exception.ProductIsUnavailableException;
import com.xaghoul.productapp.client.CatalogClientWrapper;
import com.xaghoul.productapp.client.InventoryClientWrapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class ProductService {

    private final CatalogClientWrapper catalogClientWrapper;
    private final InventoryClientWrapper inventoryClientWrapper;

    public ProductDTO getProductById(String productId) {
        log.info("Product Service: get product by id {}", productId);
        List<String> availableProductIds = inventoryClientWrapper.getAllAvailableProductIds();

        ProductDTO productDTO = catalogClientWrapper.getProductById(productId);
        log.debug("Product Service: got product DTO {}", productDTO);

        if (availableProductIds.contains(productDTO.getSku()))
            return productDTO;
        else
            throw new ProductIsUnavailableException(productId);
    }

    public List<ProductDTO> getProductsBySku(String sku) {
        log.info("Product Service: get products by sku {}", sku);
        List<String> availableProductIds = inventoryClientWrapper.getAllAvailableProductIds();

        List<ProductDTO> productDTOS = catalogClientWrapper.getProductsBySku(sku).stream()
                .filter(productDTO -> availableProductIds.contains(productDTO.getSku()))
                .collect(Collectors.toList());
        log.debug("Product Service: got list of products {}", productDTOS);

        return productDTOS;
    }
}
