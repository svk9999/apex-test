package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

public class UnRegisteredUsers {
	private String id;
	private String emailAddress;
	private String languageCode;
	private String registrationId;
	private String registrationIdGeneratedTime;
	private List<String> projectIds;
	
	
	public List<String> getProjectIds() {
		return projectIds;
	}
	public UnRegisteredUsers setProjectIds(List<String> projectIds) {
		if(projectIds == null) {
			this.projectIds = new ArrayList<>();
		} else {
			this.projectIds = projectIds;
		}
		return this;
	}
	
	public String getId() {
		return id;
	}
	public UnRegisteredUsers setId(String id) {
		this.id = id;
		return this;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public UnRegisteredUsers setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
		return this;
	}
	public String getLanguageCode() {
		return languageCode;
	}
	public UnRegisteredUsers setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
		return this;
	}
	public String getRegistrationId() {
		return registrationId;
	}
	public UnRegisteredUsers setRegistrationId(String registrationId) {
		this.registrationId = registrationId;
		return this;
	}
	public String getRegistrationIdGeneratedTime() {
		return registrationIdGeneratedTime;
	}
	public UnRegisteredUsers setRegistrationIdGeneratedTime(String registrationIdGeneratedTime) {
		this.registrationIdGeneratedTime = registrationIdGeneratedTime;
		return this;
	}
	
}
