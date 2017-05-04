package com.apple.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apple.entity.UserSolrDocument;
import com.apple.mongodb.services.MongoDBReader;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/mongod")
public class MongoDBImporterController {

	@Autowired
	private MongoDBReader mongoDBReader;

    @ApiOperation(value = "export", notes = "Read from MongoDB and index into Solr", response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class) })
    @RequestMapping(value = "/export",  consumes = { "*/*" }, method = RequestMethod.GET)
    public ResponseEntity<List<UserSolrDocument>> exportToSolr(@RequestParam(value="size", required=true) Integer totalRecords) throws Exception {

    	mongoDBReader.exec(totalRecords);
    	
    	return null;
    }
    
    
    
    
}

