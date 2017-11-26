package com.fhirio.fhiremsservice.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;

import com.fhirio.fhiremsservice.domain.Authentication;
import com.fhirio.fhiremsservice.domain.Organization;
import com.fhirio.fhiremsservice.domain.User;

public class UserService {
	@Autowired
	private AuthenticationService authService;
	
	@Autowired
	private OrganizationService orgService;
	
	private HashMap<Integer, User> userMap = new HashMap<>();
	/**
	 * Basic constructor initializing mock users.
	 */
	public UserService(){
		//bootstrap users
		saveUser(new User(111, "emspersonnel", "John", "Smith", 121));
		saveUser(new User(112, "emscallcenter", "Jane", "Smith", 121));
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

	/**
	 * Adds a user to the userMap. 
	 * 
	 * @param user the user to be added.
	 * @return the updated user with UUID.
	 */
	public User createUser(User user) {
		for(User userInMap : userMap.values()){
			if(userInMap.getUserName().equals(user.getUserName())){
				return null;
			}
		}
		user.setUserUuid(UuidService.getUuid());
		Authentication auth = authService.createAuthentication(user);
		if(auth != null){
			saveUser(user);
		}else{
			return null;
		}
		orgService.addUserUuidToOrganization(user.getOrganizationUuid(), user.getUserUuid());

		return user;
	}

	protected void saveUser(User user) {
		userMap.put(user.getUserUuid(), user);
	}

	public User createSuperUser(User user) {
		Organization org = user.getOrganization();
		
		org = orgService.createOrganization(org);
		user.setOrganization(null);
		user.setOrganizationUuid(org.getOrganizationUuid());
		user = createUser(user);
		return user;
	}
}
