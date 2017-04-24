package com.apple.serviceImpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Page;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.stereotype.Service;

import com.apple.dtos.request.SearchRequestDTO;
import com.apple.entity.User;
import com.apple.entity.UserSolrDocument;
import com.apple.repos.SearchRepositoryCustom;
import com.apple.services.SolrSearchService;

@Service
public class SolrSearchServiceImpl implements SolrSearchService {

	@Resource
	private SolrTemplate solrTemplate;

	@Autowired
	private SearchRepositoryCustom searchRepo;

	public List<UserSolrDocument> search(SearchRequestDTO searchRequest) {

		//String searchKeyword = searchRequest.getSearchText();
		// List<UserSolrDocument> listOfUsers =
		// searchRepo.findByCompanyContainsOrExpertiseContainsOrLocationContainsOrOccupationContainsOrTitleContainsOrUrlContainsOrNicknameContainsOrAvatarIdContains(searchKeyword,
		// searchKeyword, searchKeyword, searchKeyword, searchKeyword,
		// searchKeyword, searchKeyword, searchKeyword);

		String searchKeyword = searchRequest.getSearchText();
		return searchRepo.findByQueryAnnotation(searchKeyword);

		
		/*
		Criteria query = buildSearchRequest(searchRequest);
		SimpleQuery search = new SimpleQuery(query);

		solrTemplate.setSolrCore("userDetailsCore");
	
		
		Page<UserSolrDocument> results = solrTemplate.queryForPage(search, UserSolrDocument.class);
		return results.getContent();
*/
		// @SuppressWarnings("unchecked")
		// Map<String, Object> result = solrTemplate.queryForObject(query,
		// Map.class);

		// return listOfUsers;
	}

	/**
	 * 
	 * @param searchRequest
	 * @return
	 * 
	 * 		Responsible for building Query from Search Request DTO.
	 */
	private Criteria buildSearchRequest(SearchRequestDTO searchRequest) {

		Criteria conditions = null;

		if (null == searchRequest) {
			return null;
		}
		String word = searchRequest.getSearchText();
		
		conditions = new Criteria("name").contains(word).or(new Criteria("bio").contains(word))
				.or(new Criteria("company").contains(word)).or(new Criteria("expertise").contains(word))
				.or(new Criteria("location").contains(word)).or(new Criteria("occupation").contains(word))
				.or(new Criteria("title").contains(word)).or(new Criteria("url").contains(word))
				.or(new Criteria("avatarid").contains(word));

		return conditions;
	}

}
