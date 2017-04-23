package com.apple.entity;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

@SolrDocument(solrCoreName = "userDetailsCore")
public class UserSolrDocument {

	@Id
	@Indexed(name = "id", type = "string")
	private String id;

	@Indexed(name = "bio", type = "string")
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

	@Indexed(name = "name", type = "string")
	@Field("name")
	private String nickname;

	@Indexed(name = "avatarid", type = "string")
	@Field("avatarid")
	private String avatarId;

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

}
