package com.fhirio.fhiremsservice.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.fhirio.fhiremsservice.domain.Organization;

public class OrganizationService {
	private Map<Integer, Organization> organizationMap = new HashMap<>();

	/**
	 * Basic constructor that initializes some mock data.
	 */
	public OrganizationService(){
		// bootstrap organizations
		Organization org = new Organization();
		org.setOrganizationUuid(Integer.valueOf(1));
		org.setEmergencyUuids(Arrays.asList(1,2,3,4,5));
		organizationMap.put(Integer.valueOf(1), org);
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
	 * Saves the given Organization with a new UUID.
	 * 
	 * @param organization the Organization to save.
	 * @return the Organization with updated UUID.
	 */
	public Organization saveOrganization(Organization organization){
		Integer uuid = UUID.randomUUID().toString().hashCode();
		organization.setOrganizationUuid(uuid);
		this.organizationMap.put(uuid, organization);
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
}
