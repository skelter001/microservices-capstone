package com.xaghoul.productapp.client;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "inventory-service", path = "/api/v1/inventory")
public interface InventoryClient {

    @GetMapping
    @CircuitBreaker(name = "inventoryService", fallbackMethod = "getAllAvailableProductIdsFallback")
    List<String> getAllAvailableProductIds();

    default List<String> getAllAvailableProductIdsFallback(Exception ex) {
        return List.of();
    }
}
