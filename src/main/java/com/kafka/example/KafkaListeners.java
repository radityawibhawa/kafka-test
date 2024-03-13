package com.kafka.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.kafka.example.model.Order;

@Component
public class KafkaListeners {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @KafkaListener(topics = "test", groupId = "groupId")
    public void listener(Order order){
        try {
            String sql = "INSERT INTO \"order\" (orderId, food, restaurant, harga) VALUES (?, ?, ?, ?)";
            jdbcTemplate.update(sql, order.getOrderId(), order.getFood(), order.getRestaurant(), order.getHarga());
            System.out.println("Data successfully inserted into PostgreSQL");
        } catch (Exception e) {
            System.out.println("Failed to insert data into PostgreSQL");
            e.printStackTrace();
        }
    }
}

