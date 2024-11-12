package com.example;

import com.example.dtos.users.UserDTO;
import com.example.handlers.CreateUserHandler;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@RequestMapping("api/users")
@RestController
public class UserController {
  private final CreateUserHandler createUserHandler;

  @PostMapping
  public Mono<ResponseEntity<UserDTO>> createUser(@Valid @RequestBody UserDTO user) {
    return createUserHandler.execute(user).map(ResponseEntity::ok);
  }
}
