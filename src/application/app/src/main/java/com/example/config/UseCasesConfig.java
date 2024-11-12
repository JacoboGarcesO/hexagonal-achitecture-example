package com.example.config;

import co.example.UserRepositoryAdapter;
import co.example.repositories.IUserRepository;
import com.example.logic.users.CreateUserUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCasesConfig {
  @Bean
  public UserRepositoryAdapter userRepositoryAdapter(IUserRepository userRepository) {
    return new UserRepositoryAdapter(userRepository);
  }

  @Bean
  public CreateUserUseCase createUserUseCase(UserRepositoryAdapter userRepositoryAdapter) {
    return new CreateUserUseCase(userRepositoryAdapter);
  }
}
