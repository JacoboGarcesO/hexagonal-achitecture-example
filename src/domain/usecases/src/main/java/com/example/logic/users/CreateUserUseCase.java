package com.example.logic.users;

import com.example.dtos.users.CreateUserDTO;
import com.example.dtos.users.UserDTO;
import com.example.entities.User;
import com.example.ports.IUserRepositoryPort;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Component
public class CreateUserUseCase implements Function<UserDTO, Mono<UserDTO>> {
  private final IUserRepositoryPort userRepository;

  public CreateUserUseCase(IUserRepositoryPort userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public Mono<UserDTO> apply(UserDTO userDTO) {
    return userRepository.save(new User.Builder()
      .name(userDTO.getName())
      .email(userDTO.getEmail())
      .address(userDTO.getAddress())
      .build())
      .map(user -> CreateUserDTO.builder()
        .id(user.getId())
        .name(user.getName())
        .email(user.getEmail())
        .address(user.getAddress())
        .build());
  }
}
