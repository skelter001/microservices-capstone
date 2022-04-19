package com.xaghoul.productapp.service;

import com.xaghoul.common.exception.ProductIsUnavailableException;
import com.xaghoul.productapp.client.CatalogClient;
import com.xaghoul.productapp.client.InventoryClient;
import com.xaghoul.common.dto.ProductDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductService {

    private CatalogClient catalogClient;
    private InventoryClient inventoryClient;

    public ProductDTO getProductById(String productId) {
        List<String> availableProductIds = inventoryClient.getAllAvailableProductIds();

        if (!availableProductIds.contains(productId))
            return catalogClient.getProductById(productId);
        else
            throw new ProductIsUnavailableException(productId);
    }

    public List<ProductDTO> getProductsBySku(String sku) {
        List<String> availableProductIds = inventoryClient.getAllAvailableProductIds();

        return catalogClient.getProductsBySku(sku).stream()
                .filter(productDTO -> availableProductIds.contains(productDTO.getUniqId()))
                .collect(Collectors.toList());
    }
}
