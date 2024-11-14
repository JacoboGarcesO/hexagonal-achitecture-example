package com.example.logic.users;

import com.example.dtos.users.CreateUserDTO;
import com.example.dtos.users.UserDTO;
import com.example.entities.User;
import com.example.ports.IMessageBrokerPort;
import com.example.ports.IUserRepositoryPort;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Component
public class CreateUserUseCase implements Function<UserDTO, Mono<UserDTO>> {
  private final IUserRepositoryPort userRepository;
  private final IMessageBrokerPort broker;

  public CreateUserUseCase(IUserRepositoryPort userRepository, IMessageBrokerPort broker) {
    this.userRepository = userRepository;
    this.broker = broker;
  }

  @Override
  public Mono<UserDTO> apply(UserDTO userDTO) {
    return userRepository.save(new User.Builder()
      .name(userDTO.getName())
      .email(userDTO.getEmail())
      .address(userDTO.getAddress())
      .build())
      .map(user -> {
        CreateUserDTO createdUser = CreateUserDTO.builder()
          .id(user.getId())
          .name(user.getName())
          .email(user.getEmail())
          .address(user.getAddress())
          .build();
        broker.send(createdUser);
        return createdUser;
      });
  }
}
