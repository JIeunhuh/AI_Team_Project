package edu.pnu.service;

import java.util.List;

import edu.pnu.domain.UserEntity;

public interface UserService {
	String getUser(UserEntity user);
	void createUser(UserEntity user);
	List<UserEntity> getAllUsers();
	UserEntity authenticate(String id, String pw);
		
}
