package com.apple.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apple.entity.Tags;
import com.apple.repos.TagsRepository;
import com.apple.services.TagsService;

@Service
public class TagsServiceImpl implements TagsService {

	@Autowired
	private TagsRepository repo;
	
	@Override
	public Tags save(Tags tag) {
		repo.save(tag);
		return tag;
	}

	@Override
	public Tags findById(String id) {
		return repo.findOne(id);
	}

	@Override
	public List<Tags> findByParentId(String parentId) {
		return repo.findByParentId(parentId);
	}

	@Override
	public Tags findParentByChildId(String id) {
		return repo.findTagsWhereChildrenIdsContains(id);
	}

	@Override
	public List<Tags> findByName(String name) {
		return repo.findByName(name);
	}

}
