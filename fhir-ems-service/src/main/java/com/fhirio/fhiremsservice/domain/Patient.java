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
	
	private Address address = new Address();
	
	private String fhirUuid;

	private String notes = "";
	
	private boolean identified = false;

	public Patient(){}

	public Patient(Integer patientUuid, String notes) {
		super();
		this.patientUuid = patientUuid;
		this.notes = notes;
	}
	
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}


	public String getNotes() {
		return notes;
	}


	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getFhirUuid() {
		return fhirUuid;
	}

	public void setFhirUuid(String fhirUuid) {
		this.fhirUuid = fhirUuid;
	}

	public boolean isIdentified() {
		return identified;
	}

	public void setIdentified(boolean identified) {
		this.identified = identified;
	}
}
