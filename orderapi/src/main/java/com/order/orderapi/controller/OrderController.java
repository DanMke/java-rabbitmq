package com.order.orderapi.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.order.orderapi.model.Order;
import com.order.orderapi.repository.OrderRepository;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

  @Autowired
	private OrderRepository orderRepository;

  @RequestMapping(method=RequestMethod.GET)
  public List<Order> listOrders() {
    return orderRepository.findAll();
  }

  @RequestMapping(method=RequestMethod.GET, value = "/{codigoPedido}")
  public Order getOrder(@PathVariable int codigoPedido) {
    Order order = orderRepository.findByCodigoPedido(codigoPedido);
    if (order == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found");
    }
    return order;
  }

  @RequestMapping(method=RequestMethod.GET, value = "/{codigoPedido}/value")
  public Map<String, Double> getOrderValue(@PathVariable int codigoPedido) {
    Order order = orderRepository.findByCodigoPedido(codigoPedido);
    if (order == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found");
    }
    double totalValue = 0;
    for (int i = 0; i < order.getItens().length; i++) {
      totalValue += order.getItens()[i].getPreco();
    }
    return Map.of("totalValue", totalValue);
  }
}
