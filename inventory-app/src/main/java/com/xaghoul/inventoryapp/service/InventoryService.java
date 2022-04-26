package com.xaghoul.inventoryapp.service;

import com.xaghoul.common.dto.ProductDTO;
import com.xaghoul.inventoryapp.client.CatalogClient;
import com.xaghoul.inventoryapp.model.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class InventoryService {

    private final CatalogClient catalogClient;
    private Map<String, ProductStatus> productStatusMap;

    public List<String> getAllAvailableProductIds() {
        log.info("Inventory Service: get all available products");
        productStatusMap = generateProductStatuses(catalogClient.getAllProducts());

        return productStatusMap.entrySet().stream()
                .filter(status -> status.getValue().equals(ProductStatus.AVAILABLE))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private Map<String, ProductStatus> generateProductStatuses(List<ProductDTO> productDTOS) {
        Random random = new Random();
        return productDTOS.stream()
                .map(ProductDTO::getSku)
                .distinct()
                .filter(sku -> !productStatusMap.containsKey(sku))
                .collect(Collectors.toMap(sku -> sku,
                        product -> random.nextBoolean() ? ProductStatus.AVAILABLE : ProductStatus.UNAVAILABLE)
                );
    }
}
