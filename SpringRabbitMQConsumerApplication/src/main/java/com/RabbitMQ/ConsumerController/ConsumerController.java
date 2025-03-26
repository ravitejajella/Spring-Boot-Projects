package com.RabbitMQ.ConsumerController;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.RabbitMQ.MQConfig;
import com.RabbitMQ.Message;

@Component
public class ConsumerController {

	@RabbitListener(queues=MQConfig.QUEUE)
	public void listener(Message message) {
		System.out.println(message);
	}
	
	
}
