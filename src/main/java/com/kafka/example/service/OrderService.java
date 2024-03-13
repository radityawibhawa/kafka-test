package com.kafka.example.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.kafka.example.DTO.response.OrderResponse;
import com.kafka.example.model.Order;
import com.kafka.example.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private KafkaTemplate<String, Order> kafkaTemplate;

    public OrderResponse createOrder(Order order){
        order.setId(UUID.randomUUID().toString()); // generate a random UUID for id
        order.setOrderId(UUID.randomUUID()); // generate a random UUID for orderId

        Order savedOrder = orderRepository.save(order);
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setId(savedOrder.getId());
        orderResponse.setOrderId(savedOrder.getOrderId());
        orderResponse.setRestaurant(savedOrder.getRestaurant());
        orderResponse.setFood(savedOrder.getFood());
        orderResponse.setHarga(savedOrder.getHarga());
        kafkaTemplate.send("orders", savedOrder);
        return orderResponse;
    }
}
