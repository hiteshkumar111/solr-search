package com.apple.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apple.dtos.request.SearchRequestDTO;
import com.apple.dtos.request.UserRequestDTO;
import com.apple.dtos.response.UserResponseDTO;
import com.apple.services.ValidatorService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/users")
public class UserAttributeController {

    @Autowired
    private ValidatorService validatorService;


    @ApiOperation(value = "save", notes = "", response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class) })
    @RequestMapping(value = "/",  consumes = { "*/*" }, method = RequestMethod.POST)
    public ResponseEntity<UserResponseDTO> searchTickets(@RequestBody UserRequestDTO userRequestDTO) {
        validatorService.validateUserSaveRequest(userRequestDTO);
        return null;
        //return new ResponseEntity<>(solrSearchService.search(searchRequestDTO),HttpStatus.OK);
    }
    
    
    
    
}

