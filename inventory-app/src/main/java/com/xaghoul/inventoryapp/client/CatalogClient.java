package com.xaghoul.inventoryapp.client;

import dto.ProductDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "catalog-service", path = "/api/v1/catalog")
public interface CatalogClient {

    @GetMapping
    List<ProductDTO> getAllProducts();
}
