package com.apple.repos;

import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

import com.apple.entity.User;
import com.apple.entity.UserSolrDocument;

//@Repository
public interface UserRepository extends SolrCrudRepository<UserSolrDocument, String> {

	
}
