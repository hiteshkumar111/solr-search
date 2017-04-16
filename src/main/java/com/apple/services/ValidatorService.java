/**
 *
 */
package com.apple.services;

import com.apple.dtos.request.*;
import com.apple.exceptions.InvalidRequestException;

public interface ValidatorService {
    void validateSearchRequest(SearchRequestDTO searchRequest) throws InvalidRequestException;

	void validateUserSaveRequest(UserRequestDTO userRequestDTO) throws InvalidRequestException;
}
