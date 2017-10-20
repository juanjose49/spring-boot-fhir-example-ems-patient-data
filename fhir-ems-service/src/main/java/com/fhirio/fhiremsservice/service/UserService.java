package com.fhirio.fhiremsservice.service;

import java.util.HashMap;

import com.fhirio.fhiremsservice.domain.User;

public class UserService {
	private HashMap<Integer, User> userMap = new HashMap<>();
	/**
	 * Basic constructor initializing mock users.
	 */
	public UserService(){
		//bootstrap users
		userMap.put(Integer.valueOf(1), new User(1, "emspersonnel", "John", "Smith", 1));
		userMap.put(Integer.valueOf(2), new User(2, "emscallcenter", "Jane", "Smith", 1));
	}
	
	/**
	 * Gets a User based on a User's UUID.
	 * 
	 * @param userUuid the User's UUID.
	 * @return the User.
	 */
	public User getUser(Integer userUuid){
		return this.userMap.get(userUuid);
	}
	/**
	 * Gets the User Map, which maps a User's UUID to
	 * the User.
	 * 
	 * @return the User Map.
	 */
	public HashMap<Integer, User> getUserMap() {
		return userMap;
	}
	/**
	 * Gets the User Map, which maps a User's UUID to
	 * the User.
	 */
	public void setUserMap(HashMap<Integer, User> userMap) {
		this.userMap = userMap;
	}
}
