package com.apple.services;

import java.util.List;

import com.apple.entity.Tags;

public interface TagsService {

	Tags save(Tags User);

	Tags findById(String id);

	List<Tags> findByParentId(String id);

	List<Tags> findByName(String name);


	Iterable<Tags> findAll(Integer pageSize, Integer pageNo);

}
