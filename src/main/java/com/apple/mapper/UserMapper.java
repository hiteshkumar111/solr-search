package com.apple.mapper;

import java.util.Date;

import org.bson.Document;
import org.springframework.stereotype.Component;

import com.apple.dtos.UserDTO;
import com.apple.dtos.UserProfileDTO;
import com.apple.dtos.request.UserRequestDTO;
import com.apple.entity.UserSolrDocument;
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

	public UserSolrDocument map(Document doc) {
		UserSolrDocument userSolrDoc = new UserSolrDocument();
		ObjectMapper mapper 	= new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		UserProfileDTO profile 	=  mapper.convertValue(doc.get("profile"), UserProfileDTO.class);
		
		if(null!=profile){
			userSolrDoc			= convertToUserSolrDoc(profile, userSolrDoc);
		}else{
			userSolrDoc.setBio(doc.getString("bio"));
			userSolrDoc.setCompany(doc.getString("company"));
			userSolrDoc.setExpertise(doc.getString("expertise"));
			userSolrDoc.setLocation(doc.getString("expertise"));
			userSolrDoc.setOccupation(doc.getString("occupation"));
			userSolrDoc.setTitle(doc.getString("title"));
			userSolrDoc.setUrl(doc.getString("url"));
		}
		
		userSolrDoc.setId(doc.getLong("id")+"");
		userSolrDoc.setNickname(doc.getString("nickname"));
		userSolrDoc.setAvatarId(doc.getString("avtarId"));
		
		Date memberSince 		= null;
		if(null!=doc.getLong("memberSince")){
			memberSince 		= new Date(doc.getLong("memberSince"));
		}
		userSolrDoc.setMemberSince(memberSince);
		return userSolrDoc;
	}
	
}

