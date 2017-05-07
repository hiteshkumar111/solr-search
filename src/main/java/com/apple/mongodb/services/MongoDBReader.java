package com.apple.mongodb.services;

import org.springframework.data.domain.Page;

import com.apple.mongodb.entity.User;

public interface MongoDBReader {

	public Page<User> readFromMongoDB( Integer currentPage, Integer pageSize) throws Exception;

	public void exec(Integer totalRecords) throws Exception;
	
}
