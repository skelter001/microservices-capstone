package com.xaghoul.productapp.service;

import com.xaghoul.productapp.client.CatalogClient;
import com.xaghoul.productapp.client.InventoryClient;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private CatalogClient catalogClient;
    private InventoryClient inventoryClient;
}
