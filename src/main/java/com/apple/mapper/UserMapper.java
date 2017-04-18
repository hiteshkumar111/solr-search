package com.apple.mapper;

import org.springframework.stereotype.Component;

import com.apple.dtos.request.UserRequestDTO;
import com.apple.dtos.response.UserResponseDTO;
import com.apple.entity.Person;
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
						Person person = new Person();
						UserProfile profile = new UserProfile();
						person.setId(userSolrDoc.getPersonid());
						person.setEmail(userSolrDoc.getEmail());
						person.setFirstName(userSolrDoc.getFirstName());
						person.setLastname(userSolrDoc.getLastname());
						user.setPerson(person);
						profile.setId(userSolrDoc.getProfileid());
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
						user.setNickName(userSolrDoc.getNickName());

					}
					
					@Override
					public void mapBtoA(User user, UserSolrDocument userSolrDoc, MappingContext context) {
						
						Person person = user.getPerson();
						UserProfile profile = user.getProfile();
						userSolrDoc.setAvatarId(user.getAvatarId());
						userSolrDoc.setBio(profile.getBio());
						userSolrDoc.setCompany(profile.getCompany());
						userSolrDoc.setEmail(person.getEmail());
						userSolrDoc.setExpertise(profile.getExpertise());
						userSolrDoc.setFirstName(person.getFirstName());
						userSolrDoc.setId(user.getId());
						userSolrDoc.setLastname(person.getLastname());
						userSolrDoc.setLocation(profile.getLocation());
						userSolrDoc.setNickName(user.getNickName());
						userSolrDoc.setOccupation(profile.getOccupation());
						userSolrDoc.setPersonid(person.getId());
						userSolrDoc.setProfileid(profile.getId());
						userSolrDoc.setTitle(profile.getTitle());
						userSolrDoc.setUrl(profile.getUrl());
						
					}
				});
		mapperFactory.classMap(User.class, UserSolrDocument.class)
		.customize(new CustomMapper<User, UserSolrDocument>() {
			
			@Override
			public void mapAtoB(User user, UserSolrDocument userSolrDoc, MappingContext context) {
				
				Person person = user.getPerson();
				UserProfile profile = user.getProfile();
				userSolrDoc.setAvatarId(user.getAvatarId());
				userSolrDoc.setBio(profile.getBio());
				userSolrDoc.setCompany(profile.getCompany());
				userSolrDoc.setEmail(person.getEmail());
				userSolrDoc.setExpertise(profile.getExpertise());
				userSolrDoc.setFirstName(person.getFirstName());
				userSolrDoc.setId(user.getId());
				userSolrDoc.setLastname(person.getLastname());
				userSolrDoc.setLocation(profile.getLocation());
				userSolrDoc.setNickName(user.getNickName());
				userSolrDoc.setOccupation(profile.getOccupation());
				userSolrDoc.setPersonid(person.getId());
				userSolrDoc.setProfileid(profile.getId());
				userSolrDoc.setTitle(profile.getTitle());
				userSolrDoc.setUrl(profile.getUrl());
				
			}
			
			@Override
			public void mapBtoA(UserSolrDocument userSolrDoc, User user, MappingContext context) {
				// TODO Auto-generated method stub
				Person person = new Person();
				UserProfile profile = new UserProfile();
				person.setId(userSolrDoc.getPersonid());
				person.setEmail(userSolrDoc.getEmail());
				person.setFirstName(userSolrDoc.getFirstName());
				person.setLastname(userSolrDoc.getLastname());
				user.setPerson(person);
				profile.setId(userSolrDoc.getProfileid());
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
				user.setNickName(userSolrDoc.getNickName());

			}
		});
		mapperFactory.classMap(User.class, UserRequestDTO.class);
		mapperFactory.classMap(User.class, UserResponseDTO.class);
		mapperFactory.classMap(UserRequestDTO.class, User.class);
		mapperFactory.classMap(UserResponseDTO.class, User.class);
	}
	
	public UserSolrDocument map(User user){
		Person person = user.getPerson();
		UserProfile profile = user.getProfile();
		UserSolrDocument userSolrDoc = new UserSolrDocument();
		userSolrDoc.setAvatarId(user.getAvatarId());
		userSolrDoc.setBio(profile.getBio());
		userSolrDoc.setCompany(profile.getCompany());
		userSolrDoc.setEmail(person.getEmail());
		userSolrDoc.setExpertise(profile.getExpertise());
		userSolrDoc.setFirstName(person.getFirstName());
		userSolrDoc.setId(user.getId());
		userSolrDoc.setLastname(person.getLastname());
		userSolrDoc.setLocation(profile.getLocation());
		userSolrDoc.setNickName(user.getNickName());
		userSolrDoc.setOccupation(profile.getOccupation());
		userSolrDoc.setPersonid(person.getId());
		userSolrDoc.setProfileid(profile.getId());
		userSolrDoc.setTitle(profile.getTitle());
		userSolrDoc.setUrl(profile.getUrl());
		return userSolrDoc;
	}
	
	public User map(UserSolrDocument userSolrDoc){
		User user = new User();
		Person person = new Person();
		UserProfile profile = new UserProfile();
		person.setId(userSolrDoc.getPersonid());
		person.setEmail(userSolrDoc.getEmail());
		person.setFirstName(userSolrDoc.getFirstName());
		person.setLastname(userSolrDoc.getLastname());
		user.setPerson(person);
		profile.setId(userSolrDoc.getProfileid());
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
		user.setNickName(userSolrDoc.getNickName());
		return user;
	}
}

