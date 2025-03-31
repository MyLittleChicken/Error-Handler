package com.example.responseentity.exception;

public class InsufficientStockException extends RuntimeException {
    
    public InsufficientStockException(Long productId, int requested, int available) {
        super(String.format("상품(ID: %d)의 재고가 부족합니다. 요청: %d, 가용: %d", 
                productId, requested, available));
    }
}
