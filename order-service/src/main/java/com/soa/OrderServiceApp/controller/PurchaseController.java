package com.soa.OrderServiceApp.controller;

import com.soa.OrderServiceApp.dto.PurchaseRequest;
import com.soa.OrderServiceApp.dto.PurchaseResponse;
import com.soa.OrderServiceApp.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/purchase")
public class PurchaseController {
    private final PurchaseService purchaseService;

    @Autowired
    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String purchase(@RequestBody PurchaseRequest purchaseRequest) throws IllegalAccessException {
        purchaseService.purchase(purchaseRequest);
        return "Order placed successfully!";
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PurchaseResponse> getAllPurchases() {
        return purchaseService.getAllPurchases();
    }
}
