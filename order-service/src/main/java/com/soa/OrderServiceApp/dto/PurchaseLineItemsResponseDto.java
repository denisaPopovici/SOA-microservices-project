package com.soa.OrderServiceApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseLineItemsResponseDto {
    private String productCode;
    private Double price;
    private Integer quantity;
}
