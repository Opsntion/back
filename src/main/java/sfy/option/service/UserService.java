package sfy.option.service;

import io.jsonwebtoken.Jwt;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sfy.option.exception.UserIdAndPasswordException;
import sfy.option.model.entity.UserEntity;
import sfy.option.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;
	private final JwtService jwtService;

	public String createUser(UserEntity userEntity) {
		if (userRepository.existsById(userEntity.getId())) {
			throw new UserIdAndPasswordException();
		}

		userRepository.save(userEntity);
		return jwtService.create("id", userEntity.getId(), userEntity.getPassword());
	}

	public String login(UserEntity userEntity) {
		if (userRepository.existsById(userEntity.getId())) {
			throw new UserIdAndPasswordException();
		}

        return jwtService.create("id", userEntity.getId(), userEntity.getPassword());
	}

	public boolean logout(UserEntity userEntity) {
		return true;
	}
}
