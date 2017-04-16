package com.apple.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apple.dtos.request.UserRequestDTO;
import com.apple.dtos.response.UserResponseDTO;
import com.apple.repos.UserRepository;
import com.apple.services.UserService;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserResponseDTO save(UserRequestDTO userRequestDTO){
		//userRepository.save(null);
		return null;
	}
	
}
