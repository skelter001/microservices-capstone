package com.xaghoul.productapp.client;

import dto.ProductDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "catalog-service", path = "/api/v1/catalog")
public interface CatalogClient {

    @GetMapping("/{uniqId}")
    ProductDTO getProductById(@PathVariable String uniqId);

    @GetMapping("/{sku}")
    List<ProductDTO> getProductsBySku(@PathVariable String sku);
}
