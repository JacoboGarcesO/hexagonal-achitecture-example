package co.example;

import co.example.entities.UserEntity;
import co.example.repositories.IUserRepository;
import com.example.dtos.users.CreateUserDTO;
import com.example.entities.User;
import com.example.ports.IUserRepositoryPort;
import reactor.core.publisher.Mono;

public class UserRepositoryAdapter implements IUserRepositoryPort {
  private final IUserRepository userRepository;

  public UserRepositoryAdapter(IUserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public Mono<CreateUserDTO> save(User user) {
    return userRepository.save(UserEntity.builder()
      .name(user.getName())
      .email(user.getEmail())
      .address(user.getAddress())
      .build())
      .map(userEntity -> (CreateUserDTO) CreateUserDTO.builder()
        .id(userEntity.getId())
        .name(userEntity.getName())
        .email(userEntity.getEmail())
        .address(userEntity.getAddress())
        .build());
  }

  @Override
  public Mono<CreateUserDTO> findById(Integer id) {
    return null;
  }
}
