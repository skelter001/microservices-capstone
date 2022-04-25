package com.xaghoul.productapp.client;

import com.xaghoul.common.dto.ProductDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "catalog-service", path = "/api/v1/catalog")
public interface CatalogClient {

    @GetMapping("/id/{uniqId}")
    ProductDTO getProductById(@PathVariable String uniqId);

    @GetMapping("/sku/{sku}")
    List<ProductDTO> getProductsBySku(@PathVariable String sku);
}
