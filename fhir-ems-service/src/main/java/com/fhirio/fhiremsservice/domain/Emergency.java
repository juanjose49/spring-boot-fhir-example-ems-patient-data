package com.fhirio.fhiremsservice.domain;

import java.util.List;

/**
 * The Emergency class holds all the pertinent information
 * to a specific emergency that may be pending, active or closed.
 *
 */
public class Emergency {
	/**
	 * The UUID corresponding to the Emergency.
	 */
	private Integer emergencyUuid;
	
	/**
	 * The title/headline related to the Emergency.
	 */
	private String emergencyTitle;
	
	/**
	 * The address where the Emergency is taking place.
	 */
	private String pickupLocation;
	
	/**
	 * A List of UUIDs that correspond to patients that
	 * may fit the Patient's profile as found on FHIR API.
	 */
	private List<Integer> possiblePatientUuids;
	
	/**
	 * Once the emergency personnel have positively identified
	 * a Patient, the Patient's UUID will be set on here.
	 */
	private Integer identifiedPatientUuid;
	
	/**
	 * The state of the Emergency.
	 */
	private EmergencyState emergencyState;
	
	public Emergency(){}
	
	public Emergency(Integer emergencyUuid, String emergencyTitle, String pickupLocation,
			List<Integer> possiblePatientUuids, EmergencyState emergencyState) {
		super();
		this.emergencyUuid = emergencyUuid;
		this.emergencyTitle = emergencyTitle;
		this.pickupLocation = pickupLocation;
		this.possiblePatientUuids = possiblePatientUuids;
		this.emergencyState = emergencyState;
	}
	
	public Integer getEmergencyUuid() {
		return emergencyUuid;
	}
	public void setEmergencyUuid(Integer emergencyUuid) {
		this.emergencyUuid = emergencyUuid;
	}
	public String getEmergencyTitle() {
		return emergencyTitle;
	}
	public void setEmergencyTitle(String emergencyTitle) {
		this.emergencyTitle = emergencyTitle;
	}
	public String getPickupLocation() {
		return pickupLocation;
	}
	public void setPickupLocation(String pickupLocation) {
		this.pickupLocation = pickupLocation;
	}
	public List<Integer> getPossiblePatientUuids() {
		return possiblePatientUuids;
	}
	public void setPossiblePatientUuids(List<Integer> possiblePatientUuids) {
		this.possiblePatientUuids = possiblePatientUuids;
	}
	public Integer getIdentifiedPatientUuid() {
		return identifiedPatientUuid;
	}
	public void setIdentifiedPatientUuid(Integer identifiedPatientUuid) {
		this.identifiedPatientUuid = identifiedPatientUuid;
	}
	public EmergencyState getEmergencyState() {
		return emergencyState;
	}
	public void setEmergencyState(EmergencyState emergencyState) {
		this.emergencyState = emergencyState;
	}
	
	
}
