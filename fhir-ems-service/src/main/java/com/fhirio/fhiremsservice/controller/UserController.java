package com.fhirio.fhiremsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fhirio.fhiremsservice.domain.User;
import com.fhirio.fhiremsservice.service.UserService;


@RestController()
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")
public class UserController {
	@Autowired
	private UserService userService;
	
	/**
	 * E.g. curl -X GET http://localhost:8080/api/user/1
	 * 
	 * @param userUuid
	 * @return
	 */
	@RequestMapping(value = "/{userUuid}", method = RequestMethod.GET)
	public ResponseEntity<User> getUser(@PathVariable Integer userUuid) {
		User user = userService.getUser(userUuid);
		if(user !=null){
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}else{
			return new ResponseEntity<User>(user, HttpStatus.NOT_FOUND);
		}
	}
	/**
	 * New Super U ser (Creates Organization): E.g. curl -H "Content-Type: application/json" -X POST -d '{"userName":"newuser","password":"mypassword","firstName":"Tim","lastName":"Classyman","organization":{"name":"New Organization"}}' http://localhost:8080/api/user
	 * New Org User (Created by Super User): E.g. curl -H "Content-Type: application/json" -X POST -d '{"userName":"newuser","password":"mypassword","firstName":"Tim","lastName":"Classyman","organizationUuid":1}' http://localhost:8080/api/user
	 * @param user    
	 * @return
	 */
	@RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> createUser(@RequestBody User user) {
		if(user.getOrganization() == null){
			user = userService.createUser(user);
		}else{
			user = userService.createSuperUser(user);
		}
		
		if(user !=null){
			return new ResponseEntity<User>(user, HttpStatus.CREATED);
		}else{
			return new ResponseEntity<User>(user, HttpStatus.CONFLICT);
		}
	}
}