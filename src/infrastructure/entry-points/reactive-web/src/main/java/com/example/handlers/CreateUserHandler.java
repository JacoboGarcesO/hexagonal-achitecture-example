package com.example.handlers;

import com.example.dtos.users.UserDTO;
import com.example.logic.users.CreateUserUseCase;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class CreateUserHandler {
  private final CreateUserUseCase createUserUseCase;

  public CreateUserHandler(CreateUserUseCase createUserUseCase) {
    this.createUserUseCase = createUserUseCase;
  }

  public Mono<UserDTO> execute(UserDTO userDTO) {
    return createUserUseCase.apply(userDTO);
  }
}
