package com.apple.mongodb.services;

import org.springframework.data.domain.Page;

import com.apple.mongodb.entity.TagsMongo;

public interface MongoDBTagsReader {

	public Page<TagsMongo> readFromMongoDB( Integer currentPage, Integer pageSize) throws Exception;

	public void exec(Integer totalRecords) throws Exception;
	
}
