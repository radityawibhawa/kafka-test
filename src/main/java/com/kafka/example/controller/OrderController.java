package com.kafka.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.example.DTO.response.OrderResponse;
import com.kafka.example.model.Order;
import com.kafka.example.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@RequestBody Order order){
        OrderResponse orderResponse = orderService.createOrder(order);
        return new ResponseEntity<>(orderResponse, HttpStatus.CREATED);
    }
}
