package com.orderservice.createorder.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitHelper {
  @Value("${order.rabbitmq.queue}")
	String queueName;

	@Value("${order.rabbitmq.exchange}")
	String exchangeName;

	@Value("${order.rabbitmq.routingkey}")
	private String routingkey;

  @Autowired
  private RabbitAdmin rabbitAdmin;

	@Bean
	Queue queue() {
		Queue queue = new Queue(queueName, false);
		rabbitAdmin.declareQueue(queue);
		return queue;
	}

	@Bean
	DirectExchange exchange() {
		DirectExchange exchange = new DirectExchange(exchangeName);
		rabbitAdmin.declareExchange(exchange);
		return exchange;
	}

	@Bean
	Binding binding(Queue queue, DirectExchange exchange) {
		Binding binding = BindingBuilder.bind(queue).to(exchange).with(routingkey);
		rabbitAdmin.declareBinding(binding);
		return binding;
	}

}
