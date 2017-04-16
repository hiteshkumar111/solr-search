package com.apple.serviceImpl;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apple.entity.User;
import com.apple.repos.UserRepository;
import com.apple.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional
	public User save(User user) {
		userRepository.save(user);
		return user;
	}

}
