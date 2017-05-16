package com.apple.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apple.dtos.UserDTO;
import com.apple.dtos.UserProfileDTO;
import com.apple.entity.UserSolrDocument;
import com.apple.mapper.UserMapper;
import com.apple.services.UserService;
import com.apple.services.ValidatorService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/v1/users")
@PropertySource("classpath:application.properties")
public class UserAttributeController {

	@Autowired
	private ValidatorService validatorService;

	@Autowired
	private UserMapper mapper;

	@Autowired
	private UserService userService;

	@ApiOperation(value = "save", notes = "", response = Object.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class) })
	@RequestMapping(value = "/user",  consumes = { "*/*" }, method = RequestMethod.POST)
	public ResponseEntity<?> saveNewUser(@RequestBody UserDTO userDto) throws Exception {
		validatorService.validateUserSaveRequest(userDto);
		UserSolrDocument solrDoc = mapper.convertToUserSolrDoc(userDto);
		userService.save(solrDoc);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "save", notes = "", response = Object.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class) })
	@RequestMapping(value = "/{id}/profile",  consumes = { "*/*" }, method = RequestMethod.POST)
	public ResponseEntity<?> saveUserProfile(@PathVariable("id") String id, @RequestBody UserProfileDTO userProfileDTO) throws Exception {
		UserSolrDocument solrDoc = validatorService.validateUserProfileSaveRequest(userProfileDTO, id);
		solrDoc = mapper.convertToUserSolrDoc(userProfileDTO, solrDoc);
		userService.save(solrDoc);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
