package com.fhirio.fhiremsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
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
}