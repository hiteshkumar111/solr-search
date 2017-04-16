package com.apple.serviceImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Query;

import com.apple.dtos.request.SearchRequestDTO;
import com.apple.services.SolrSearchService;

public class SolrSearchServiceImpl implements SolrSearchService{
	
	@Autowired
	private SolrTemplate solrTemplate;

	public Map<String,Object> search(SearchRequestDTO searchRequest){
		
		Query query = buildSearchRequest(searchRequest);
		
		@SuppressWarnings("unchecked")
		Map<String, Object> result = solrTemplate.queryForObject(query, Map.class);
		
		return result;
	}

	/**
	 * 
	 * @param searchRequest
	 * @return
	 * 
	 * Responsible for building Query from Search Request DTO.
	 */
	private Query buildSearchRequest(SearchRequestDTO searchRequest) {

		
		return null;
	}
}
