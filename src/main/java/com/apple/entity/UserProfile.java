package com.apple.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

@SolrDocument
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getExpertise() {
		return expertise;
	}

	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
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