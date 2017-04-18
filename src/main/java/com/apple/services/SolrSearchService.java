package com.apple.services;

import java.util.List;

import com.apple.dtos.request.SearchRequestDTO;
import com.apple.entity.UserSolrDocument;

public interface SolrSearchService {

	List<UserSolrDocument> search(SearchRequestDTO searchRequest);
}
