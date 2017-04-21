package com.apple.entity;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

@SolrDocument(solrCoreName = "userDetailsCore")
public class User {

	@Id
	@Indexed(name = "id", type = "string")
	private String id;

	@Indexed(name = "name", type = "string")
	@Field("name")
	private String nickname;
	
	@Indexed(name = "avatarid", type = "string")
	@Field("avatarid")
	private String avatarId;
	
	@Field(child=true)
	private UserProfile profile; 
	

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

	public UserProfile getProfile() {
		return profile;
	}

	public void setProfile(UserProfile profile) {
		this.profile = profile;
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