package com.apple.dtos.response;

import java.io.Serializable;

import com.apple.dtos.PersonDTO;
import com.apple.dtos.UserProfileDTO;

public class UserResponseDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String nickName;
	private String avatarId;
	private UserProfileDTO profile; 
	private PersonDTO person;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getAvatarId() {
		return avatarId;
	}

	public void setAvatarId(String avatarId) {
		this.avatarId = avatarId;
	}

	public UserProfileDTO getProfile() {
		return profile;
	}

	public void setProfile(UserProfileDTO profile) {
		this.profile = profile;
	}

	public PersonDTO getPerson() {
		return person;
	}

	public void setPerson(PersonDTO person) {
		this.person = person;
	}

	
}

