package com.apple.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.apple.dtos.UserDTO;
import com.apple.dtos.UserProfileDTO;
import com.apple.dtos.request.SearchRequestDTO;
import com.apple.entity.UserSolrDocument;
import com.apple.repos.UserSolrDocRepository;
import com.apple.services.ValidatorService;

@Service
public class ValidatorServiceImpl implements ValidatorService {

	@Autowired
	private UserSolrDocRepository userRepo;

	@Override
	public void validateSearchRequest(SearchRequestDTO searchRequest) throws Exception {
		if (searchRequest == null) {
			throw new Exception("Request Object cannot be null");
		}
		if(null==searchRequest.getSortByField()){
			searchRequest.setSortByField("name");
		}
	}

	@Override
	public void validateUserSaveRequest(UserDTO user) throws Exception {
		if (null == user) {
			throw new Exception( "Request Failed: Empty request recieved");
		}
		
		if (null == user.getId()) {
			throw new Exception("Required filed missing : Id");
		}

		UserSolrDocument solrDoc = userRepo.findOne(user.getId());
		if (null != solrDoc) {
			throw new Exception("Request Failed: Invalid Id or Id already exists");
		}

		List<UserSolrDocument> listOfSolrDoc = userRepo.findByNickname(user.getNickname(), new PageRequest(0, 1));
		if (null != listOfSolrDoc && !listOfSolrDoc.isEmpty()) {
			throw new Exception("Request Failed: User already exists with this name");
		}

	}

	@Override
	public UserSolrDocument validateUserProfileSaveRequest(UserProfileDTO userProfileDTO, String id) throws Exception {
		
		if (null == userProfileDTO) {
			throw new Exception("Request Failed: Empty request recieved");
		}
		
		if (null == userProfileDTO.getId()) {
			throw new Exception("Required filed missing : Id");
		}

		if(null==id){
			throw new Exception("Required filed missing : Id");
		}
		
		if(!id.equals(userProfileDTO.getId())){
			throw new Exception("Request Failed : Id doesn't match with profile id ");
		}
		
		UserSolrDocument solrDoc = userRepo.findOne(userProfileDTO.getId());
		if (null == solrDoc) {
			throw new Exception("Request Failed: Invalid Id or Id doesn't exists");
		}

		return solrDoc;

	}
}
