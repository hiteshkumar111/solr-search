package com.apple.repos;

import java.util.Map;

import com.apple.dtos.request.SearchRequestDTO;

public interface SearchRepositoryCustom {
    Map<String,Object> searchTickets(SearchRequestDTO searchRequestDTO);
}
