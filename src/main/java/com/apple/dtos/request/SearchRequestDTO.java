package com.apple.dtos.request;

import java.io.Serializable;

import org.springframework.data.domain.Sort;

public class SearchRequestDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String searchText;
	private String sortByField;
	private Sort.Direction direction;

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public Sort.Direction getDirection() {
		return direction;
	}

	public void setDirection(Sort.Direction direction) {
		this.direction = direction;
	}

	public String getSortByField() {
		return sortByField;
	}

	public void setSortByField(String sortByField) {
		this.sortByField = sortByField;
	}
	
}
