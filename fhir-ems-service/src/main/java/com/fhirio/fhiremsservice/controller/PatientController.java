package com.fhirio.fhiremsservice.controller;

import com.fhirio.fhiremsservice.domain.Emergency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fhirio.fhiremsservice.domain.Patient;
import com.fhirio.fhiremsservice.service.PatientService;

@RestController()
@RequestMapping("/api/patient")
@CrossOrigin(origins = "*")
public class PatientController {
	@Autowired
	private PatientService patientService;
	
	/**
	 * E.g. curl -X GET http://localhost:8080/api/patient/1
	 * 
	 * @param patientUuid
	 * @return
	 */
	@RequestMapping(value = "/{patientUuid}", method = RequestMethod.GET)
	public ResponseEntity<Patient> getPatient(@PathVariable Integer patientUuid) {
		Patient patient = patientService.getPatient(patientUuid);
		if(patient !=null){
			return new ResponseEntity<Patient>(patient, HttpStatus.OK);
		}else{
			return new ResponseEntity<Patient>(patient, HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * E.g. curl -H "Content-Type: application/json" -X PUT-d '{"patientUuid":"1","patientNotes":"urgent"}' http://localhost:8080/api/patient/1
	 *
	 * @param patient
	 * @return
	 */
	@RequestMapping(value = "", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Patient> updatePatient(@RequestBody Patient patient) {
		patient = patientService.updatePatient(patient);
		if(patient != null){
			return new ResponseEntity<Patient>(patient, HttpStatus.OK);
		}else{
			return new ResponseEntity<Patient>(patient, HttpStatus.NOT_FOUND);
		}
	}
	
}