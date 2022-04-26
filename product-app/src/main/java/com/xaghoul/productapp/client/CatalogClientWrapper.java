package com.xaghoul.productapp.client;

import com.xaghoul.common.dto.ProductDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
@Slf4j
public class CatalogClientWrapper {

    private final CatalogClient catalogClient;

    @CircuitBreaker(name = "catalogService", fallbackMethod = "getProductByIdFallback")
    public ProductDTO getProductById(String uniqId) {
        return catalogClient.getProductById(uniqId);
    }

    @CircuitBreaker(name = "catalogService", fallbackMethod = "getProductsBySkuFallback")
    public List<ProductDTO> getProductsBySku(String sku) {
        return catalogClient.getProductsBySku(sku);
    }

    private ProductDTO getProductByIdFallback(Exception ex) {
        log.info("Catalog Client Wrapper: get product by id fallback");
        return ProductDTO.builder().build();
    }

    private List<ProductDTO> getProductsBySkuFallback(Exception ex) {
        log.info("Catalog Client Wrapper: get products by sku fallback");
        return List.of();
    }
}
