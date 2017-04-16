package com.apple.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apple.dtos.request.UserRequestDTO;
import com.apple.dtos.response.UserResponseDTO;
import com.apple.entity.User;
import com.apple.mapper.UserMapper;
import com.apple.services.UserService;
import com.apple.services.ValidatorService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/users")
public class UserAttributeController {

	@Autowired
	private ValidatorService validatorService;

	@Autowired
	private UserMapper mapper;

	@Autowired
	private UserService userService;

	@ApiOperation(value = "save", notes = "", response = Object.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class) })
	@RequestMapping(value = "/", consumes = { "*/*" }, method = RequestMethod.POST)
	public ResponseEntity<UserResponseDTO> saveUser(@RequestBody UserRequestDTO userRequestDTO) {
		validatorService.validateUserSaveRequest(userRequestDTO);

		User user = null;

		user = mapper.map(userRequestDTO, User.class);

		user = userService.save(user);

		return new ResponseEntity<UserResponseDTO>(mapper.map(user, UserResponseDTO.class), HttpStatus.OK);
	}

}
