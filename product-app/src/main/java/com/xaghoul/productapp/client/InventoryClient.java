package com.xaghoul.productapp.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "inventory-service", path = "/api/v1/inventory")
public interface InventoryClient {

    @GetMapping
    List<String> getAllAvailableProductIds();
}
