package com.apple.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;

public class UserProfile {

	@Id
	@Indexed(name = "id", type = "string")
	private String id;

	@Indexed(name = "bio", type = "string")
	private String bio;
	
	@Indexed(name = "company", type = "string")
	private String company;
	
	@Indexed(name = "expertise", type = "string")
	private String expertise;
	
	@Indexed(name = "location", type = "string")
	private String location;
	
	@Indexed(name = "occupation", type = "string")
	private String occupation;
	
	@Indexed(name = "title", type = "string")
	private String title;
	
	@Indexed(name = "url", type = "string")
	private String url;
	

	
}

/*
"id": 0,

"bio": "string",

"company": "string",

"expertise": "string",

"location": "string",

"occupation": "string",

"title": "string",

"url": "string"*/