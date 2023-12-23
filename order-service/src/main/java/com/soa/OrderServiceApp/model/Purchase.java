package com.soa.OrderServiceApp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Getter
@Setter
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String purchaseNumber;
    @OneToMany(cascade = CascadeType.ALL)
    private List<PurchaseLineItems> purchaseLineItemsList;

    public Purchase(String purchaseNumber, List<PurchaseLineItems> purchaseLineItemsList) {
        this.purchaseNumber = purchaseNumber;
        this.purchaseLineItemsList = purchaseLineItemsList;
    }

    public Purchase(){}
}
