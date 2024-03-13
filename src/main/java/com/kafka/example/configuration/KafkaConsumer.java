package com.kafka.example.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kafka.example.model.Order;

@Service
public class KafkaConsumer {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @KafkaListener(topics = "orders", groupId = "group_id")
    public void consume(Order order){
        String sql = "INSERT INTO \"order\" (order_id, food, restaurant, harga) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, order.getOrderId(), order.getFood(), order.getRestaurant(), order.getHarga());
    }
}

