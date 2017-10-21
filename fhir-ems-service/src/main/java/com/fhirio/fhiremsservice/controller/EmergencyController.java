package com.fhirio.fhiremsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fhirio.fhiremsservice.domain.Emergency;
import com.fhirio.fhiremsservice.service.EmergencyService;

@RestController()
@RequestMapping("/api/emergency")
@CrossOrigin(origins = "*")
public class EmergencyController {
	@Autowired
	private EmergencyService emergencyService;
	
	/**
	 * E.g. curl -X GET http://localhost:8080/api/emergency/1
	 * @param emergencyUuid
	 * @return
	 */
	@RequestMapping(value = "/{emergencyUuid}", method = RequestMethod.GET)
	public ResponseEntity<Emergency> getEmergency(@PathVariable Integer emergencyUuid) {
		Emergency emergency = emergencyService.getEmergency(emergencyUuid);
		if(emergency !=null){
			return new ResponseEntity<Emergency>(emergency, HttpStatus.OK);
		}else{
			return new ResponseEntity<Emergency>(emergency, HttpStatus.NOT_FOUND);
		}
	}
	
}