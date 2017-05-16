package com.apple.mongodb.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "users")
public class User {
	
	@Id
	private String id;
	
	private String nickname;
	private String avatarId;
	private Long memberSince;

	@Field("profile")
	private UserProfileMongo userProfileMongo;

	public UserProfileMongo getUserProfileMongo() {
		return userProfileMongo;
	}

	public void setUserProfileMongo(UserProfileMongo userProfileMongo) {
		this.userProfileMongo = userProfileMongo;
	}

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

	public Long getMemberSince() {
		return memberSince;
	}

	public void setMemberSince(Long memberSince) {
		this.memberSince = memberSince;
	}

}
