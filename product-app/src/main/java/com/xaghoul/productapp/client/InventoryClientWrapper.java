package com.xaghoul.productapp.client;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class InventoryClientWrapper {

    private final InventoryClient inventoryClient;

    @CircuitBreaker(name = "inventoryService", fallbackMethod = "getAllAvailableProductIdsFallback")
    public List<String> getAllAvailableProductIds() {
        return inventoryClient.getAllAvailableProductIds();
    }

    private List<String> getAllAvailableProductIdsFallback(Exception ex) {
        return List.of();
    }
}
