package com.RkExample.orderservice.controller;

import com.RkExample.basedomains.dto.Order;
import com.RkExample.basedomains.dto.OrderEvent;
import com.RkExample.orderservice.kafka.OrderProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

    private OrderProducer orderProducer;
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @PostMapping("/orders")
    public ResponseEntity<String> produceOrder(@RequestBody Order order){
        order.setOrderId(UUID.randomUUID().toString().substring(1,10));
        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setStatus("PENDING");
        orderEvent.setMessage("Order status in pending state");
        orderEvent.setOrder(order);
        logger.info("before kafka topic produce");
        orderProducer.sendMessage(orderEvent);
        logger.info("after kafka topic produce");
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body("Message Produced Successfully...");
    }
}
