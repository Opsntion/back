package sfy.option.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sfy.option.model.entity.UserEntity;
import sfy.option.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	public boolean createUser(UserEntity userEntity) {
		if (userRepository.existsById(userEntity.getId())) {
			return false;
		}
		userRepository.save(userEntity);
		return true;
	}

	public boolean login(UserEntity userEntity) {
		return true;
	}

	public boolean logout(UserEntity userEntity) {
		return true;
	}
}
