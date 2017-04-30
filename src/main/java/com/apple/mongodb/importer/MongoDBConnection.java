package com.apple.mongodb.importer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.spockframework.gentyref.TypeToken;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

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
	
	public static void main(String args[]){
		MongoClient cl = new MongoClient();
		MongoDatabase db = cl.getDatabase("userDetailsDB");
		String str = "{\"id\":3, \"bio\":\"Mongo Java Developer\",\"company\":\"Mongodb data export\","
				+ " \"expertise\":\"mongodb java\", \"location\":\"CA\", \"location\":\"Engg Mongo\", \"title\":"
				+ "\"boss\", \"url\":\"hellomongodb.com\", \"nickname\":\"MongoNickName\","
				+ " \"name\":\"mongoName\",\"avatarid\":\"MongoAvtar\"})";
		
		MongoCollection<Document> doc = db.getCollection("UserDetails");
		
		try {
			String nickName = "testing";
			String name = "mongoName";
			String bio = "Mongo Java Developer";
			List<Document> docList = new ArrayList<Document>();
			for(int i=1001;i<10000;i++){
				HashMap<String,Object> result =
				        new ObjectMapper().readValue(str, HashMap.class);
				result.put("id", i+"");
				result.put("nickname", nickName+"_"+i);
				result.put("name", name+"_"+i);
				result.put("bio", bio + "_"+i);
				
				Document d = new Document(result);
				docList.add(d);
			}
			
			doc.insertMany(docList);
			
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
