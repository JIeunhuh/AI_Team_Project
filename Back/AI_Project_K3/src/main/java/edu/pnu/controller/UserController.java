package edu.pnu.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.UserEntity;
import edu.pnu.service.UserService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class UserController {

	private final UserService userService;

	// create Member
	@PostMapping("/signup")
	public ResponseEntity<String> signUp(@RequestBody UserEntity user) {
		try {
			userService.createUser(user);
			return ResponseEntity.ok("계정이 생성되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	// get x , post o
	// login
	@PostMapping("/login")
	public ResponseEntity<String> signIn(@RequestBody UserEntity user) {
		try {
			userService.getUser(user);
			return ResponseEntity.ok("login success");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
