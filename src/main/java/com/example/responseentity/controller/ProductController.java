package com.example.responseentity.controller;

import com.example.responseentity.dto.ProductRequest;
import com.example.responseentity.dto.ProductResponse;
import com.example.responseentity.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    
    private final ProductService productService;
    
    // 생성자 주입
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    
    // 상품 생성
    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest productRequest) {
        ProductResponse createdProduct = productService.createProduct(productRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }
    
    // 전체 상품 조회
    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        List<ProductResponse> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }
    
    // 특정 상품 조회 (ID로)
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable Long id) {
        ProductResponse product = productService.getProductById(id);
        return ResponseEntity.ok(product);
    }
    
    // 상품 업데이트
    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable Long id,
                                                        @RequestBody ProductRequest productRequest) {
        ProductResponse updatedProduct = productService.updateProduct(id, productRequest);
        return ResponseEntity.ok(updatedProduct);
    }
    
    // 상품 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/error")
    public ResponseEntity<ProductResponse> throwNullPointerException() {
        throw new NullPointerException("Null Pointer Exception");
    }

}
