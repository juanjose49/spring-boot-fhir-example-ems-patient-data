/**
 * 
 */
package com.fhirio.fhiremsservice.domain;

/**
 * The Medication class is meant to represent the medication information
 * related to a patient involved in an emergency.
 * @author Team FHIR I/O
 *
 */
public class Medication {

	private String medicationUuid;
	private String status;
	private String name;
	private String system;
	private String code;
	private String description;
	private String conditionName;
	private String conditionUuid;
	
	public String getMedicationUuid() {
		return medicationUuid;
	}
	public void setMedicationUuid(String medicationUuid) {
		this.medicationUuid = medicationUuid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSystem() {
		return system;
	}
	public void setSystem(String system) {
		this.system = system;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getConditionName() {
		return conditionName;
	}
	public void setConditionName(String conditionName) {
		this.conditionName = conditionName;
	}
	public String getConditionUuid() {
		return conditionUuid;
	}
	public void setConditionUuid(String conditionUuid) {
		this.conditionUuid = conditionUuid;
	}
	
	
}
