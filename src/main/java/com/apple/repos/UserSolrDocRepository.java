package com.apple.repos;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

import com.apple.entity.User;
import com.apple.entity.UserSolrDocument;

//@Repository
public interface UserSolrDocRepository extends SolrCrudRepository<UserSolrDocument, String> {

	List<UserSolrDocument> findByNickname(String name, Pageable pageable);

	
}
