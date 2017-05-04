package com.apple.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apple.entity.UserSolrDocument;
import com.apple.repos.UserSolrDocRepository;
import com.apple.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserSolrDocRepository userSolrDocRepository;

	@Override
	public UserSolrDocument save(UserSolrDocument user) {
		userSolrDocRepository.save(user);
		return user;
	}


}
