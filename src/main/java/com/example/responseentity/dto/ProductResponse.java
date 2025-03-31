package com.example.responseentity.dto;

import java.math.BigDecimal;

public record ProductResponse(Long id, String name, String description, BigDecimal price, Integer stockQuantity) {

    public static ProductResponse of(Long id, String name, String description, BigDecimal price, Integer stockQuantity) {
        return new ProductResponse(id, name, description, price, stockQuantity);
    }
}
