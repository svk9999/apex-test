package com.example.demo.controllers;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.RegisteredUsers;
import com.example.demo.model.UnRegisteredUsers;
import com.example.demo.service.UsersServiceDelgate;

@RestController
public class UsersController {

	public UsersServiceDelgate usersServiceDelgate;

	@Autowired
	public UsersController(UsersServiceDelgate usersServiceDelgate) {
		
		this.usersServiceDelgate = usersServiceDelgate;
	}



	@GetMapping(path = "/getUsers")
	public List<Object> getUsers() {
		List<RegisteredUsers> regUser = usersServiceDelgate.getRegisteredUsers();
		List<UnRegisteredUsers> unRegUser = usersServiceDelgate.getUnRegisteredUsers();
		Map<String, List<String>> membershipInfo = usersServiceDelgate.getProjectMembershipInfo();
		
		Stream<Object> mergedUsers = Stream.of(
				regUser.stream().peek(e -> {
					e.setProjectIds(membershipInfo.get(e.getId()));
					}).collect(Collectors.toList()),
		
				unRegUser.stream().peek(e -> {
					e.setProjectIds(membershipInfo.get(e.getId()));
					}).collect(Collectors.toList())
				).flatMap(Collection::stream);

		return mergedUsers.collect(Collectors.toList());
	}
}
