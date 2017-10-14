/**
 * Copyright 2017, FHIR I/O - OMSCS CS6440 - Fall 2017 Georgia Tech 
 */
package com.fhirio.fhiremsservice;

import java.util.List;
import java.util.ArrayList;

import ca.uhn.fhir.model.dstu2.resource.Bundle;
import ca.uhn.fhir.model.dstu2.resource.Patient;
import ca.uhn.fhir.model.dstu2.resource.Bundle.Entry;


/**
 * 
 * @author Team FHIR I/O
 *
 */
public class PatientDetails {
    private Connection connection = null;

    public PatientDetails(Connection connection) {
        this.connection = connection;
    }

    public String getNameByPatientID(String id) {
    	Patient patient = connection.getClient().read()
                .resource(Patient.class)
                .withId(id)
                .execute();
		return patient.getName().get(0).getNameAsSingleString();
        
    }

    public List<String> getIDByPatientName(String name) {
        List<String> idList = new ArrayList<String>();
        Bundle bundle = connection.getClient().search().forResource(Patient.class)
    			.where(Patient.NAME.matches().value(name))
    		      .returnBundle(Bundle.class)
    		      .execute();
        for(Entry entry: bundle.getEntry()){
        	Patient patient = (Patient) entry.getResource();
        	idList.add(patient.getId().getIdPart());
        }
        return idList;
    }

}