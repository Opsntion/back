package sfy.option.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sfy.option.model.entity.UserEntity;
import sfy.option.service.UserService;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService UserService;

    @PostMapping("/signup")
    public ResponseEntity<Boolean> signup(@RequestBody UserEntity userEntity) {
        return ResponseEntity.ok(UserService.signup(userEntity));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserEntity userEntity) {
        return ResponseEntity.ok(UserService.login(userEntity));
    }

    @PostMapping("/logout")
    public ResponseEntity<Boolean> logout(@RequestBody UserEntity userEntity) {
        return ResponseEntity.ok(UserService.logout(userEntity));
    }
}