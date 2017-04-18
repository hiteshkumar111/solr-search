package com.apple.repos;

import java.util.List;

import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

import com.apple.entity.UserSolrDocument;

@Repository
public interface SearchRepositoryCustom extends SolrCrudRepository<UserSolrDocument, String> {

	List<UserSolrDocument> findUserByEmail(String searchText);
	
   // Map<String,Object> search(Query query);
}
