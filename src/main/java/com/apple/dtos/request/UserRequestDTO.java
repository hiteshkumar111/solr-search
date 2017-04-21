package com.apple.dtos.request;

import java.io.Serializable;

import com.apple.dtos.UserProfileDTO;

public class UserRequestDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private String id;
	private String nickname;
	private String avatarId;
	private UserProfileDTO profile; 

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
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
	
}

