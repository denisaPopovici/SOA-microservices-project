package com.soa.OrderServiceApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseRequest {
    private List<PurchaseLineItemsDto> purchaseLineItemsDtoList;
}
