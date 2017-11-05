/**
 * Copyright 2017, FHIR I/O - OMSCS CS6440 - Fall 2017 Georgia Tech 
 */
package com.fhirio.fhiremsservice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.hl7.fhir.dstu3.model.Bundle;
import org.hl7.fhir.dstu3.model.Bundle.BundleEntryComponent;
import org.hl7.fhir.dstu3.model.ContactPoint;
import org.hl7.fhir.dstu3.model.ContactPoint.ContactPointSystem;
import org.hl7.fhir.dstu3.model.Observation;
import org.hl7.fhir.dstu3.model.Patient;
import org.hl7.fhir.dstu3.model.Quantity;
import org.hl7.fhir.dstu3.model.Reference;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.model.primitive.IdDt;
import ca.uhn.fhir.rest.api.MethodOutcome;
import ca.uhn.fhir.rest.client.api.IGenericClient;
import ca.uhn.fhir.rest.gclient.StringClientParam;

/**
 * @author Team FHIR I/O
 *
 */
public class FhirClient {
	/**
	 * Instance Variables
	 */
    private IGenericClient client = null;

    /**
     * Constructor
     * @param connection
     */
    public FhirClient(String baseUrl) {
    	@SuppressWarnings("deprecation")
		FhirContext fhirContext = new FhirContext();
		this.client = fhirContext.newRestfulGenericClient(baseUrl);
    }
    
    /**
     * Method to get the current IGeneric Client
     * @return client
     */
	public IGenericClient getClient() {
		return client;
	}


    /**
     * Method to get the name of the patient for the provided id.
     * @param id
     * @return patient name
     */
    public String getNameByPatientID(String id) {
    	Patient patient = getClient().read()
                .resource(Patient.class)
                .withId(id)
                .execute();
		return patient.getName().get(0).getNameAsSingleString();
        
    }

    /**
     * Method to get list of ids for a given name
     * @param name
     * @return idList
     */
    public List<String> getIDByPatientName(String name) {
        List<String> idList = new ArrayList<String>();
        Bundle bundle = (Bundle) getClient().search().forResource(Patient.class)
    			.where(new StringClientParam("name").matches().value(name))
    		      .prettyPrint()
    		      .execute();
        for(BundleEntryComponent entry: bundle.getEntry()){
        	Patient patient = (Patient) entry.getResource();
        	String idURL = patient.getId();
        	int fromIndex = idURL.indexOf("Patient/") + 8;
        	int toIndex = idURL.indexOf("/_history");
        	String idString = idURL.substring(fromIndex, toIndex);
        	
        	idList.add(idString);
        }
        return idList;
    }

    /**
     * Method to get total number of patients
     * for a given LOINC code
     * @param loincCode
     * @return patient count
     */
    public int getTotalNumPatientsByObservation(String loincCode) {
    	HashSet<String> patientIdSet = new HashSet<String>();

        
        Bundle bundle = getClient().search().forResource(Observation.class)
    			.where(Observation.CODE.exactly().code(loincCode))
    		      .returnBundle(Bundle.class)
    		      .execute();
        
        for(BundleEntryComponent entry: bundle.getEntry()){
        	Observation observation = (Observation) entry.getResource();
        	String id = observation.getSubject().getReference();
        	patientIdSet.add(id);
        }
        
        return patientIdSet.size();
    }
    
    /**
     * Method to add a new patient using first name and last name
     * @param firstName
     * @param lastName
     * @return patient id
     */
	public String addPatient(String firstName, String lastName) {

		Patient patient = new Patient();
		patient.addName().setFamily(lastName).addGiven(firstName);

		MethodOutcome outcome = getClient().create()
				.resource(patient).prettyPrint().encodedJson().execute();

		IdDt idDt = (IdDt) outcome.getId();

		return idDt.getIdPart();
	}

	/**
	 * Method to add a new observation with the parameters provided below
	 * @param patientId
	 * @param loincCode
	 * @param loincDisplayName
	 * @param value
	 * @param valueUnit
	 * @param valueCode
	 * @return observation id
	 */
	public String addObservation(String patientId, String loincCode,
			String loincDisplayName, double value, String valueUnit,
			String valueCode) {
		Observation observation = new Observation();

		observation.getCode().addCoding().setSystem("http://loinc.org")
				.setCode(loincCode).setDisplay(loincDisplayName);
		observation.setValue(new Quantity().setValue(value)
				.setUnit(valueUnit).setCode(valueCode));

		observation.setSubject(new Reference(new IdDt("Patient", patientId)));

		MethodOutcome outcomeObservation = getClient().create()
				.resource(observation).prettyPrint().encodedJson().execute();

		IdDt idDtObservation = (IdDt) outcomeObservation.getId();

		return idDtObservation.getIdPart();
	}
	
	/**
	 * Method to update a given patients home phone number
	 * @param patientId
	 * @param homePhoneNumber
	 * @return patient id after successful update
	 */
	public String updatePatientHomePhone(String patientId,
			String homePhoneNumber) {
		
	   	Patient patient = getClient().read()
                .resource(Patient.class)
                .withId(patientId)
                .execute();

	   	ContactPoint contact = new ContactPoint();
	   	contact.setSystem(ContactPointSystem.PHONE);
	   	contact.setValue(homePhoneNumber);
	   	
	   	patient.addTelecom(contact);
	   	
 		MethodOutcome outcome = getClient().update()
				.resource(patient).execute();

		IdDt idDt = (IdDt) outcome.getId();
		
		return idDt.getIdPart();
	}

	/**
	 * Method to update a given observation
	 * @param observationId
	 * @param value
	 * @return observation id after successful update
	 */
	public String updateObservationValue(String observationId, double value) {
	   	Observation observation = getClient().read()
                .resource(Observation.class)
                .withId(observationId)
                .execute();
	   	
	   	observation.setValue(new Quantity().setValue(value));
		
		MethodOutcome outcome = getClient().update()
				.resource(observation).prettyPrint().encodedJson().execute();

		IdDt idDt = (IdDt) outcome.getId();

		return idDt.getIdPart();
	}
    
	/**
	 * Method to delete a patient with given id.
	 * @param patientId
	 */
	public void deletePatient(String patientId) {

		getClient().delete()
				.resourceById(new IdDt("Patient", patientId)).execute();

	}

	/**
	 * Method too delete an observation with given id.
	 * @param observationId
	 */
	public void deleteObservation(String observationId) {
		getClient().delete()
				.resourceById(new IdDt("Observation", observationId)).execute();

	}

}
