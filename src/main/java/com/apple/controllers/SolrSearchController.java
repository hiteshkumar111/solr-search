package com.apple.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apple.dtos.request.SearchRequestDTO;
import com.apple.entity.UserSolrDocument;
import com.apple.services.SolrSearchService;
import com.apple.services.ValidatorService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/")
public class SolrSearchController {

    @Autowired
    private ValidatorService validatorService;

    @Autowired
    private SolrSearchService solrSearchService;

    @ApiOperation(value = "search", notes = "", response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class) })
    @RequestMapping(value = "/search",  consumes = { "*/*" }, method = RequestMethod.POST)
    public ResponseEntity<List<UserSolrDocument>> searchTickets(@RequestBody SearchRequestDTO searchRequestDTO) {
        validatorService.validateSearchRequest(searchRequestDTO);
        return new ResponseEntity<>(solrSearchService.search(searchRequestDTO),HttpStatus.OK);
    }
    
    
    
    
}

