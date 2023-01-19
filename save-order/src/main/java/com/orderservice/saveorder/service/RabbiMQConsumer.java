package com.orderservice.saveorder.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.orderservice.saveorder.model.Order;
import com.orderservice.saveorder.repository.OrderRepository;

@Component
public class RabbiMQConsumer {

	@Autowired
	private OrderRepository orderRepository;

  @RabbitListener(queues = "${order.rabbitmq.queue}")
	public void recievedMessage(Order order) {
		
		System.out.println("Recieved Message From RabbitMQ: " + order.toString());

		orderRepository.save(order);
	} 
  
}
