package com.soa.OrderServiceApp.service;

import com.soa.OrderServiceApp.dto.InventoryResponse;
import com.soa.OrderServiceApp.dto.PurchaseLineItemsDto;
import com.soa.OrderServiceApp.dto.PurchaseRequest;
import com.soa.OrderServiceApp.model.Purchase;
import com.soa.OrderServiceApp.model.PurchaseLineItems;
import com.soa.OrderServiceApp.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class PurchaseService {
    private final PurchaseRepository purchaseRepository;
    private final WebClient.Builder webClientBuilder;

    @Autowired
    public PurchaseService(PurchaseRepository purchaseRepository, WebClient.Builder webClientBuilder) {
        this.purchaseRepository = purchaseRepository;
        this.webClientBuilder = webClientBuilder;
    }

    public void purchase(PurchaseRequest purchaseRequest) throws IllegalAccessException {
        Purchase purchase = new Purchase();
        purchase.setPurchaseNumber(UUID.randomUUID().toString());
        List<PurchaseLineItems> purchaseLineItemsList = purchaseRequest.getPurchaseLineItemsDtoList().stream().map(this::mapFromDto).toList();
        purchase.setPurchaseLineItemsList(purchaseLineItemsList);

        List<Long> productCodes = purchase.getPurchaseLineItemsList()
                .stream()
                .map(PurchaseLineItems::getProductCode)
                .toList();


        //place order only if the product is in stock
        InventoryResponse[] inventoryResponseArr = webClientBuilder.build().get()
                .uri("http://inventory-service/api/inventory",
                        uriBuilder -> uriBuilder.queryParam("productCodes", productCodes).build())
                .retrieve()
                .bodyToMono(InventoryResponse[].class) //needed in order to read the data
                .block(); //make synchronous request

        boolean allProductsInStock = Arrays.stream(inventoryResponseArr).allMatch(InventoryResponse::isInStock);
        if(Boolean.TRUE.equals(allProductsInStock)) {
            purchaseRepository.save(purchase);
        }
        else {
            throw new IllegalAccessException("This product is not currently in stock!");
        }
    }

    private PurchaseLineItems mapFromDto(PurchaseLineItemsDto purchaseLineItemsDto) {
        PurchaseLineItems purchaseLineItems = new PurchaseLineItems();
        purchaseLineItems.setPrice(purchaseLineItemsDto.getPrice());
        purchaseLineItems.setQuantity(purchaseLineItemsDto.getQuantity());
        purchaseLineItems.setProductCode((purchaseLineItemsDto.getProductCode()));
        return purchaseLineItems;
    }
}
