package com.apple.mongodb.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "UserDetails")
public class User {
	
	@Id
	private String _id;

	@Field("id")
	private String id;
	
	private String nickname;
	private String avatarId;
	private Date memberSince;

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

	public Date getMemberSince() {
		return memberSince;
	}

	public void setMemberSince(Date memberSince) {
		this.memberSince = memberSince;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}
	
}
