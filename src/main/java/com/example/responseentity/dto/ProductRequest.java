package com.example.responseentity.dto;

import java.math.BigDecimal;

public record ProductRequest(String name, String description, BigDecimal price, Integer stockQuantity) {
    // record를 사용하면 생성자, getter, equals, hashCode, toString이 자동으로 생성됩니다.
    
    // 정적 팩토리 메서드 (선택적)
    public static ProductRequest of(String name, String description, BigDecimal price, Integer stockQuantity) {
        return new ProductRequest(name, description, price, stockQuantity);
    }
}
