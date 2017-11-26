package com.fhirio.fhiremsservice.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.fhirio.fhiremsservice.domain.Emergency;
import com.fhirio.fhiremsservice.domain.Organization;

public class OrganizationService {
	private Map<Integer, Organization> organizationMap = new HashMap<>();
	@Autowired
	private EmergencyService emergencyService;
	/**
	 * Basic constructor that initializes some mock data.
	 */
	public OrganizationService(){
		// bootstrap organizations
		Organization org = new Organization();
		org.setOrganizationUuid(121);
		org.setEmergencyUuids(new ArrayList<Integer>(Arrays.asList(101,102,103,104,105)));
		org.setName("Mock Organization");
		org.setUserUuids(new ArrayList<Integer>(Arrays.asList(111,112)));
		saveOrganization(org);
	}
	
	/**
	 * Gets an Organization based on a UUID.
	 * 
	 * @param organizationUuid the Organization's UUID.
	 * @return the Organization.
	 */
	public Organization getOrganization(Integer organizationUuid){
		return this.organizationMap.get(organizationUuid);
	}
	
	/**
	 * Returns an Organization with all of the Emergencies loaded 
	 * instead of only the UUIDs.
	 * 
	 * @param organizationUuid the Organization UUID.
	 * @return the verbose Organization.
	 */
	public Organization getVerboseOrganiation(Integer organizationUuid) {
		Organization organization = this.getOrganization(organizationUuid);
		List<Emergency> emergencies = new ArrayList<>();
		for(Integer emergencyId : organization.getEmergencyUuids()){
			Emergency emergency = emergencyService.getEmergency(emergencyId);
			if(emergency != null){
				emergencies.add(emergency);
			}
		}
		Organization verboseOrganization = new Organization();
		verboseOrganization.setOrganizationUuid(organization.getOrganizationUuid());
		verboseOrganization.setEmergencies(emergencies);
		return verboseOrganization;
	}
	
	/**
	 * Saves the given Organization with a new UUID.
	 * 
	 * @param organization the Organization to save.
	 * @return the Organization with updated UUID.
	 */
	public Organization saveOrganization(Organization organization){
		this.organizationMap.put(organization.getOrganizationUuid(), organization);
		return organization;
	}
	
	/**
	 * Replaces the existing Organization that has a matching UUID.
	 * 
	 * @param organization the updated Organization
	 * @return the updated Organization.
	 */
	public Organization updateOrganization(Organization organization){
		//TODO
		return null;
	}
	
	/**
	 * Gets the Organization Map, which maps a UUID to the
	 * corresponding Organization.
	 * 
	 * @return the Organization Map.
	 */
	public Map<Integer, Organization> getOrganizationMap() {
		return organizationMap;
	}

	/**
	 * Sets the Organization Map, which maps a UUID to the
	 * corresponding Organization.
	 */
	public void setOrganizationMap(Map<Integer, Organization> organizationMap) {
		this.organizationMap = organizationMap;
	}

	public Organization createOrganization(Organization organization) {
		organization.setOrganizationUuid(UuidService.getUuid());
		organization = saveOrganization(organization);
		return organization;
	}

	public Organization addEmergencyUuidToOrganization(Integer organizationUuid, Integer emergencyUuid){
		Organization org = getOrganization(organizationUuid);
		org.getEmergencyUuids().add(emergencyUuid);
		saveOrganization(org);
		return org;
	}
	
	public Organization addUserUuidToOrganization(Integer organizationUuid, Integer userUuid){
		Organization org = getOrganization(organizationUuid);
		org.getUserUuids().add(userUuid);
		saveOrganization(org);
		return org;
	}

	public Organization removeEmergencyUuidFromOrganization(Integer organizationUuid, Integer emergencyUuid) {
		Organization org = getOrganization(organizationUuid);
		org.getEmergencyUuids().remove(emergencyUuid);
		saveOrganization(org);
		return org;
	}

}
