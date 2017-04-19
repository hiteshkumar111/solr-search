package com.apple.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Query;
import org.springframework.stereotype.Service;

import com.apple.dtos.request.SearchRequestDTO;
import com.apple.entity.User;
import com.apple.entity.UserSolrDocument;
import com.apple.repos.SearchRepositoryCustom;
import com.apple.services.SolrSearchService;

@Service
public class SolrSearchServiceImpl implements SolrSearchService{
	
	@Autowired
	private SolrTemplate solrTemplate;

	@Autowired
	private SearchRepositoryCustom searchRepo;
	
	public List<UserSolrDocument> search(SearchRequestDTO searchRequest){
	
		List<UserSolrDocument> listOfUsers = searchRepo.findByQueryAnnotation(searchRequest.getSearchText());
		
	//	Query query = buildSearchRequest(searchRequest);
		
		//@SuppressWarnings("unchecked")
		//Map<String, Object> result = solrTemplate.queryForObject(query, Map.class);
		
		return listOfUsers;
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
