package com.soa.OrderServiceApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PurchaseLineItems {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long productCode;

    @Override
    public String toString() {
        return "PurchaseLineItems{" +
                "id=" + id +
                ", productCode=" + productCode +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }

    private Double price;
    private Integer quantity;
    public PurchaseLineItems() {
    }

    public PurchaseLineItems(Long productCode, Double price, Integer quantity) {
        this.productCode = productCode;
        this.price = price;
        this.quantity = quantity;
    }
}
