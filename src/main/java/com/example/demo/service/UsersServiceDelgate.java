package com.example.demo.service;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;

import com.example.demo.model.ProjectMembership;
import com.example.demo.model.RegisteredUsers;
import com.example.demo.model.UnRegisteredUsers;

@Service
public class UsersServiceDelgate {
	
	private RestTemplate restTemplate;
	
	private UriComponents mockApiUriTemplate;
	
	
	@Autowired
	public UsersServiceDelgate(RestTemplate restTemplate, UriComponents mockApiUriTemplate) {
		this.restTemplate = restTemplate;
		this.mockApiUriTemplate = mockApiUriTemplate;
	}

	public List<RegisteredUsers> getRegisteredUsers() {
		URI getRegisteredUsersUri = URI.create(mockApiUriTemplate.toString().concat("registeredusers"));
		ResponseEntity<List<RegisteredUsers>> responseEntity = restTemplate.exchange(getRegisteredUsersUri, HttpMethod.GET, null, new ParameterizedTypeReference<List<RegisteredUsers>>() {} );
		return responseEntity.getBody();
	}
	
	public List<UnRegisteredUsers> getUnRegisteredUsers() {
		URI getRegisteredUsersUri = URI.create(mockApiUriTemplate.toString().concat("unregisteredusers"));
		ResponseEntity<List<UnRegisteredUsers>> responseEntity = restTemplate.exchange(getRegisteredUsersUri, HttpMethod.GET, null, new ParameterizedTypeReference<List<UnRegisteredUsers>>() {} );
		return responseEntity.getBody();
	}
	
	public Map<String, List<String>> getProjectMembershipInfo() {
		URI getRegisteredUsersUri = URI.create(mockApiUriTemplate.toString().concat("projectmemberships"));
		ResponseEntity<List<ProjectMembership>> responseEntity = restTemplate.exchange(getRegisteredUsersUri, HttpMethod.GET, null, new ParameterizedTypeReference<List<ProjectMembership>>() {} );
		List<ProjectMembership> projectMembershipList = responseEntity.getBody();
		//return projectMembershipList;
		//map with projectID as keys
		return projectMembershipList.stream().collect(Collectors.groupingBy(
				ProjectMembership::getUserId, Collectors.mapping(
						ProjectMembership::getProjectId, Collectors.toList())
				));
	}
}
