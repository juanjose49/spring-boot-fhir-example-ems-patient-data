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
import org.springframework.web.bind.annotation.RequestParam;
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
	public ResponseEntity<Emergency> getEmergency(
			@RequestParam(value="verbose", required=false, defaultValue="false") Boolean isVerbose,
			@PathVariable Integer emergencyUuid) {
		Emergency emergency = null;
		if(isVerbose){
			emergency = emergencyService.getVerboseEmergency(emergencyUuid);
		}else{
			emergency = emergencyService.getEmergency(emergencyUuid);
		}
		
		if(emergency != null){
			return new ResponseEntity<Emergency>(emergency, HttpStatus.OK);
		}else{
			return new ResponseEntity<Emergency>(emergency, HttpStatus.NOT_FOUND);
		}
	}
	
	/**
	 * E.g. curl -H "Content-Type: application/json" -X POST -d '{"emergencyTitle":"New Emergency Title","pickupLocation":"5599 Ice Town Dr.","patient":{"firstName":"Katheryn","lastName":"Adams"},"organizationUuid":1}' http://localhost:8080/api/emergency
	 * 
	 * @param emergency
	 * @return
	 */
	@RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Emergency> createEmergency(@RequestBody Emergency emergency) {
		emergency = emergencyService.createEmergency(emergency);
		return new ResponseEntity<Emergency>(emergency, HttpStatus.CREATED);
	}
	
	/**
	 * E.g. update organizationId: curl -H "Content-Type: application/json" -X PUT -d '{"emergencyUuid":1,"emergencyTitle":"Student Fainted in Class","pickupLocation":"1122 Fowler St. 30309","patient":null,"possiblePatientUuids":[1,2],"possiblePatients":[],"identifiedPatientUuid":null,"emergencyState":"PENDING","organizationUuid":2}' http://localhost:8080/api/emergency
	 * 
	 * @param emergency
	 * @return
	 */
	@RequestMapping(value = "", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Emergency> updateEmergency(@RequestBody Emergency emergency) {
		emergency = emergencyService.updateEmergency(emergency);
		if(emergency != null){
			return new ResponseEntity<Emergency>(emergency, HttpStatus.OK);
		}else{
			return new ResponseEntity<Emergency>(emergency, HttpStatus.NOT_FOUND);
		}
	}
	
	/**
	 * E.g. curl -X DELETE http://localhost:8080/api/emergency/1
	 * 
	 * @param emergency
	 * @return
	 */
	@RequestMapping(value = "/{emergencyUuid}", method = RequestMethod.DELETE)
	public ResponseEntity<Emergency> deleteEmergency(@PathVariable Integer emergencyUuid) {
		Emergency emergency = emergencyService.deleteEmergency(emergencyUuid);
		if(emergency != null){
			return new ResponseEntity<Emergency>(emergency, HttpStatus.OK);
		}else{
			return new ResponseEntity<Emergency>(emergency, HttpStatus.NOT_FOUND);
		}
	}
}