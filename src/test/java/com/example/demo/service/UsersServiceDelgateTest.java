package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.model.ProjectMembership;
import com.example.demo.model.RegisteredUsers;
import com.example.demo.model.UnRegisteredUsers;

@ExtendWith(MockitoExtension.class)
public class UsersServiceDelgateTest {
	@Mock
	private RestTemplate restTemplate;
	@Mock
	private UriComponents  mockApiUriTemplate ;
	
	@InjectMocks
	private UsersServiceDelgate serviceDelegate;
	
	@BeforeEach
	public void setUp() {
		mockApiUriTemplate = UriComponentsBuilder.fromUriString("").build();
		serviceDelegate = new UsersServiceDelgate(restTemplate, mockApiUriTemplate);
	}
	
	@Test
	public void testGetRegisteredUsers() {
		List<RegisteredUsers> registeredUsersList = new ArrayList<>();
		RegisteredUsers registeredUsers = new RegisteredUsers()
				.setCity("city")
				.setId("1");
		registeredUsersList.add(registeredUsers);
		Mockito.when(restTemplate.exchange(
				ArgumentMatchers.any(URI.class), ArgumentMatchers.eq(HttpMethod.GET), 
				ArgumentMatchers.any(), ArgumentMatchers.any(ParameterizedTypeReference.class)))
			.thenReturn(new ResponseEntity<>(registeredUsersList, HttpStatus.OK));
		List<RegisteredUsers> expected = serviceDelegate.getRegisteredUsers();
		assertEquals(registeredUsers.getId(), expected.get(0).getId());
	}
	
	@Test
	public void testGetUnRegisteredUsers() {
		List<UnRegisteredUsers> unregisteredUsersList = new ArrayList<>();
		UnRegisteredUsers unregisteredUsers = new UnRegisteredUsers()
				
				.setId("1");
		unregisteredUsersList.add(unregisteredUsers);
		Mockito.when(restTemplate.exchange(
				ArgumentMatchers.any(URI.class), ArgumentMatchers.eq(HttpMethod.GET), 
				ArgumentMatchers.any(), ArgumentMatchers.any(ParameterizedTypeReference.class)))
			.thenReturn(new ResponseEntity<>(unregisteredUsersList, HttpStatus.OK));
		List<UnRegisteredUsers> expected = serviceDelegate.getUnRegisteredUsers();
		assertEquals(unregisteredUsers.getId(), expected.get(0).getId());
	}
	
	@Test
	public void testGetProjectMembershipInfo() {
		List<ProjectMembership> projectMembershipList = new ArrayList<>();
		ProjectMembership projectMembership = new ProjectMembership()
				.setId("1")
				.setUserId("1")
				.setProjectId("1");
		projectMembershipList.add(projectMembership);
		Mockito.when(restTemplate.exchange(
				ArgumentMatchers.any(URI.class), ArgumentMatchers.eq(HttpMethod.GET), 
				ArgumentMatchers.any(), ArgumentMatchers.any(ParameterizedTypeReference.class)))
			.thenReturn(new ResponseEntity<>(projectMembershipList, HttpStatus.OK));
		Map<String, List<String>> expected = serviceDelegate.getProjectMembershipInfo();
		assertEquals(projectMembership.getId(), expected.get("1").get(0));
	}
	
}
