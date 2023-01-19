package com.order.orderapi.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.order.orderapi.model.Order;
import com.order.orderapi.repository.OrderRepository;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

  @Autowired
	private OrderRepository orderRepository;

  @RequestMapping(method=RequestMethod.GET, value = "/{codigoCliente}/orders")
  public List<Order> getCustomerOrders(@PathVariable int codigoCliente) {
    return orderRepository.findByCodigoCliente(codigoCliente);
  }

  @RequestMapping(method=RequestMethod.GET, value = "/{codigoCliente}/orders/quantity")
  public Map<String, Integer> getCustomerOrdersQuantity(@PathVariable int codigoCliente) {
    int quantity = orderRepository.findByCodigoCliente(codigoCliente).size();
    return Map.of("quantity", quantity);
  }
  
}
