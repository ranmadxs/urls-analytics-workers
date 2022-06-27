package com.esanchezd.urlsln.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;

public class Urlshortener implements Serializable{

	private static final long serialVersionUID = -4600963900798422882L;
	
	@Id
	private String id;
	private String url;
	private Date createdAt;
	private Date updatedAt;
	private Boolean isActive;
	private String owner;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	
	
}
