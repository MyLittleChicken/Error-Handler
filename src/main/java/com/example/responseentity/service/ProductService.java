package com.example.responseentity.service;

import com.example.responseentity.dto.ProductRequest;
import com.example.responseentity.dto.ProductResponse;
import com.example.responseentity.exception.ProductNotFoundException;
import com.example.responseentity.model.Product;
import com.example.responseentity.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    
    private final ProductRepository productRepository;
    
    // 생성자 주입
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    
    // 상품 생성
    @Transactional
    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .stockQuantity(productRequest.stockQuantity())
                .build();
        
        Product savedProduct = productRepository.save(product);
        return mapToResponse(savedProduct);
    }
    
    // 전체 상품 조회
    @Transactional(readOnly = true)
    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }
    
    // 특정 상품 조회 (ID로)
    @Transactional(readOnly = true)
    public ProductResponse getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
        
        return mapToResponse(product);
    }
    
    // 상품 업데이트
    @Transactional
    public ProductResponse updateProduct(Long id, ProductRequest productRequest) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
        
        product.setName(productRequest.name());
        product.setDescription(productRequest.description());
        product.setPrice(productRequest.price());
        product.setStockQuantity(productRequest.stockQuantity());
        
        Product updatedProduct = productRepository.save(product);
        return mapToResponse(updatedProduct);
    }
    
    // 상품 삭제
    @Transactional
    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException(id);
        }
        productRepository.deleteById(id);
    }
    
    // 엔티티를 DTO로 변환하는 매핑 함수
    private ProductResponse mapToResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getStockQuantity()
        );
    }
}
