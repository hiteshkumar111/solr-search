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
import com.apple.repos.UserSolrDocRepository;
import com.apple.services.UserService;
import com.apple.utils.HttpClientUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserSolrDocRepository userSolrDocRepository;

	@Autowired
	private UserMapper mapper;

	@Resource
	private Environment env;

	static final String RAZOR_API_BASE_URL = "razor.baseurl";

	@Override
	public UserSolrDocument save(UserSolrDocument user) {
		userSolrDocRepository.save(user);
		return user;
	}

	@Override
	public UserRequestDTO createUser(UserRequestDTO userRequestDTO) {
		try{
			String userServieURL        = env.getRequiredProperty(RAZOR_API_BASE_URL) + env.getRequiredProperty("razor.user");
			String userProfileServieURL = env.getRequiredProperty(RAZOR_API_BASE_URL) + env.getRequiredProperty("razor.user-profile");
			Map<String, String> headers = new HashMap<String, String>();
		//	headers.put("Content-Type","application/json");
			UserDTO userDTO 			= mapper.convertToUserDTO(userRequestDTO);
			UserProfileDTO userProfile 	= mapper.convertToUserProfileDTO(userRequestDTO);

			userDTO 					= HttpClientUtil.post(userServieURL, userDTO, UserDTO.class, headers);

			userProfile 				= HttpClientUtil.post(userProfileServieURL, userProfile, UserProfileDTO.class, headers);
			return userRequestDTO;
		}catch(Exception e){
			e.printStackTrace();
			throw new RazorServiceAPIException(ErrorCode.SAVE_OR_UPDATE_FAILED,"Razor service throwed exception",e);
		}
		
		
	}

}
