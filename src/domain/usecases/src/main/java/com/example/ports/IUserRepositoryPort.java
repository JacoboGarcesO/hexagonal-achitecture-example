package com.example.ports;

import com.example.dtos.users.CreateUserDTO;
import com.example.entities.User;
import reactor.core.publisher.Mono;

public interface IUserRepositoryPort {
  Mono<CreateUserDTO> save(User user);
  Mono<CreateUserDTO> findById(Integer id);
}
