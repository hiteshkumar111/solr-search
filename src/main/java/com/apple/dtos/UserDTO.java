package com.apple.dtos;

import java.util.Date;

public class UserDTO {

	private String id;
	private String nickname;
	private String avatarId;
	private Date memberSince;
	

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
	
}



/*
{

"id": 0,

"nickname": "string",

"avatarId": "string",

"profile": {

  "id": 0,

  "bio": "string",

  "company": "string",

  "expertise": "string",

  "location": "string",

  "occupation": "string",

  "title": "string",

  "url": "string"

},

"person": {

  "id": 0,

  "email": "string",

  "firstName": "string",

  "lastName": "string"

}

}*/