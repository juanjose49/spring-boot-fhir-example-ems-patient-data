package com.fhirio.fhiremsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
	
}