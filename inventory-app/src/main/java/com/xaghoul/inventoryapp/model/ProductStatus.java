package com.xaghoul.inventoryapp.model;


public enum ProductStatus {
    AVAILABLE("available"),
    UNAVAILABLE("unavailable");

    private final String value;

    ProductStatus(String value) {
        this.value = value;
    }
}
