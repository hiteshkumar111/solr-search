package com.apple.mongodb.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.apple.entity.UserSolrDocument;
import com.apple.mapper.UserMapper;
import com.apple.mongodb.entity.User;
import com.apple.mongodb.repos.UserMongoRepository;
import com.apple.mongodb.services.MongoDBReader;
import com.apple.repos.UserSolrDocRepository;

@Service
public class MongoDBReaderImpl implements MongoDBReader {
	
	@Autowired
	private UserMongoRepository userMongoRepo;
	
	@Autowired
	UserSolrDocRepository userRepo;
	
	@Autowired
	UserMapper mapper;
	
	private final int batchSize = 500;

	@Override
	public Page<User> readFromMongoDB(Integer pageNo, Integer pageSize) {
		return userMongoRepo.findAll(new PageRequest(pageNo, pageSize));
	}

	@Override
	public void exec(Integer totalRecords) throws Exception {
		
		try{
			int currentPage = 0;
			
			int till = getBatchNos(totalRecords);
			
			if(till<0){
				return;
			}
			
			while(till>0){
				
				Page<User> users = this.readFromMongoDB(currentPage, batchSize);
				List<User> usersList = users.getContent();
				
				Set<UserSolrDocument> userSolrItr 		= new HashSet<UserSolrDocument>();
				
				for(User user: usersList){
					UserSolrDocument userSolrDoc 		=  mapper.map(user);
					userSolrItr.add(userSolrDoc);
				}
				
				userRepo.save(userSolrItr);
				
				till--;
				currentPage++;
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception("Mongodb to Solr export failed");
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
