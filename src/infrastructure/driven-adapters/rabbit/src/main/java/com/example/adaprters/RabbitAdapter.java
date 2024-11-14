package com.example.adaprters;

import com.example.ports.IMessageBrokerPort;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RabbitAdapter implements IMessageBrokerPort {
  private final RabbitTemplate rabbitTemplate;
  @Value("${rabbit.exchange-name}")
  private String exchangeName;

  @Value("${rabbit.routing-key}")
  private String routingKey;

  public RabbitAdapter(RabbitTemplate rabbitTemplate) {
    this.rabbitTemplate = rabbitTemplate;
  }

  @Override
  public void send(Object payload) {
    rabbitTemplate.convertAndSend(exchangeName, routingKey, payload);
  }
}
