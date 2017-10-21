package com.fhirio.fhiremsservice.domain;

/**
 * The Patient class is meant to represent all the health information
 * related to a patient involved in an emergency.
 * Note: This will likely be substituted by the FHIR Patient class.
 */
public class Patient {
	/**
	 * The UUID that corresponds to a Patient.
	 */
	private Integer patientUuid;
	
	/**
	 * The Patient's first name.
	 */
	private String firstName;
	
	/**
	 * The Patient's last name.
	 */
	private String lastName;
	
	public Patient(){}
	
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
