package com.fhirio.fhiremsservice.service;

import java.util.HashMap;
import java.util.Map;

import com.fhirio.fhiremsservice.domain.Authentication;
import com.fhirio.fhiremsservice.domain.Token;
import com.fhirio.fhiremsservice.domain.User;

public class AuthenticationService {
	private Map<Integer, Integer> authenticationMap = new HashMap<>();
	
	/**
	 * Basic constructor initializing some mock data.
	 */
	public AuthenticationService(){
		// let's bootstrap a few mappings
		String userName = "emspersonnel";
		String password = "password";
		authenticationMap.put(hashCredentials(userName, password), Integer.valueOf(111));
		
		userName = "emscallcenter";
		password = "password";
		authenticationMap.put(hashCredentials(userName, password), Integer.valueOf(112));
	}

	private Integer hashCredentials(String userName, String password) {
		return Integer.valueOf((userName+password).hashCode());
	}
	
	/**
	 * Authenticates a user and returns the corresponding User
	 * object.
	 * 
	 * @param userName the user's username.
	 * @param password the user's password.
	 * @return the User object
	 */
	public Token authenticate(Authentication auth){
		int hashedUser = (auth.getUserName()+auth.getPassword()).hashCode();
		Integer userId = authenticationMap.get(hashedUser);
		if( userId != null){
			return new Token(userId);
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

	public Authentication createAuthentication(User user) {
		if(user.getUserName() != null && user.getPassword() != null
				&& !user.getUserName().isEmpty() && !user.getPassword().isEmpty()
				&& user.getUserUuid() != null){
			saveUserAuthentication(user);
			Authentication auth = new Authentication(user.getUserName(), user.getPassword());
			user.setPassword(null);
			return auth;
		}
		return null;
	}

	private Integer saveUserAuthentication(User user) {
		return authenticationMap.put(hashCredentials(user.getUserName(), user.getPassword()), user.getUserUuid());
	}
}
