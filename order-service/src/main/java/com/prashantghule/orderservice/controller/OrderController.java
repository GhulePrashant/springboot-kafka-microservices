package com.prashantghule.orderservice.controller;

import com.prashantghule.domainservice.dto.Order;
import com.prashantghule.domainservice.dto.OrderEvent;
import com.prashantghule.orderservice.kafka.OrderKafkaProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("api/v1")
public class OrderController {

    private OrderKafkaProducer orderKafkaProducer;

    public OrderController(OrderKafkaProducer orderKafkaProducer) {
        this.orderKafkaProducer = orderKafkaProducer;
    }


    @PostMapping("/placeorder")
    public String placeOrder(@RequestBody Order order){

        order.setOrderId(UUID.randomUUID().toString());

        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setStatus("PENDING");
        orderEvent.setMessage("Order status is in pending state.");
        orderEvent.setOrder(order);

        orderKafkaProducer.sendMessage(orderEvent);

        return "Order placed successfully...";
    }
}
