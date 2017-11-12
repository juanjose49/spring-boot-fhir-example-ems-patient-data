/**
 * Copyright 2017, FHIR I/O - OMSCS CS6440 - Fall 2017 Georgia Tech 
 */
package com.fhirio.fhiremsservice.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fhirio.fhiremsservice.FhirClient;
import com.fhirio.fhiremsservice.domain.Address;
import com.fhirio.fhiremsservice.domain.Medication;


/**
 * 
 * @author Team FHIR I/O
 *
 */
@RestController()
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class FhirController {
	/**
	 * Instance Variables
	 */
	//private String baseUrl = "https://fhirtest.uhn.ca/baseDstu2/";
	private String baseUrl = "http://fhirtesting.hdap.gatech.edu/hapi-fhir-jpaserver-example/baseDstu3";
	
	/**
	 * Web service end point which returns the patient name for the given patient id.
	 * @param request
	 * @param response
	 * @return patient name
	 */
	@RequestMapping(value = "/patient/{patientUuid}/name", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getPatientName(@PathVariable("patientUuid") String patientUuid, HttpServletRequest request) {

		FhirClient fhirClient = new FhirClient(baseUrl);
	
		return fhirClient.getNameByPatientID(patientUuid);
	}
	
	/**
	 * Web service end point which returns the patient name for the given patient id.
	 * @param request
	 * @param response
	 * @return patient id list
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/patient/list", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<JSONObject> getPatientDetails(HttpServletRequest request) {

		FhirClient fhirClient = new FhirClient(baseUrl);
		
		Address address = new Address(request.getParameter("address"), request.getParameter("address-city"), request.getParameter("address-state"), request.getParameter("address-country"), request.getParameter("address-postalcode"));
	
		List<JSONObject> patientDetails = fhirClient.getPatientDetails(request.getParameter("name"), address);
		if(patientDetails.isEmpty()){
			JSONObject errorJSON = new JSONObject();
			errorJSON.put("error", "No matches found for the given search.");
			patientDetails.add(errorJSON);
		} else if (patientDetails.size() > 10) {
			JSONObject errorJSON = new JSONObject();
			errorJSON.put("error", "Result set is too broad for the given search.");
			patientDetails.add(errorJSON);
		}
		
		return patientDetails;
	}
	
	/**
	 * Web service end point which returns the patient name for the given patient id.
	 * @param request
	 * @param response
	 * @return patient id list
	 */
	@RequestMapping(value = "/patient/id/list", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<String> getPatientIdList(HttpServletRequest request) {

		FhirClient fhirClient = new FhirClient(baseUrl);
		
	
		return fhirClient.getIDByPatientName(request.getParameter("name"));
	}
	
	/**
	 * Web service end point which returns the patient name for the given patient id.
	 * @param request
	 * @param response
	 * @return patient name
	 */
	@RequestMapping(value = "/patient/{patientUuid}/medications", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Medication> getPatientMedications(@PathVariable("patientUuid") String patientUuid) {

		FhirClient fhirClient = new FhirClient(baseUrl);
	
		return fhirClient.getPatientMedications(patientUuid);
	}
}
