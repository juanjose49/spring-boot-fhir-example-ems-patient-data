package com.fhirio.fhiremsservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class FhirEmsController {

	@RequestMapping(value = "/hello-world", method = RequestMethod.GET)
	public ResponseEntity<String> getHelloWorld() {
		return new ResponseEntity<String>("Hello World!", HttpStatus.OK);
	}
	
}