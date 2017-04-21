package com.apple.serviceImpl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.apple.dtos.UserDTO;
import com.apple.dtos.UserProfileDTO;
import com.apple.dtos.request.UserRequestDTO;
import com.apple.entity.UserSolrDocument;
import com.apple.exceptions.ErrorCode;
import com.apple.exceptions.RazorServiceAPIException;
import com.apple.mapper.UserMapper;
import com.apple.repos.UserRepository;
import com.apple.services.UserService;
import com.apple.utils.HttpClientUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserMapper mapper;

	@Resource
	private Environment env;

	static final String RAZOR_API_BASE_URL = "razor.baseurl";

	@Override
	public UserSolrDocument save(UserSolrDocument user) {
		userRepository.save(user);
		return user;
	}

	@Override
	public UserRequestDTO createUser(UserRequestDTO userRequestDTO) {
		try{
			String url 					= env.getRequiredProperty(RAZOR_API_BASE_URL) + env.getRequiredProperty("razor.user");
			Map<String, String> headers = new HashMap<String, String>();
			UserDTO userDTO 			= mapper.map(userRequestDTO, UserDTO.class);
			UserProfileDTO userProfile 	= mapper.map(userRequestDTO, UserProfileDTO.class);
			userDTO 					= HttpClientUtil.post(url, userDTO, UserDTO.class, headers);
			userProfile 				= HttpClientUtil.post(url, userProfile, UserProfileDTO.class, headers);
			return userRequestDTO;
		}catch(Exception e){
			e.printStackTrace();
			throw new RazorServiceAPIException(ErrorCode.SAVE_OR_UPDATE_FAILED,"Razor service throwed exception",e);
		}
		
		
	}

}
