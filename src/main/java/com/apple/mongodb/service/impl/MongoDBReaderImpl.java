package com.apple.mongodb.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apple.entity.UserSolrDocument;
import com.apple.exceptions.ErrorCode;
import com.apple.exceptions.MongoDBExporterException;
import com.apple.exceptions.MongoDBReaderException;
import com.apple.mapper.UserMapper;
import com.apple.mongodb.importer.MongoDBConnection;
import com.apple.mongodb.services.MongoDBReader;
import com.apple.repos.UserSolrDocRepository;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

@Service
public class MongoDBReaderImpl implements MongoDBReader {
	
	@Autowired
	private MongoDBConnection mCon;
	
	@Autowired
	UserSolrDocRepository userRepo;
	
	@Autowired
	UserMapper mapper;
	
	private final int batchSize 	= 500;

	public FindIterable<Document> readFromMongoDB(MongoCollection<Document> collection, Integer skip, Integer pageSize) {
		return collection.find().skip(skip).batchSize(pageSize);
	}

	@Override
	public void exec(Integer totalRecords) {
		
		try{
			MongoClient client 						= mCon.getConnection();
			MongoDatabase db 						= client.getDatabase(mCon.getMongoDBName());
			int skip =0;
			
			int till = getBatchNos(totalRecords);
			if(till<0){
				return;
			}
			
			while(till>0){
				
				MongoCollection<Document> mCollection 	= db.getCollection(mCon.getMongoCollectionName());
				FindIterable<Document>  documentsList = this.readFromMongoDB(mCollection, skip, batchSize);
				MongoCursor<Document> result = documentsList.iterator();
				Set<UserSolrDocument> userSolrItr = new HashSet<UserSolrDocument>();
				while(result.hasNext()){
					Document doc = result.next();
					UserSolrDocument userSolrDoc =  mapper.map(doc);
					userSolrItr.add(userSolrDoc);
				}
				userRepo.save(userSolrItr);
				skip = skip + batchSize;
				till--;
			}
		}catch(MongoDBReaderException e){
			e.printStackTrace();
			throw new MongoDBReaderException(ErrorCode.READ_FAILED, "Mongodb to Solr export failed", e.getMessage(), e);
		}catch(Exception e){
			e.printStackTrace();
			throw new MongoDBExporterException(ErrorCode.SAVE_OR_UPDATE_FAILED, "Mongodb to Solr export failed", e.getMessage(), e);
		}
		
		
		
		
	}
	
	private int getBatchNos(int totalRecords){
		if(totalRecords<=batchSize){
			return 1;
		}else{
			int till = totalRecords/batchSize;
			if(totalRecords%batchSize==0){
				return till;
			}else{
				return till+1;
			}
		}
	}
	
	

}
