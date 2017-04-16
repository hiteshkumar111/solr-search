package com.apple.services;

import com.apple.dtos.request.UserRequestDTO;
import com.apple.dtos.response.UserResponseDTO;

public interface UserService {

	UserResponseDTO save(UserRequestDTO userRequestDTO);
	
}
