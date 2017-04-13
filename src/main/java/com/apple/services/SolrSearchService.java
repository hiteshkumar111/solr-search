package com.apple.services;

import java.util.Map;

import com.apple.dtos.request.SearchRequestDTO;

public interface SolrSearchService {

	Map<String,Object> search(SearchRequestDTO searchRequest);
}
