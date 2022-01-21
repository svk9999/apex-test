package com.example.demo.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.demo.model.RegisteredUsers;
import com.example.demo.model.UnRegisteredUsers;
import com.example.demo.service.UsersServiceDelgate;

@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
public class UsersControllerTest {
	
	@MockBean
	private UsersServiceDelgate usersServiceDelgate;
	
	@Autowired
	private MockMvc mvc;
	
	@InjectMocks
	private UsersController controller;
	
	@BeforeEach
	public void setUp() {
		controller = new UsersController(usersServiceDelgate);
	}
	
	@Test
	public void testUserControllerRetunsOK() throws Exception {
		Mockito.when(usersServiceDelgate.getRegisteredUsers()).thenReturn(new ArrayList<>());
		Mockito.when(usersServiceDelgate.getUnRegisteredUsers()).thenReturn(new ArrayList<>());
		Mockito.when(usersServiceDelgate.getProjectMembershipInfo()).thenReturn(new HashMap<>());
		mvc.perform(get("/getUsers")).andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void testUserControllerWithMockData() throws Exception {
		Map<String, List<String>> projectMembership = new HashMap<>();
		List<String> projectId = Stream.of("1", "2").collect(Collectors.toList());
		projectMembership.put("1", projectId);
		List<RegisteredUsers> registeredUsersList = new ArrayList<>();
		RegisteredUsers registeredUsers = new RegisteredUsers()
				.setCity("city")
				.setId("1");
		registeredUsersList.add(registeredUsers);
		List<UnRegisteredUsers> unRegisteredUsersList = new ArrayList<>();
		UnRegisteredUsers unregisteredUsers = new UnRegisteredUsers()
				.setId("2");
		unRegisteredUsersList.add(unregisteredUsers);
		Mockito.when(usersServiceDelgate.getRegisteredUsers()).thenReturn(registeredUsersList);
		Mockito.when(usersServiceDelgate.getUnRegisteredUsers()).thenReturn(unRegisteredUsersList);
		Mockito.when(usersServiceDelgate.getProjectMembershipInfo()).thenReturn(projectMembership);
		mvc.perform(get("/getUsers"))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.jsonPath("$.[0].projectIds[0]").value("1"));
	}
}
