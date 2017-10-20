package com.fhirio.fhiremsservice.domain;

/**
 * This will likely be substituted by the FHIR Patient concept.
 */
public class Patient {
	private Integer patientUuid;
	private String firstName;
	private String lastName;
	
	
	public Patient(Integer patientUuid, String firstName, String lastName) {
		super();
		this.patientUuid = patientUuid;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Integer getPatientUuid() {
		return patientUuid;
	}
	public void setPatientUuid(Integer patientUuid) {
		this.patientUuid = patientUuid;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
