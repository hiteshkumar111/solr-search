package com.apple.mongodb.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.apple.entity.Tags;
import com.apple.mapper.UserMapper;
import com.apple.mongodb.entity.TagsMongo;
import com.apple.mongodb.repos.TagsMongoRepository;
import com.apple.mongodb.services.MongoDBTagsReader;
import com.apple.repos.TagsRepository;

@Service
@PropertySource("classpath:application.properties")
public class MongoDBTagsReaderImpl implements MongoDBTagsReader {

	@Autowired
	private TagsMongoRepository tagsMongoRepo;

	@Autowired
	TagsRepository tagsRepo;

	@Autowired
	UserMapper mapper;

	static final String batchSizeProp = "mongodb.export.batchsize";

	@Resource
	private Environment environment;

	private int batchSize;

	@PostConstruct
	public void init() {
		this.batchSize = Integer.parseInt(environment.getRequiredProperty(batchSizeProp));
	}

	@Override
	public Page<TagsMongo> readFromMongoDB(Integer pageNo, Integer pageSize) {
		return tagsMongoRepo.findAll(new PageRequest(pageNo, pageSize));
	}

	@Override
	public void exec(Integer totalRecords) throws Exception {

		try {
			int currentPage = 0;

			int till = getBatchNos(totalRecords);

			if (till < 0) {
				return;
			}

			while (till > 0) {

				Page<TagsMongo> tagsPage = this.readFromMongoDB(currentPage, this.batchSize);
				List<TagsMongo> tagsList = tagsPage.getContent();

				if (null == tagsList || tagsList.isEmpty()) {
					break;
				}

				Set<Tags> tagsSolrItr = new HashSet<Tags>();

				for (TagsMongo tagsMongo : tagsList) {
					Tags tags = mapper.map(tagsMongo, Tags.class);
					tagsSolrItr.add(tags);
				}
				if (!tagsSolrItr.isEmpty()) {
					tagsRepo.save(tagsSolrItr);
				}

				till--;
				currentPage++;
			}
		} catch (Exception e) {
			throw new Exception("Mongodb to Solr export failed for users");
		}

	}

	private int getBatchNos(int totalRecords) {

		if (totalRecords <= this.batchSize) {
			return 1;
		} else {
			int till = totalRecords / this.batchSize;
			if (totalRecords % this.batchSize == 0) {
				return till;
			} else {
				return till + 1;
			}
		}
	}

	public int getBatchSize() {
		return batchSize;
	}

	public void setBatchSize(int batchSize) {
		this.batchSize = batchSize;
	}

}
