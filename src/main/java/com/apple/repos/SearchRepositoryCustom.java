package com.apple.repos;

import java.util.List;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

import com.apple.entity.UserSolrDocument;

@Repository
public interface SearchRepositoryCustom extends SolrCrudRepository<UserSolrDocument, String> {

	// List<UserSolrDocument> findUserByEmail(String searchText);

	@Query("company:?0 OR url:?0 OR avatarid:?0 OR expertise:?0 OR location:?0 OR name:?0 OR bio:?0 OR occupation:?0 OR title:?0")
	List<UserSolrDocument> findByQueryAnnotation(String searchTerm);

	List<UserSolrDocument> findByCompanyContainsOrExpertiseContainsOrLocationContainsOrOccupationContainsOrTitleContainsOrUrlContainsOrNicknameContainsOrAvatarIdContains(
			String company, String expertise, String location, String occupation, String title, String Url, String nickName, String avatarId );

	// Map<String,Object> search(Query query);
}
