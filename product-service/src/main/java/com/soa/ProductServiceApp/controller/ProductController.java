package com.soa.ProductServiceApp.controller;

import com.soa.ProductServiceApp.rabbitMQ.CustomProductMessage;
import com.soa.ProductServiceApp.rabbitMQ.MQConfig;
import com.soa.ProductServiceApp.dao.ProductRequest;
import com.soa.ProductServiceApp.dao.ProductResponse;
import com.soa.ProductServiceApp.service.ProductService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    private final ProductService productService;
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public ProductController(ProductService productService, RabbitTemplate rabbitTemplate){
        this.productService = productService;
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addProduct(@RequestBody ProductRequest product) {
        productService.addProduct(product);
    }

    @PostMapping("/publish")
    public String publishMessage(@RequestBody CustomProductMessage message) {
        message.setMessageId(UUID.randomUUID().toString());
        message.setMessageDate(new Date());
        rabbitTemplate.convertAndSend(MQConfig.EXCHANGE,
                MQConfig.ROUTING_KEY, message);

        return "Message Published";
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }
}
