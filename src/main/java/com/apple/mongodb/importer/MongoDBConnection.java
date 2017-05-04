package com.apple.mongodb.importer;

import java.util.Arrays;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

@Component
@PropertySource("classpath:mongoimporter.properties")
public class MongoDBConnection {

	static final String MONGO_HOST 			= "mongodb.host";
	static final String MONGO_PORT 			= "mongodb.port";
	static final String MONGO_USERNAME 		= "mongodb.username";
	static final String MONGO_PASSWORD 		= "mongodb.password";
	static final String MONGO_DB 			= "mongodb.database";
	static final String MONGO_COLLECTION	= "mongodb.collection";
	
	private String mongoCollectionName;
	private String mongoDBName;
	private String userName;
	private String password;
	

	@Resource
	private Environment env;

	public MongoClient getConnection() {
		
		Integer port 	= null;
		try{
			port = Integer.valueOf(env.getProperty(MONGO_PORT));
		}catch (Exception e) {
			
		}
		String host 	= env.getProperty(MONGO_HOST);
		String userName = env.getProperty(MONGO_USERNAME);
		String password = env.getProperty(MONGO_PASSWORD);
		String database = env.getProperty(MONGO_DB);
		String colName  = env.getProperty(MONGO_COLLECTION);
		
		this.setMongoCollectionName(colName);
		this.setMongoDBName(database);
		this.setUserName(userName);
		this.setPassword(password);
		
		
		if (!StringUtils.isEmpty(userName) && !StringUtils.isEmpty(password)) {
			MongoCredential credential = MongoCredential.createCredential(userName, database, password.toCharArray());
			return new MongoClient(new ServerAddress(host, port), Arrays.asList(credential));
		}
		
		if (StringUtils.isEmpty(host)) {
			return new MongoClient();
		}

		if (!StringUtils.isEmpty(host) && null == port) {
			return new MongoClient(host);
		}

		if (!StringUtils.isEmpty(host) && port != null) {
			return new MongoClient(host, port);
		}

		return null;
	}
	
	public String getMongoCollectionName() {
		return mongoCollectionName;
	}

	public void setMongoCollectionName(String mongoCollectionName) {
		this.mongoCollectionName = mongoCollectionName;
	}

	public String getMongoDBName() {
		return mongoDBName;
	}

	public void setMongoDBName(String mongoDBName) {
		this.mongoDBName = mongoDBName;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
}
