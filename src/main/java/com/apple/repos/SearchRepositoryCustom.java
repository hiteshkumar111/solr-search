package com.apple.repos;

import java.util.Map;

import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

import com.apple.dtos.request.SearchRequestDTO;

@Repository
public interface SearchRepositoryCustom extends SolrCrudRepository<Object, String> {
	
    Map<String,Object> searchTickets(SearchRequestDTO searchRequestDTO);
}
