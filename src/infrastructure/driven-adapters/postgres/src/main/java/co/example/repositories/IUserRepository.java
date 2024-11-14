package co.example.repositories;

import co.example.entities.UserEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface IUserRepository extends ReactiveCrudRepository<UserEntity, Integer> {
}
