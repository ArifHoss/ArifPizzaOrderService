package com.example.arifpizzaorderservice.controllers;

import com.example.arifpizzaorderservice.messagingrabbit.RabbitMQConfiguration;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    private final RabbitTemplate rabbitTemplate;

    public OrderController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping("/orders")
    String orderPizza(@RequestBody Order newOreder) {
        var orderId = (int) (Math.random() * 10000);
        rabbitTemplate.convertAndSend(RabbitMQConfiguration.topicExchangeName,
                "pizza-key", "Vegetable special");

        return "Thank you for your order " + orderId;
    }

}
