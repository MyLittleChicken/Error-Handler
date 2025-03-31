package com.example.responseentity.dto;

import java.math.BigDecimal;

public record ProductRequest(String name, String description, BigDecimal price, Integer stockQuantity) {

    public static ProductRequest of(String name, String description, BigDecimal price, Integer stockQuantity) {
        return new ProductRequest(name, description, price, stockQuantity);
    }
}
