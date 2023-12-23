package com.soa.ProductServiceApp.service;

import com.soa.ProductServiceApp.dao.ProductRequest;
import com.soa.ProductServiceApp.dao.ProductResponse;
import com.soa.ProductServiceApp.model.Product;
import com.soa.ProductServiceApp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public void addProduct(ProductRequest productRequest) {
        Product product = new Product(productRequest.getName(), productRequest.getDescription(), productRequest.getPrice());
        productRepository.save(product);
    }

    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll().stream().map(this::mapToProductResponse).toList();
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
