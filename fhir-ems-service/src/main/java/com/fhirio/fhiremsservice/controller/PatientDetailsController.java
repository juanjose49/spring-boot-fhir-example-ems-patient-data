/**
 * Copyright 2017, FHIR I/O - OMSCS CS6440 - Fall 2017 Georgia Tech 
 */
package com.fhirio.fhiremsservice.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fhirio.fhiremsservice.Connection;
import com.fhirio.fhiremsservice.PatientDetails;

/**
 * 
 * @author Team FHIR I/O
 *
 */
@RestController()
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class PatientDetailsController {
	/**
	 * Instance Variables
	 */
	private String baseUrl = "https://fhirtest.uhn.ca/baseDstu2/";
	
	/**
	 * Web service end point which returns the patient name for the given patient id.
	 * @param request
	 * @param response
	 * @return patient name
	 */
	@RequestMapping(value = "/getPatientName.json", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getPatientName(HttpServletRequest request, HttpServletResponse response) {

		PatientDetails patientDetails = new PatientDetails(new Connection(baseUrl));
	
		return patientDetails.getNameByPatientID(request.getParameter("id"));
	}
	
	/**
	 * Web service end point which returns the patient name for the given patient id.
	 * @param request
	 * @param response
	 * @return patient id list
	 */
	@RequestMapping(value = "/getPatientIdList.json", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<String> getPatientIdList(HttpServletRequest request, HttpServletResponse response) {

		PatientDetails patientDetails = new PatientDetails(new Connection(baseUrl));
	
		return patientDetails.getIDByPatientName(request.getParameter("name"));
	}
}
