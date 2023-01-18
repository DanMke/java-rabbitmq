package com.orderservice.createorder.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.orderservice.createorder.model.Order;

@Service
public class RabbitMQSender {
  @Autowired
	private AmqpTemplate amqpTemplate;
	
	@Value("${order.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${order.rabbitmq.routingkey}")
	private String routingkey;	
	
	public void send(Order order) {
		amqpTemplate.convertAndSend(exchange, routingkey, order);
		System.out.println("Send msg = " + order);
	    
	}
}
