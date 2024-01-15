package org.soa.microservices;

import lombok.extern.slf4j.Slf4j;
import org.soa.microservices.rabbitMQ.CustomProductMessage;
import org.soa.microservices.rabbitMQ.MQConfig;
import org.soa.microservices.service.CloudFunctionService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
@Slf4j
public class NotificationServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificationServiceApplication.class, args);
    }

    @KafkaListener(topics = "notificationTopic", groupId = "notificationId")
    public void handleKafkaNotification(String purchasePlacedEvent) {
        CloudFunctionService cloudFunctionService = new CloudFunctionService();
        try {
            //send out an email/SMS notification ---> TO DO
            log.info("Received notification for order - {}", purchasePlacedEvent);
            String orderJson = "{ \"orderId\": \"123456\", \"products\": [\"Product1\", \"Product2\", \"Product3\"] }";
            //notify warehouse about new order
            log.info("Response from Google Cloud Function: " + cloudFunctionService.callCloudFunction(orderJson));
        } catch (IllegalStateException exception) {
            System.out.println("I am dying...");
        }
    }

    @RabbitListener(queues = MQConfig.QUEUE)
    public void handleMQNotification(CustomProductMessage productMessage) {
        //send out emails to subscribers about new products ---> TO DO
        log.info("Received notification for new product: {}", productMessage);
    }
}
