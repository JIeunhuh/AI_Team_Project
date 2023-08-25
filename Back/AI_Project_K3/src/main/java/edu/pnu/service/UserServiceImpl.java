package edu.pnu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import edu.pnu.domain.UserEntity;
import edu.pnu.persistence.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	// sign in
	@Override
	public UserEntity getUser(UserEntity user) {
		// find user	
		Optional<UserEntity> findUser = userRepo.findByUsername(user.getUsername());
		// user가 DB에 있으면 정보 가져옴
		if(findUser.isPresent())
			return findUser.get();
		return null;
	}

	// sign up
	@Override
	public void createUser(UserEntity user) {
		user.setUsername(user.getUsername());
		// 패스워드 암호화
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setUser_pw_chk(passwordEncoder.encode(user.getUser_pw_chk()));
		user.setName(user.getName());
		user.setEmail(user.getEmail());
		user.setBirth(user.getBirth());
		user.setAuthority("ROLE_MEMBER");
		
		userRepo.save(user);
	}

	@Override
	public List<UserEntity> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}
	
	// authenticate
	@Override
	public UserEntity authenticate(String id, String pw) {
		// TODO Auto-generated method stub
		return null;
	}

}
