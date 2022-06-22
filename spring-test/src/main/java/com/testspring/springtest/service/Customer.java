
package com.testspring.springtest.service;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Customer{

	private static final Logger logger = LogManager.getFormatterLogger( Customer.class);

	@KafkaListener(topics = "kafka", groupId = "myGroup")
	public void consume(String message) throws IOException {
		logger.info("Consume Message: %s", message);
	}
}
