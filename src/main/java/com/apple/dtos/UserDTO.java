package com.apple.dtos;

public class UserDTO {

	private String id;
	private String nickName;
	private String avatarId;
	

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