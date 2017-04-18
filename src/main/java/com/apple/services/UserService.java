package com.apple.services;

import com.apple.entity.User;
import com.apple.entity.UserSolrDocument;

public interface UserService {

	UserSolrDocument save(UserSolrDocument User);
	
}
