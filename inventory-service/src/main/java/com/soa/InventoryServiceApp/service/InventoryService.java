package com.soa.InventoryServiceApp.service;

import com.soa.InventoryServiceApp.dto.InventoryResponse;
import com.soa.InventoryServiceApp.model.Inventory;
import com.soa.InventoryServiceApp.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    @Autowired
    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Transactional(readOnly = true)
    public List<InventoryResponse> isInStock(List<Long> productCodes) {
        return inventoryRepository.findByProductCodeIn(productCodes).stream()
                .map(inventory ->
                            InventoryResponse.builder()
                                    .productCode(inventory.getProductCode())
                                    .isInStock(inventory.getQuantity() > 0)
                                    .build()
                ).toList();
    }
}
