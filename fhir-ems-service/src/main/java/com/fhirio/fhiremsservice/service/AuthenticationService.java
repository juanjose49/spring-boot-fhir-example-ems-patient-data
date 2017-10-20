package com.fhirio.fhiremsservice.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.fhirio.fhiremsservice.domain.User;

public class AuthenticationService {
	private Map<Integer, Integer> authenticationMap = new HashMap<>();
	@Autowired
	private UserService userService;
	public AuthenticationService(){
		// let's bootstrap a few mappings
		String userName = "emspersonnel";
		String password = "password";
		authenticationMap.put(Integer.valueOf((userName+password).hashCode()), Integer.valueOf(1));
		
		userName = "emscallcenter";
		password = "password";
		authenticationMap.put(Integer.valueOf((userName+password).hashCode()), Integer.valueOf(2));
	}
	
	public User authenticate(String userName, String password){
		int hashedUser = (userName+password).hashCode();
		Integer userId = authenticationMap.get(hashedUser);
		if( userId != null){
			return userService.getUser(userId);
		}
		return null;
	}

}
