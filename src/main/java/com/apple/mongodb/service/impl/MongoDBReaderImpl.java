package com.apple.mongodb.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
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
@PropertySource("classpath:application.properties")
public class MongoDBReaderImpl implements MongoDBReader {
	
	@Autowired
	private UserMongoRepository userMongoRepo;
	
	@Autowired
	UserSolrDocRepository userRepo;
	
	@Autowired
	UserMapper mapper;
	
	static final String batchSizeProp = "mongodb.export.batchsize";

	@Resource
	private Environment environment;
	
	private int batchSize;
	
	@PostConstruct
	public void init(){
		this.batchSize =  Integer.parseInt(environment.getRequiredProperty(batchSizeProp));
	}
	
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
				
				Page<User> users = this.readFromMongoDB(currentPage, this.batchSize);
				List<User> usersList = users.getContent();
				
				if(null==usersList || usersList.isEmpty()){
					break;
				}
				
				Set<UserSolrDocument> userSolrItr 		= new HashSet<UserSolrDocument>();
				
				for(User user: usersList){
					UserSolrDocument userSolrDoc 		=  mapper.map(user);
					userSolrItr.add(userSolrDoc);
				}
				if(!userSolrItr.isEmpty()){
					userRepo.save(userSolrItr);
				}
				
				till--;
				currentPage++;
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception("Mongodb to Solr export failed");
		}
		
		
		
		
	}
	
	private int getBatchNos(int totalRecords){
		
		if(totalRecords<=this.batchSize){
			return 1;
		}else{
			int till = totalRecords/this.batchSize;
			if(totalRecords%this.batchSize==0){
				return till;
			}else{
				return till+1;
			}
		}
	}

	public int getBatchSize() {
		return batchSize;
	}

	public void setBatchSize(int batchSize) {
		this.batchSize = batchSize;
	}
	

}
