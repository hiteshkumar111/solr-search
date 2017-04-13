package com.apple.serviceImpl;

import org.springframework.stereotype.Service;

import com.apple.dtos.request.SearchRequestDTO;
import com.apple.exceptions.ErrorCode;
import com.apple.exceptions.InvalidRequestException;
import com.apple.services.ValidatorService;

@Service
public class ValidatorServiceImpl implements ValidatorService {

   

	@Override
	public void validateSearchRequest(SearchRequestDTO searchRequest) throws InvalidRequestException {
        if(searchRequest==null){
            throw new InvalidRequestException(ErrorCode.INVALID_REQUEST,"Request Object cannot be null");
        }
	}
}
