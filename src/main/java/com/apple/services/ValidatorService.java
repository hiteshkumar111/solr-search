/**
 *
 */
package com.apple.services;

import com.apple.dtos.TagsDTO;
import com.apple.dtos.UserDTO;
import com.apple.dtos.UserProfileDTO;
import com.apple.dtos.request.SearchRequestDTO;
import com.apple.entity.UserSolrDocument;

public interface ValidatorService {
    void validateSearchRequest(SearchRequestDTO searchRequest) throws Exception;

    void validateUserSaveRequest(UserDTO userRequestDTO) throws Exception;

    UserSolrDocument validateUserProfileSaveRequest(UserProfileDTO userProfileDTO, String id) throws Exception;

	void validateTagsSaveRequest(TagsDTO tags)  throws Exception;
}
