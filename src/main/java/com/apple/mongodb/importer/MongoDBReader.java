package com.apple.mongodb.importer;

import java.util.Map;

import com.mongodb.DB;
import com.mongodb.DBCollection;

public interface MongoDBReader {

	public Object readFromMongoDB(DB db, DBCollection collection, Map<String, String> mongoFields, Integer pageNo, Integer pageSize);
	
}
