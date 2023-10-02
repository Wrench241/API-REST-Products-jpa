package com.products.apirest.services;

import com.products.apirest.model.ProductCreatedEvent;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void createEvent(ProductCreatedEvent event){
        rabbitTemplate.convertAndSend("TestExchanges","fila.product",event);
    }
}