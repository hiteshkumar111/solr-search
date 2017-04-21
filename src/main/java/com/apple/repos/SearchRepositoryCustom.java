package com.apple.repos;

import java.util.List;

import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

import com.apple.entity.UserSolrDocument;

@Repository
public interface SearchRepositoryCustom extends SolrCrudRepository<UserSolrDocument, String> {

	List<UserSolrDocument> findUserByEmail(String searchText);
	
	@Query("email:*?0* OR profileid:*?0* OR personid:*?0* OR expertise:*?0* OR location:*?0* OR name:*?0* OR bio:*?0* OR occupation:*?0* OR firstname:*?0* OR lastname:*?0* OR title:*?0*")
	List<UserSolrDocument> findByQueryAnnotation(String searchTerm);
	
   // Map<String,Object> search(Query query);
}
