package com.apple.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apple.dtos.TagsDTO;
import com.apple.entity.Tags;
import com.apple.mapper.UserMapper;
import com.apple.services.TagsService;
import com.apple.services.ValidatorService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/tags")
@PropertySource("classpath:application.properties")
public class TagsController {

	@Autowired
	private ValidatorService validatorService;

	@Autowired
	private UserMapper mapper;

	@Autowired
	private TagsService tagsService;

	@ApiOperation(value = "save", notes = "", response = Object.class)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "OK", response = Object.class) })
	@RequestMapping(consumes = { "*/*" }, method = RequestMethod.POST)
	public ResponseEntity<TagsDTO> saveNewTag(@RequestBody TagsDTO tags) throws Exception {
		validatorService.validateTagsSaveRequest(tags);
		Tags tag = tagsService.save(mapper.map(tags, Tags.class));
		return new ResponseEntity<TagsDTO>(mapper.map(tag, TagsDTO.class), HttpStatus.CREATED);
	}

	@ApiOperation(value = "find tags by id", notes = "", response = Object.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class) })
	@RequestMapping(value = "/{id}", consumes = { "*/*" }, method = RequestMethod.GET)
	public ResponseEntity<TagsDTO> findTagById(@PathVariable("id") String id) throws Exception {
		return new ResponseEntity<TagsDTO>(mapper.map(tagsService.findById(id), TagsDTO.class), HttpStatus.OK);
	}
	
	@ApiOperation(value = "find tags by id", notes = "", response = Object.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class) })
	@RequestMapping(value = "/name/{name}", consumes = { "*/*" }, method = RequestMethod.GET)
	public ResponseEntity<List<TagsDTO>> findTagByName(@PathVariable("name") String name) throws Exception {
		return new ResponseEntity<List<TagsDTO>>(mapper.mapAsList(tagsService.findByName(name), TagsDTO.class), HttpStatus.OK);
	}


	@ApiOperation(value = "find all child where parent id", notes = "", response = Object.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class) })
	@RequestMapping(value = "/{id}/child", consumes = { "*/*" }, method = RequestMethod.GET)
	public ResponseEntity<List<TagsDTO>> findByParentId(@PathVariable("id") String id) throws Exception {
		return new ResponseEntity<>(mapper.mapAsList(tagsService.findByParentId(id), TagsDTO.class), HttpStatus.OK);
	}
	
	@ApiOperation(value = "find Parent of child by child id", notes = "", response = Object.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class) })
	@RequestMapping(value = "/{id}/parent", consumes = { "*/*" }, method = RequestMethod.GET)
	public ResponseEntity<?> saveUserProfile(@PathVariable("id") String id) throws Exception {
		return new ResponseEntity<>(tagsService.findParentByChildId(id), HttpStatus.OK);
	}

}
