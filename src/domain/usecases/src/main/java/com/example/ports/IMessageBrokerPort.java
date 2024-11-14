package com.example.ports;

public interface IMessageBrokerPort {
  void send(Object payload);
}
