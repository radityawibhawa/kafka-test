package com.kafka.example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.kafka.example.model.Order;

public interface OrderRepository extends MongoRepository<Order, String>{

}
