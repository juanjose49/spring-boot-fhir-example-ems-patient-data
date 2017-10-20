package com.fhirio.fhiremsservice.domain;

import java.util.ArrayList;
import java.util.List;

public class Organization {
	private Integer organizationUuid;
	private List<Integer> pendingEmergencyIds = new ArrayList<>();
	private List<Integer> activeEmergencyIds = new ArrayList<>();
	private List<Integer> closedEmergencyIds = new ArrayList<>();
	
	public Organization(Integer organizationUuid) {
		super();
		this.organizationUuid = organizationUuid;
	}
	
	public Integer getOrganizationUuid() {
		return organizationUuid;
	}
	public void setOrganizationUuid(Integer organizationUuid) {
		this.organizationUuid = organizationUuid;
	}
	public List<Integer> getPendingEmergencyIds() {
		return pendingEmergencyIds;
	}
	public void setPendingEmergencyIds(List<Integer> pendingEmergencyIds) {
		this.pendingEmergencyIds = pendingEmergencyIds;
	}
	public List<Integer> getActiveEmergencyIds() {
		return activeEmergencyIds;
	}
	public void setActiveEmergencyIds(List<Integer> activeEmergencyIds) {
		this.activeEmergencyIds = activeEmergencyIds;
	}
	public List<Integer> getClosedEmergencyIds() {
		return closedEmergencyIds;
	}
	public void setClosedEmergencyIds(List<Integer> closedEmergencyIds) {
		this.closedEmergencyIds = closedEmergencyIds;
	}
}
