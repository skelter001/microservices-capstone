package com.xaghoul.catalogapp.controller;

import com.xaghoul.catalogapp.service.CatalogService;
import dto.ProductDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/catalog")
@AllArgsConstructor
public class CatalogController {

    private CatalogService catalogService;

    @GetMapping
    public List<ProductDTO> getAllProducts() {
        return catalogService.getAllProducts();
    }

    @GetMapping("/{uniqId}")
    public ProductDTO getProductById(@PathVariable String uniqId) {
        return catalogService.getProductById(uniqId);
    }

    @GetMapping("/{sku}")
    public List<ProductDTO> getProductsBySku(@PathVariable String sku) {
        return catalogService.getAllBySku(sku);
    }
}
