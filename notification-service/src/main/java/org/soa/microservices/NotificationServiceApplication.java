package org.soa.microservices;

import lombok.extern.slf4j.Slf4j;
import org.soa.microservices.rabbitMQ.CustomProductMessage;
import org.soa.microservices.rabbitMQ.MQConfig;
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
        try {
            //send out an email/SMS notification ---> TO DO
            log.info("Received notification for order - {}", purchasePlacedEvent);
        } catch (IllegalStateException exception) {
            System.out.println("I am dying...");
        }
    }

    @RabbitListener(queues = MQConfig.QUEUE)
    public void handleMQNotification(CustomProductMessage productMessage) {
        log.info("Received notification for new product: {}", productMessage);
    }
}
