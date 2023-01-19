package com.order.orderapi.repository;

import com.order.orderapi.model.Order;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {

  Order findByCodigoPedido(int codigoPedido);

  List<Order> findByCodigoCliente(int codigoCliente);

}
