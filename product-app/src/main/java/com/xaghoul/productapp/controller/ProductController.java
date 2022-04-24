package com.xaghoul.productapp.controller;

import com.xaghoul.common.dto.ProductDTO;
import com.xaghoul.productapp.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/id/{uniqId}")
    public ProductDTO getProductById(@PathVariable String uniqId) {
        return productService.getProductById(uniqId);
    }

    @GetMapping("/sku/{sku}")
    public List<ProductDTO> getProductsBySku(@PathVariable String sku) {
        return productService.getProductsBySku(sku);
    }
}
