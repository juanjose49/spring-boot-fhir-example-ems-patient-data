/**
 * Copyright 2017, FHIR I/O - OMSCS CS6440 - Fall 2017 Georgia Tech 
 */
package com.fhirio.fhiremsservice.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fhirio.fhiremsservice.FhirClient;
import com.fhirio.fhiremsservice.domain.Conditions;
import com.fhirio.fhiremsservice.domain.Medications;


/**
 * 
 * @author Team FHIR I/O
 *
 */
@RestController()
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class FhirController {
	//private String baseUrl = "https://fhirtest.uhn.ca/baseDstu2/";
	private String baseUrl = "http://fhirtesting.hdap.gatech.edu/hapi-fhir-jpaserver-example/baseDstu3";
	private FhirClient fhirClient = new FhirClient(baseUrl);
	
	/**
	 * Web service end point which returns the medication details for the given patient id.
	 * @PathVariable("patientUuid")
	 * @return List<Medication>
	 */
	@RequestMapping(value = "/patient/{patientUuid}/medications", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Medications getPatientMedications(@PathVariable("patientUuid") String patientUuid) {
		return new Medications(fhirClient.getPatientMedications(patientUuid));
	}
	
	/**
	 * Web service end point which returns the condition details for the given patient id.
	 * @PathVariable("patientUuid")
	 * @return List<Condition>
	 */
	@RequestMapping(value = "/patient/{patientUuid}/conditions", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Conditions getPatientConditions(@PathVariable("patientUuid") String patientUuid) {
	
		return new Conditions(fhirClient.getPatientConditions(patientUuid));
	}
}
