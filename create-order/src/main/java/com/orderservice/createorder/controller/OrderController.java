package com.orderservice.createorder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.orderservice.createorder.model.Order;
import com.orderservice.createorder.service.RabbitMQSender;

@RestController
@RequestMapping(value = "/order")
public class OrderController {
  @Autowired
	RabbitMQSender rabbitMQSender;

  @RequestMapping(method=RequestMethod.POST, consumes="application/json")
  public String createOrder(@RequestBody Order order) {
    System.out.println("Order: " + order);
    rabbitMQSender.send(order);
    return "Message sent with Order to the RabbitMQ Successfully";
  }
}
