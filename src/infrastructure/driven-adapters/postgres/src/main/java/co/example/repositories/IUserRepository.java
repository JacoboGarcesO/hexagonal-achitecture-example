package co.example.repositories;

import co.example.entities.UserEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public interface IUserRepository extends ReactiveCrudRepository<UserEntity, Integer> {
}
