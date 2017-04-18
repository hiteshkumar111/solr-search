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
	
	@Indexed(name = "profileid", type = "string")
	@Field("profileid")
	private String profileid;
	
	@Indexed(name = "personid", type = "string")
	@Field("personid")
	private String personid;

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
	
	@Indexed(name = "email", type = "string")
	@Field("email")
	private String email;
	
	@Indexed(name = "firstname", type = "string")
	@Field("firstname")
	private String firstName;

	@Indexed(name = "lastname", type = "string")
	@Field("lastname")
	private String lastname;
	
	@Indexed(name = "name", type = "string")
	@Field("name")
	private String nickName;
	
	@Indexed(name = "avatarid", type = "string")
	@Field("avatarid")
	private String avatarId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProfileid() {
		return profileid;
	}

	public void setProfileid(String profileid) {
		this.profileid = profileid;
	}

	public String getPersonid() {
		return personid;
	}

	public void setPersonid(String personid) {
		this.personid = personid;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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
