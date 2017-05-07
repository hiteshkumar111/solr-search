package com.apple.mapper;

import org.springframework.stereotype.Component;

import com.apple.dtos.UserDTO;
import com.apple.dtos.UserProfileDTO;
import com.apple.dtos.request.UserRequestDTO;
import com.apple.entity.UserSolrDocument;
import com.apple.mongodb.entity.User;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import ma.glasnost.orika.impl.ConfigurableMapper;

@Component
public class UserMapper extends ConfigurableMapper implements Imapper {

	public UserDTO convertToUserDTO(UserRequestDTO userRequestDTO){
		UserDTO user = new UserDTO();
		user.setAvatarId(userRequestDTO.getAvatarId());
		user.setId(userRequestDTO.getId());
		user.setNickname(userRequestDTO.getNickname());
		return  user;
	}

	public UserProfileDTO convertToUserProfileDTO(UserRequestDTO userRequestDTO){
		return userRequestDTO.getProfile();
	}

	public UserSolrDocument convertToUserSolrDoc(UserDTO userDto) {
		UserSolrDocument userSolrDoc = new UserSolrDocument();
		userSolrDoc.setAvatarId(userDto.getAvatarId());
		userSolrDoc.setId(userDto.getId());
		userSolrDoc.setNickname(userDto.getNickname());
		return userSolrDoc;
	}

	public UserSolrDocument convertToUserSolrDoc(UserProfileDTO profile, UserSolrDocument userSolrDoc) {
		userSolrDoc.setBio(profile.getBio());
		userSolrDoc.setCompany(profile.getCompany());
		userSolrDoc.setExpertise(profile.getExpertise());
		userSolrDoc.setLocation(profile.getLocation());
		userSolrDoc.setOccupation(profile.getOccupation());
		userSolrDoc.setTitle(profile.getTitle());
		userSolrDoc.setUrl(profile.getUrl());
		return userSolrDoc;
	}


	public UserSolrDocument map(User user) {
		UserSolrDocument userSolrDoc = new UserSolrDocument();
		ObjectMapper mapper 	= new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		UserProfileDTO profile 	=  mapper.convertValue(user.getUserProfileMongo(), UserProfileDTO.class);
		if(null!=profile){
			userSolrDoc			= convertToUserSolrDoc(profile, userSolrDoc);
		}
		userSolrDoc.setId(user.getId());
		userSolrDoc.setNickname(user.getNickname());
		userSolrDoc.setAvatarId(user.getAvatarId());
		userSolrDoc.setMemberSince(user.getMemberSince());
		return userSolrDoc;
	}
	
}

