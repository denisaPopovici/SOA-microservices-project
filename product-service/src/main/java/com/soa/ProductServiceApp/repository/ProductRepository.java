package com.soa.ProductServiceApp.repository;

import com.soa.ProductServiceApp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
