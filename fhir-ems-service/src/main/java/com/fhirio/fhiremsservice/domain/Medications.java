package com.fhirio.fhiremsservice.domain;

import java.util.List;

public class Medications {
	private List<Medication> medications;

	public Medications() {}

	public Medications(List<Medication> medications) {
		super();
		this.medications = medications;
	}
	public List<Medication> getMedications() {
		return medications;
	}

	public void setMedications(List<Medication> medications) {
		this.medications = medications;
	}
	
}
