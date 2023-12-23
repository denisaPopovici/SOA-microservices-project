package com.soa.ProductServiceApp.controller;

import com.soa.ProductServiceApp.dao.ProductRequest;
import com.soa.ProductServiceApp.dao.ProductResponse;
import com.soa.ProductServiceApp.model.Product;
import com.soa.ProductServiceApp.repository.ProductRepository;
import com.soa.ProductServiceApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addProduct(@RequestBody ProductRequest product) {
        productService.addProduct(product);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }
}
