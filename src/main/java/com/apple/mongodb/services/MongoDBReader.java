package com.apple.mongodb.services;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;

public interface MongoDBReader {

	public FindIterable<Document> readFromMongoDB(MongoCollection<Document> collection, Integer pageNo, Integer pageSize) throws Exception;

	public void exec(Integer totalRecords) throws Exception;
	
}
