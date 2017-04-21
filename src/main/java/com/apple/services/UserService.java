package com.apple.services;

import com.apple.dtos.request.UserRequestDTO;
import com.apple.entity.UserSolrDocument;

public interface UserService {

	UserSolrDocument save(UserSolrDocument User);

	UserRequestDTO createUser(UserRequestDTO userRequestDTO);
	
}
