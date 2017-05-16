package com.apple.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apple.mongodb.services.MongoDBTagsReader;
import com.apple.mongodb.services.MongoDBUserReader;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/v1/mongodb-export")
public class MongoDBImporterController {

	@Autowired
	private MongoDBUserReader mongoDBUserReader;
	
	@Autowired
	private MongoDBTagsReader mongoDBTagsReader;

    @ApiOperation(value = "export", notes = "Read User from MongoDB and index into Solr", response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class) })
    @RequestMapping(value = "/user",  consumes = { "*/*" }, method = RequestMethod.GET)
    public ResponseEntity<?> exportUserToSolr(@RequestParam(value="size", required=true) Integer totalRecords) throws Exception {
    	mongoDBUserReader.exec(totalRecords);
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
    @ApiOperation(value = "export", notes = "Read Tags from MongoDB and index into Solr", response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class) })
    @RequestMapping(value = "/tags",  consumes = { "*/*" }, method = RequestMethod.GET)
    public ResponseEntity<?> exportTagsToSolr(@RequestParam(value="size", required=true) Integer totalRecords) throws Exception {
    	mongoDBTagsReader.exec(totalRecords);
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
    
}

