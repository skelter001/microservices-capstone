package com.xaghoul.productapp.controller;

import com.xaghoul.common.dto.ProductDTO;
import com.xaghoul.productapp.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/api/v1/product")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    @GetMapping("/{uniqId}")
    public ProductDTO getProductById(@PathVariable String uniqId) {
        return productService.getProductById(uniqId);
    }

    @GetMapping("/{sku}")
    public List<ProductDTO> getProductsBySku(@PathVariable String sku) {
        return productService.getProductsBySku(sku);
    }
}
