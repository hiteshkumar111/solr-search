package com.apple.repos;

import java.util.Map;

import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchRepositoryCustom extends SolrCrudRepository<Object, String> {
	
    Map<String,Object> search(Query query);
}
