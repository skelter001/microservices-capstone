package com.xaghoul.inventoryapp.service;

import com.xaghoul.inventoryapp.client.CatalogClient;
import com.xaghoul.inventoryapp.model.ProductStatus;
import dto.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class InventoryService {

    private CatalogClient catalogClient;
    private final Map<String, ProductStatus> productStatusMap;

    public InventoryService(CatalogClient catalogClient) {
        this.catalogClient = catalogClient;
        productStatusMap = generateProductStatuses(catalogClient.getAllProducts());
    }

    public List<String> getAllAvailableProductIds() {
        return productStatusMap.entrySet().stream()
                .filter(status -> status.getValue().equals(ProductStatus.AVAILABLE))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public Map<String, ProductStatus> generateProductStatuses(List<ProductDTO> productDTOS) {
        Random random = new Random();
        return productDTOS.stream()
                .collect(Collectors.toMap(ProductDTO::getUniqId,
                        product -> random.nextBoolean() ? ProductStatus.AVAILABLE : ProductStatus.UNAVAILABLE)
                );
    }
}
