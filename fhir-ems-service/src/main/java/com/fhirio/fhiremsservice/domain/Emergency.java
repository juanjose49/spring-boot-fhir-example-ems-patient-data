package com.fhirio.fhiremsservice.domain;

import java.util.List;

public class Emergency {
	private Integer emergencyUuid;
	private String emergencyTitle;
	private String pickupLocation;
	private List<Integer> possiblePatientUuids;
	private Integer identifiedPatientUuid;
	
	
	public Emergency(Integer emergencyUuid, String emergencyTitle, String pickupLocation,
			List<Integer> possiblePatientUuids) {
		super();
		this.emergencyUuid = emergencyUuid;
		this.emergencyTitle = emergencyTitle;
		this.pickupLocation = pickupLocation;
		this.possiblePatientUuids = possiblePatientUuids;
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
	
	
}
