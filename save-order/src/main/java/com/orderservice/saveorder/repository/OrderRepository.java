package com.orderservice.saveorder.repository;

import com.orderservice.saveorder.model.Order;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {

}
