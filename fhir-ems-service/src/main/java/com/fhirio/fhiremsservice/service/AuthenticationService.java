package com.fhirio.fhiremsservice.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.fhirio.fhiremsservice.domain.Authentication;
import com.fhirio.fhiremsservice.domain.User;

public class AuthenticationService {
	private Map<Integer, Integer> authenticationMap = new HashMap<>();
	@Autowired
	private UserService userService;
	
	/**
	 * Basic constructor initializing some mock data.
	 */
	public AuthenticationService(){
		// let's bootstrap a few mappings
		String userName = "emspersonnel";
		String password = "password";
		authenticationMap.put(Integer.valueOf((userName+password).hashCode()), Integer.valueOf(1));
		
		userName = "emscallcenter";
		password = "password";
		authenticationMap.put(Integer.valueOf((userName+password).hashCode()), Integer.valueOf(2));
	}
	
	/**
	 * Authenticates a user and returns the corresponding User
	 * object.
	 * 
	 * @param userName the user's username.
	 * @param password the user's password.
	 * @return the User object
	 */
	public User authenticate(Authentication auth){
		int hashedUser = (auth.getUserName()+auth.getPassword()).hashCode();
		Integer userId = authenticationMap.get(hashedUser);
		if( userId != null){
			return userService.getUser(userId);
		}
		return null;
	}

	/**
	 * Get the authentication Map with all the hashed usernames/passwords
	 * mapped to the User UUID.
	 * @return the authentication Map.
	 */
	public Map<Integer, Integer> getAuthenticationMap() {
		return authenticationMap;
	}

	/**
	 * Set the authentication Map with all the hashed usernames/passwords
	 * mapped to the User UUID.
	 */
	public void setAuthenticationMap(Map<Integer, Integer> authenticationMap) {
		this.authenticationMap = authenticationMap;
	}

}
