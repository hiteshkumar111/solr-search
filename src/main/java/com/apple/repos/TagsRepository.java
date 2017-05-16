package com.apple.repos;

import java.util.List;

import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

import com.apple.entity.Tags;

@Repository
public interface TagsRepository extends SolrCrudRepository<Tags, String> {

	List<Tags> findByParentId(String parentId);

	List<Tags> findByName(String name);
	
}
