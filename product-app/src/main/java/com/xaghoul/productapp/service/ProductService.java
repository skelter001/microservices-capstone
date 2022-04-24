package com.xaghoul.productapp.service;

import com.xaghoul.common.dto.ProductDTO;
import com.xaghoul.common.exception.ProductIsUnavailableException;
import com.xaghoul.productapp.client.CatalogClient;
import com.xaghoul.productapp.client.InventoryClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class ProductService {

    private final CatalogClient catalogClient;
    private final InventoryClient inventoryClient;

    public ProductDTO getProductById(String productId) {
        log.info("Product Service: get product by id {}", productId);
        List<String> availableProductIds = inventoryClient.getAllAvailableProductIds();

        ProductDTO productDTO = catalogClient.getProductById(productId);
        log.debug("Product Service: got product DTO {}", productDTO);

        if (availableProductIds.contains(productDTO.getSku()))
            return productDTO;
        else
            throw new ProductIsUnavailableException(productId);
    }

    public List<ProductDTO> getProductsBySku(String sku) {
        log.info("Product Service: get products by sku {}", sku);
        List<String> availableProductIds = inventoryClient.getAllAvailableProductIds();

        List<ProductDTO> productDTOS = catalogClient.getProductsBySku(sku).stream()
                .filter(productDTO -> availableProductIds.contains(productDTO.getSku()))
                .collect(Collectors.toList());
        log.debug("Product Service: got list of products {}", productDTOS);

        return productDTOS;
    }
}
