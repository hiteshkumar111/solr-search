package com.apple.serviceImpl;

import com.apple.dtos.UserDTO;
import com.apple.dtos.UserProfileDTO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.apple.dtos.request.SearchRequestDTO;
import com.apple.dtos.request.UserRequestDTO;
import com.apple.entity.UserSolrDocument;
import com.apple.exceptions.ErrorCode;
import com.apple.exceptions.InvalidRequestException;
import com.apple.repos.UserSolrDocRepository;
import com.apple.services.ValidatorService;

@Service
public class ValidatorServiceImpl implements ValidatorService {

	@Autowired
	private UserSolrDocRepository userRepo;

	@Override
	public void validateSearchRequest(SearchRequestDTO searchRequest) throws InvalidRequestException {
		if (searchRequest == null) {
			throw new InvalidRequestException(ErrorCode.INVALID_REQUEST, "Request Object cannot be null");
		}
	}

	@Override
	public void validateUserSaveRequest(UserRequestDTO userRequestDTO) {

		if (null == userRequestDTO) {
			throw new InvalidRequestException(ErrorCode.INVALID_REQUEST, "Request failed : Empty request recieved");
		}

		if (null == userRequestDTO.getProfile()) {
			throw new InvalidRequestException(ErrorCode.INVALID_REQUEST, "Required filed missing : Profile");
		}

		if (null == userRequestDTO.getId() || null == userRequestDTO.getProfile().getId()) {
			throw new InvalidRequestException(ErrorCode.INVALID_REQUEST, "Required filed missing : Id");
		}

		if (!userRequestDTO.getProfile().getId().equals(userRequestDTO.getId())) {
			throw new InvalidRequestException(ErrorCode.INVALID_REQUEST,
					"Request failed : Id and profile Id must be same");
		}

	}

	@Override
	public void validateUserSaveRequest(UserDTO user) throws InvalidRequestException {
		if (null == user) {
			throw new InvalidRequestException(ErrorCode.INVALID_REQUEST, "Request Failed: Empty request recieved");
		}
		
		if (null == user.getId()) {
			throw new InvalidRequestException(ErrorCode.INVALID_REQUEST, "Required filed missing : Id");
		}

		UserSolrDocument solrDoc = userRepo.findOne(user.getId());
		if (null != solrDoc) {
			throw new InvalidRequestException(ErrorCode.INVALID_REQUEST, "Request Failed: Invalid Id or Id already exists");
		}

		List<UserSolrDocument> listOfSolrDoc = userRepo.findByNickname(user.getNickname(), new PageRequest(0, 1));
		if (null != listOfSolrDoc && !listOfSolrDoc.isEmpty()) {
			throw new InvalidRequestException(ErrorCode.INVALID_REQUEST,
					"Request Failed: User already exists with this name");
		}

	}

	@Override
	public UserSolrDocument validateUserProfileSaveRequest(UserProfileDTO userProfileDTO, String id) throws InvalidRequestException {
		
		if (null == userProfileDTO) {
			throw new InvalidRequestException(ErrorCode.INVALID_REQUEST, "Request Failed: Empty request recieved");
		}
		
		if (null == userProfileDTO.getId()) {
			throw new InvalidRequestException(ErrorCode.INVALID_REQUEST, "Required filed missing : Id");
		}

		if(null==id){
			throw new InvalidRequestException(ErrorCode.INVALID_REQUEST, "Required filed missing : Id");
		}
		
		if(!id.equals(userProfileDTO.getId())){
			throw new InvalidRequestException(ErrorCode.INVALID_REQUEST, "Request Failed : Id doesn't match with profile id ");
		}
		
		UserSolrDocument solrDoc = userRepo.findOne(userProfileDTO.getId());
		if (null == solrDoc) {
			throw new InvalidRequestException(ErrorCode.INVALID_REQUEST, "Request Failed: Invalid Id or Id doesn't exists");
		}

		return solrDoc;

	}
}
