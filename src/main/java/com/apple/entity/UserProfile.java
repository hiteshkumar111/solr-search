package com.apple.entity;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Dynamic;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

public class UserProfile {

	@Field("bio")
	private String bio;
	
	@Indexed(name = "company", type = "string")
	@Field("company")
	private String company;
	
	@Indexed(name = "expertise", type = "string")
	@Field("expertise")
	private String expertise;
	
	@Indexed(name = "location", type = "string")
	@Field("location")
	private String location;
	
	@Indexed(name = "occupation", type = "string")
	@Field("occupation")
	private String occupation;
	
	@Indexed(name = "title", type = "string")
	@Field("title")
	private String title;
	
	@Indexed(name = "url", type = "string")
	@Field("url")
	private String url;

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

	@Override
	public String toString() {
		return "{'bio':" + bio + ", 'company':" + company + ", 'expertise':" + expertise
				+ ", 'location':" + location + ", 'occupation':" + occupation + ", 'title':" + title + ", 'url':" + url + "}";
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