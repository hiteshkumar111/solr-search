package com.apple.entity;

import java.util.List;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

@SolrDocument(solrCoreName = "tagsCore")
public class Tags {

	@Id
	@Indexed(name = "id", type = "string")
	private String id;
	
	@Field("name")
	@Indexed(name="name", type = "string", searchable = true)
	private String name;

	@Field("type")
	private String type;

	@Field("slug")
	private String slug;

	@Field("description")
	private String description;

	@Field("parentId")
	@Indexed(name = "parentId", type="String", searchable=true)
	private String parentId;

	@Field("childrenIds")
	@Indexed(name = "childrenIds", type = "Strings", searchable=true)
	private List<String> childrenIds;

	@Field("state")
	private Boolean state;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public List<String> getChildrenIds() {
		return childrenIds;
	}

	public void setChildrenIds(List<String> childrenIds) {
		this.childrenIds = childrenIds;
	}

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
