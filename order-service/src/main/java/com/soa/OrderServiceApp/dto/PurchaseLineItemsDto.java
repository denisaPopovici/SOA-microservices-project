package com.soa.OrderServiceApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseLineItemsDto {
    private Long id;
    private Long productCode;
    private Double price;
    private Integer quantity;
}
