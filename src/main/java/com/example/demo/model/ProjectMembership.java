package com.example.demo.model;

public class ProjectMembership {
	private String id;
	private String projectId;
	private String userId;
	public String getId() {
		return id;
	}
	public ProjectMembership setId(String id) {
		this.id = id;
		return this;
	}
	public String getProjectId() {
		return projectId;
	}
	public ProjectMembership setProjectId(String projectId) {
		this.projectId = projectId;
		return this;
	}
	public String getUserId() {
		return userId;
	}
	public ProjectMembership setUserId(String userId) {
		this.userId = userId;
		return this;
	}
	
	
}
