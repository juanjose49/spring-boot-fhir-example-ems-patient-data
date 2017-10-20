package com.fhirio.fhiremsservice.service;

import java.util.HashMap;

import com.fhirio.fhiremsservice.domain.User;

public class UserService {
	private HashMap<Integer, User> userMap = new HashMap<>();
	
	public UserService(){
		//bootstrap users
		userMap.put(Integer.valueOf(1), new User(1, "emspersonnel", "John", "Smith", 1));
		userMap.put(Integer.valueOf(2), new User(2, "emscallcenter", "Jane", "Smith", 1));
	}
	
	public User getUser(Integer userUuid){
		return this.userMap.get(userUuid);
	}
}
