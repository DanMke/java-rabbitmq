package com.orderservice.saveorder.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.orderservice.saveorder.model.Order;

@Component
public class RabbiMQConsumer {

  @RabbitListener(queues = "${order.rabbitmq.queue}")
	public void recievedMessage(Order order) {
		System.out.println("Recieved Message From RabbitMQ: " + order.toString());
	} 
  
}
