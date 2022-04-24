package com.xaghoul.inventoryapp.controller;

import com.xaghoul.inventoryapp.service.InventoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/inventory")
@AllArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping
    private List<String> getAllAvailableProductIds() {
        return inventoryService.getAllAvailableProductIds();
    }
}
