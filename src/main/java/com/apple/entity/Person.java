package com.apple.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;

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
	
}
