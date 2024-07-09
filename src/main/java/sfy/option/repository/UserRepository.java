package sfy.option.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sfy.option.model.entity.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, String> {
    boolean existsById(String id);

    Optional<UserEntity> findById(String id);
}