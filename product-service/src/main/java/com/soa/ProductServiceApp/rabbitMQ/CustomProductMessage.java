package com.soa.ProductServiceApp.rabbitMQ;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomProductMessage {
    private String messageId;
    private String productName;
    private Date messageDate;
}
