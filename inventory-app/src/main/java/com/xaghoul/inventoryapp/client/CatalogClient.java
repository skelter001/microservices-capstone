package com.xaghoul.inventoryapp.client;

import com.xaghoul.common.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "catalog-service", path = "/api/v1/catalog")
public interface CatalogClient {

    @GetMapping
    List<ProductDTO> getAllProducts();
}
