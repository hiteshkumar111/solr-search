package com.apple.repos;

import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

import com.apple.entity.User;

@Repository
public interface UserRepository extends SolrCrudRepository<User, String> {

	
}
