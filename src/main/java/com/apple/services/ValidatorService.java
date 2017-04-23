/**
 *
 */
package com.apple.services;

import com.apple.dtos.UserDTO;
import com.apple.dtos.UserProfileDTO;
import com.apple.dtos.request.*;
import com.apple.entity.UserSolrDocument;
import com.apple.exceptions.InvalidRequestException;

public interface ValidatorService {
    void validateSearchRequest(SearchRequestDTO searchRequest) throws InvalidRequestException;

	void validateUserSaveRequest(UserRequestDTO userRequestDTO) throws InvalidRequestException;

    void validateUserSaveRequest(UserDTO userRequestDTO) throws InvalidRequestException;

    UserSolrDocument validateUserProfileSaveRequest(UserProfileDTO userProfileDTO, String id) throws InvalidRequestException;
}
