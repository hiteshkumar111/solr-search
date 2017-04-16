package com.apple.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

@SolrDocument
public class Person {

	@Id
	@Indexed(name = "id", type = "string")
	private String id;

	@Indexed(name = "email", type = "string")
	private String email;
	
	@Indexed(name = "firstname", type = "string")
	private String firstName;

	@Indexed(name = "lastname", type = "string")
	private String lastname;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
	
}
