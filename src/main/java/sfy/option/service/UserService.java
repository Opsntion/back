package sfy.option.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sfy.option.model.entity.UserEntity;

@Service
@RequiredArgsConstructor
public class UserService {


	public boolean createUser(UserEntity userEntity) {
		return true;
	}

	public boolean login(UserEntity userEntity) {
		return true;
	}

}
