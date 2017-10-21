package com.fhirio.fhiremsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fhirio.fhiremsservice.domain.Authentication;
import com.fhirio.fhiremsservice.domain.Token;
import com.fhirio.fhiremsservice.service.AuthenticationService;


@RestController()
@RequestMapping("/api/authentication")
@CrossOrigin(origins = "*")
public class AuthenticationController {
	@Autowired
	private AuthenticationService authService;
	
	/**
	 * E.g. curl -H "Content-Type: application/json" -X POST -d '{"userName":"emspersonnel","password":"password"}' http://localhost:8080/api/authentication
	 * 
	 * @param auth
	 * @return
	 */
	@RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Token> authenticate(@RequestBody Authentication auth) {
		Token token = authService.authenticate(auth);
		if(token != null){
			return new ResponseEntity<Token>(token, HttpStatus.OK);
		}else{
			return new ResponseEntity<Token>(token, HttpStatus.NOT_FOUND);
		}
	}
}