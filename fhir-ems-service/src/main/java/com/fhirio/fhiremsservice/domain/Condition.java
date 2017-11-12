/**
 * 
 */
package com.fhirio.fhiremsservice.domain;

/**
 * The Condition class is meant to represent the chronic illness information
 * related to a patient involved in an emergency.
 * @author Team FHIR I/O
 *
 */
public class Condition {
	private String conditionUuid;
	private String clinicalStatus;
	private String verificationStatus;
	private String name;
	private String system;
	private String code;
	private String onsetDateTime;
	private String assertedDate;
	
	public String getConditionUuid() {
		return conditionUuid;
	}
	public void setConditionUuid(String conditionUuid) {
		this.conditionUuid = conditionUuid;
	}
	public String getClinicalStatus() {
		return clinicalStatus;
	}
	public void setClinicalStatus(String clinicalStatus) {
		this.clinicalStatus = clinicalStatus;
	}
	public String getVerificationStatus() {
		return verificationStatus;
	}
	public void setVerificationStatus(String verificationStatus) {
		this.verificationStatus = verificationStatus;
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
	public String getOnsetDateTime() {
		return onsetDateTime;
	}
	public void setOnsetDateTime(String onsetDateTime) {
		this.onsetDateTime = onsetDateTime;
	}
	public String getAssertedDate() {
		return assertedDate;
	}
	public void setAssertedDate(String assertedDate) {
		this.assertedDate = assertedDate;
	}

}
