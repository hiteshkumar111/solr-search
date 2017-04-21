package com.apple.mapper;

import org.springframework.stereotype.Component;

import com.apple.dtos.UserDTO;
import com.apple.dtos.UserProfileDTO;
import com.apple.dtos.request.UserRequestDTO;
import com.apple.dtos.response.UserResponseDTO;
import com.apple.entity.User;
import com.apple.entity.UserProfile;
import com.apple.entity.UserSolrDocument;

import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.impl.ConfigurableMapper;

@Component
public class UserMapper extends ConfigurableMapper implements Imapper {

	@Override
	public void configure(MapperFactory mapperFactory) {
		mapperFactory.classMap(UserSolrDocument.class, User.class)
				.customize(new CustomMapper<UserSolrDocument, User>() {
					@Override
					public void mapAtoB(UserSolrDocument userSolrDoc, User user, MappingContext context) {
						// TODO Auto-generated method stub
						UserProfile profile = new UserProfile();
						profile.setBio(userSolrDoc.getBio());
						profile.setCompany(userSolrDoc.getCompany());
						profile.setExpertise(userSolrDoc.getExpertise());
						profile.setLocation(userSolrDoc.getLocation());
						profile.setOccupation(userSolrDoc.getOccupation());
						profile.setTitle(userSolrDoc.getTitle());
						profile.setUrl(userSolrDoc.getUrl());
						user.setProfile(profile);
						user.setAvatarId(userSolrDoc.getAvatarId());
						user.setId(userSolrDoc.getId());
						user.setNickname(userSolrDoc.getNickname());

					}
					
					@Override
					public void mapBtoA(User user, UserSolrDocument userSolrDoc, MappingContext context) {
						
						UserProfile profile = user.getProfile();
						userSolrDoc.setAvatarId(user.getAvatarId());
						userSolrDoc.setBio(profile.getBio());
						userSolrDoc.setCompany(profile.getCompany());
						userSolrDoc.setExpertise(profile.getExpertise());
						userSolrDoc.setId(user.getId());
						userSolrDoc.setLocation(profile.getLocation());
						userSolrDoc.setNickname(user.getNickname());
						userSolrDoc.setOccupation(profile.getOccupation());
						userSolrDoc.setTitle(profile.getTitle());
						userSolrDoc.setUrl(profile.getUrl());
						
					}
				});
		mapperFactory.classMap(User.class, UserSolrDocument.class)
		.customize(new CustomMapper<User, UserSolrDocument>() {
			
			@Override
			public void mapAtoB(User user, UserSolrDocument userSolrDoc, MappingContext context) {
				
				UserProfile profile = user.getProfile();
				userSolrDoc.setAvatarId(user.getAvatarId());
				userSolrDoc.setBio(profile.getBio());
				userSolrDoc.setCompany(profile.getCompany());
				userSolrDoc.setExpertise(profile.getExpertise());
				userSolrDoc.setId(user.getId());
				userSolrDoc.setLocation(profile.getLocation());
				userSolrDoc.setNickname(user.getNickname());
				userSolrDoc.setOccupation(profile.getOccupation());
				userSolrDoc.setTitle(profile.getTitle());
				userSolrDoc.setUrl(profile.getUrl());
				
			}
			
			@Override
			public void mapBtoA(UserSolrDocument userSolrDoc, User user, MappingContext context) {
				// TODO Auto-generated method stub
				UserProfile profile = new UserProfile();
				profile.setBio(userSolrDoc.getBio());
				profile.setCompany(userSolrDoc.getCompany());
				profile.setExpertise(userSolrDoc.getExpertise());
				profile.setLocation(userSolrDoc.getLocation());
				profile.setOccupation(userSolrDoc.getOccupation());
				profile.setTitle(userSolrDoc.getTitle());
				profile.setUrl(userSolrDoc.getUrl());
				user.setProfile(profile);
				user.setAvatarId(userSolrDoc.getAvatarId());
				user.setId(userSolrDoc.getId());
				user.setNickname(userSolrDoc.getNickname());

			}
		});
		mapperFactory.classMap(User.class, UserRequestDTO.class);
		mapperFactory.classMap(User.class, UserResponseDTO.class);
		mapperFactory.classMap(UserRequestDTO.class, User.class);
		mapperFactory.classMap(UserResponseDTO.class, User.class);
	}
	
	public UserSolrDocument map(User user){
		UserProfile profile = user.getProfile();
		UserSolrDocument userSolrDoc = new UserSolrDocument();
		userSolrDoc.setAvatarId(user.getAvatarId());
		userSolrDoc.setBio(profile.getBio());
		userSolrDoc.setCompany(profile.getCompany());
		userSolrDoc.setExpertise(profile.getExpertise());
		userSolrDoc.setId(user.getId());
		userSolrDoc.setLocation(profile.getLocation());
		userSolrDoc.setNickname(user.getNickname());
		userSolrDoc.setOccupation(profile.getOccupation());
		userSolrDoc.setTitle(profile.getTitle());
		userSolrDoc.setUrl(profile.getUrl());
		return userSolrDoc;
	}
	
	public User map(UserSolrDocument userSolrDoc){
		User user = new User();
		UserProfile profile = new UserProfile();
		profile.setBio(userSolrDoc.getBio());
		profile.setCompany(userSolrDoc.getCompany());
		profile.setExpertise(userSolrDoc.getExpertise());
		profile.setLocation(userSolrDoc.getLocation());
		profile.setOccupation(userSolrDoc.getOccupation());
		profile.setTitle(userSolrDoc.getTitle());
		profile.setUrl(userSolrDoc.getUrl());
		user.setProfile(profile);
		user.setAvatarId(userSolrDoc.getAvatarId());
		user.setId(userSolrDoc.getId());
		user.setNickname(userSolrDoc.getNickname());
		return user;
	}

	@SuppressWarnings("unchecked")
	public <T> T map(UserRequestDTO userRequestDTO, Class<T> obj) {
		
		if(obj.isInstance(UserDTO.class)){
			UserDTO user = new UserDTO();
			user.setAvatarId(userRequestDTO.getAvatarId());
			user.setId(userRequestDTO.getId());
			user.setNickName(userRequestDTO.getNickname());
			return (T) user;
		}else if(obj.isInstance(UserProfileDTO.class)){
			return (T) userRequestDTO.getProfile();
		}else if(obj.isInstance(UserSolrDocument.class)){
			UserProfileDTO profile = userRequestDTO.getProfile();
			UserSolrDocument userSolrDoc = new UserSolrDocument();
			userSolrDoc.setAvatarId(userRequestDTO.getAvatarId());
			userSolrDoc.setBio(profile.getBio());
			userSolrDoc.setCompany(profile.getCompany());
			userSolrDoc.setExpertise(profile.getExpertise());
			userSolrDoc.setId(userRequestDTO.getId());
			userSolrDoc.setLocation(profile.getLocation());
			userSolrDoc.setNickname(userRequestDTO.getNickname());
			userSolrDoc.setOccupation(profile.getOccupation());
			userSolrDoc.setTitle(profile.getTitle());
			userSolrDoc.setUrl(profile.getUrl());
		}
		
		return null;
	}
	
}

