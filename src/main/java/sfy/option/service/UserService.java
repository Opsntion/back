package sfy.option.service;

import io.jsonwebtoken.Jwt;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sfy.option.exception.UserIdAndPasswordException;
import sfy.option.model.entity.UserEntity;
import sfy.option.repository.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final JwtService jwtService;

    public boolean signup(UserEntity userEntity) {
        if (userRepository.existsById(userEntity.getId())) {
            throw new UserIdAndPasswordException();
        }

        userRepository.save(userEntity);
        return true;
    }

    public String login(UserEntity userEntity) {
        Optional<UserEntity> storedUser = userRepository.findById(userEntity.getId());

        if (storedUser.isEmpty()) {
            throw new UserIdAndPasswordException("Invalid user ID");
        }

        if (!userEntity.getPassword().equals(storedUser.get().getPassword())) {
            throw new UserIdAndPasswordException("Invalid password");
        }

        return jwtService.create("id", userEntity.getId(), userEntity.getPassword());
    }

    public boolean logout(UserEntity userEntity) {
        return true;
    }
}
