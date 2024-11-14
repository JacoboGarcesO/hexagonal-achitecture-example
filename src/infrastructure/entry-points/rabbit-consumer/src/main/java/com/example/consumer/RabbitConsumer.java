package com.example.consumer;

import com.example.dtos.users.CreateUserDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class RabbitConsumer {
  private final Logger logger = Logger.getLogger(RabbitConsumer.class.getName());

  @RabbitListener(queues = "${rabbit.queue-name}")
  public void receive(CreateUserDTO payload) {
    logger.info("Received message: " + payload.getName());
  }
}
