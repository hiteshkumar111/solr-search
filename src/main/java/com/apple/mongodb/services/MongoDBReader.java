package com.apple.mongodb.services;

import org.bson.Document;

import com.apple.exceptions.MongoDBExporterException;
import com.apple.exceptions.MongoDBReaderException;
import com.mongodb.DBCursor;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;

public interface MongoDBReader {

	public FindIterable<Document> readFromMongoDB(MongoCollection<Document> collection, Integer pageNo, Integer pageSize) throws MongoDBReaderException;

	public void exec(Integer totalRecords) throws MongoDBExporterException;
	
}
