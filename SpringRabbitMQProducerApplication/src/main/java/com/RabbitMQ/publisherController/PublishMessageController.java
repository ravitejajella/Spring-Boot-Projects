package com.RabbitMQ.publisherController;

import java.util.Date;
import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.RabbitMQ.mq.MQConfig;
import com.RabbitMQ.mq.Message;

@RestController
public class PublishMessageController {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@PostMapping("/publish")
	public String publishMessage(@RequestBody Message message) {
		message.setMessageId(UUID.randomUUID().toString());
		message.setMessageDate(new Date());
		System.out.println(message.getMessageId());
		rabbitTemplate.convertAndSend(MQConfig.EXCHANGE, MQConfig.ROUTING_KEY,message);
		return "Message Posted";
	}
	
	
}
