/**
 * Copyright 2017, FHIR I/O - OMSCS CS6440 - Fall 2017 Georgia Tech 
 */
package com.fhirio.fhiremsservice;

import java.util.HashSet;
import ca.uhn.fhir.model.dstu2.resource.Bundle;
import ca.uhn.fhir.model.dstu2.resource.Observation;
import ca.uhn.fhir.model.dstu2.resource.Bundle.Entry;

/**
 * 
 * @author Team FHIR I/O
 *
 */
public class ObservationDetails {

    private Connection connection = null;

    public ObservationDetails(Connection connection) {
        this.connection = connection;
    }

    public int getTotalNumPatientsByObservation(String loincCode) {
    	HashSet<String> patientIdSet = new HashSet<String>();

        
        Bundle bundle = connection.getClient().search().forResource(Observation.class)
    			.where(Observation.CODE.exactly().code(loincCode))
    		      .returnBundle(Bundle.class)
    		      .execute();
        
        for(Entry entry: bundle.getEntry()){
        	Observation observation = (Observation) entry.getResource();
        	String id = observation.getSubject().getReference().getIdPart();
        	patientIdSet.add(id);
        }
        
        return patientIdSet.size();
    }

}