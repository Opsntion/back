package sfy.option.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sfy.option.model.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    boolean existsById(String id);
}