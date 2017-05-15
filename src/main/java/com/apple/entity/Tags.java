package com.apple.entity;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.util.Date;
import java.util.List;

//{"id":1,"name":"name","slug":"slug","description":"description",
//"type":"GENERIC_TAG","parentId":2,"childrenIds":[3,4],"state":"ACTIVE”}

@SolrDocument(solrCoreName = "tagsCore")
public class Tags {

	@Id
	@Indexed(name = "id", type = "string")
	private String id;

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


	@Indexed(name = "created_at", type = "date")
	@Field("created_at")
	private Date createdAt;


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

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	
	

}
