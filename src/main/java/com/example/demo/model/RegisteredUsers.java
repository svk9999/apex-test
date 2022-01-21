package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

public class RegisteredUsers {
	private String id;
	private String city;
	private String company;
	private String country;
	private String firstName;
	private String lastName;
	private String organizationType;
	private String phone;
	private String state;
	private String zipCode;
	private String languageCode;
	private String emailAddress;
	private boolean disclaimerAccepted;
	private List<String> projectIds;
	
	public List<String> getProjectIds() {
		return projectIds;
	}
	public RegisteredUsers setProjectIds(List<String> projectIds) {
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
	public RegisteredUsers setId(String id) {
		this.id = id;
		return this;
	}
	public String getCity() {
		return city;
	}
	public RegisteredUsers setCity(String city) {
		this.city = city;
		return this;
	}
	public String getCompany() {
		return company;
	}
	public RegisteredUsers setCompany(String company) {
		this.company = company;
		return this;
	}
	public String getCountry() {
		return country;
	}
	public RegisteredUsers setCountry(String country) {
		this.country = country;
		return this;
	}
	public String getFirstName() {
		return firstName;
	}
	public RegisteredUsers setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}
	public String getLastName() {
		return lastName;
	}
	public RegisteredUsers setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}
	public String getOrganizationType() {
		return organizationType;
	}
	public RegisteredUsers setOrganizationType(String organizationType) {
		this.organizationType = organizationType;
		return this;
	}
	public String getPhone() {
		return phone;
	}
	public RegisteredUsers setPhone(String phone) {
		this.phone = phone;
		return this;
	}
	public String getState() {
		return state;
	}
	public RegisteredUsers setState(String state) {
		this.state = state;
		return this;
	}
	public String getZipCode() {
		return zipCode;
	}
	public RegisteredUsers setZipCode(String zipCode) {
		this.zipCode = zipCode;
		return this;
	}
	public String getLanguageCode() {
		return languageCode;
	}
	public RegisteredUsers setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
		return this;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public RegisteredUsers setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
		return this;
	}
	public boolean isDisclaimerAccepted() {
		return disclaimerAccepted;
	}
	public RegisteredUsers setDisclaimerAccepted(boolean disclaimerAccepted) {
		this.disclaimerAccepted = disclaimerAccepted;
		return this;
	}
	
}
