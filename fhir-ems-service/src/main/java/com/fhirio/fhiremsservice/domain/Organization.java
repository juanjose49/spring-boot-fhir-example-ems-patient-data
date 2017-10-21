package com.fhirio.fhiremsservice.domain;

import java.util.List;

/**
 * The Organization class is what binds together Users of
 * the EMS service and Emergencies.
 */
public class Organization {
	/**
	 * The UUID that corresponds to the Organization.
	 */
	private Integer organizationUuid;
	
	/**
	 * The List of UUIDs that corresponds to all the 
	 * Emergencies handled by the Organization.
	 */
	private List<Integer> emergencyUuids;
	
	private List<Emergency> emergencies;
	
	public Organization(){}
	
	public Integer getOrganizationUuid() {
		return organizationUuid;
	}
	public void setOrganizationUuid(Integer organizationUuid) {
		this.organizationUuid = organizationUuid;
	}
	public List<Integer> getEmergencyUuids() {
		return emergencyUuids;
	}
	public void setEmergencyUuids(List<Integer> emergencyUuids) {
		this.emergencyUuids = emergencyUuids;
	}

	public List<Emergency> getEmergencies() {
		return emergencies;
	}

	public void setEmergencies(List<Emergency> emergencies) {
		this.emergencies = emergencies;
	}

}