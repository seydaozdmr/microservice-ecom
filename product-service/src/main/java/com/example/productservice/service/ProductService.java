package com.example.productservice.service;

import com.example.productservice.dto.ProductRequest;
import com.example.productservice.dto.ProductResponse;
import com.example.productservice.model.Product;
import com.example.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;
    
    public void createProduct(ProductRequest productRequest){
        productRepository.save(mapToEntity(productRequest));
        log.warn("Product : {} saved.",productRequest.getName());
    }

    private Product mapToEntity(ProductRequest productRequest) {
        return Product.builder().name(productRequest.getName()).description(productRequest.getDescription()).price(productRequest.getPrice()).build();
    }

    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll().stream().map(this::mapToResponseDto).toList();
    }

    private ProductResponse mapToResponseDto(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
