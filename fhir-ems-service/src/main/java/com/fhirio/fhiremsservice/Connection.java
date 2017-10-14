/**
 * Copyright 2017, FHIR I/O - OMSCS CS6440 - Fall 2017 Georgia Tech 
 */
package com.fhirio.fhiremsservice;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.client.api.IGenericClient;

/**
 * 
 * @author Team FHIR I/O
 *
 */
public class Connection {

	private IGenericClient client = null;

	public Connection(String baseUrl) {
		FhirContext fhirContext = FhirContext.forDstu2();
		this.client = fhirContext.newRestfulGenericClient(baseUrl);
	}

	public IGenericClient getClient() {
		return client;
	}

}