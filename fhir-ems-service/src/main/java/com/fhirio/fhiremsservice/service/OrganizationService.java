package com.fhirio.fhiremsservice.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.fhirio.fhiremsservice.domain.Emergency;
import com.fhirio.fhiremsservice.domain.Organization;

public class OrganizationService {
	private Map<Integer, Organization> organizationMap = new HashMap<>();
	@Autowired
	private EmergencyService emergencyService;
	
	public OrganizationService(){
		// bootstrap organizations
		Organization org = new Organization(Integer.valueOf(1));
		org.setPendingEmergencyIds(Arrays.asList(Integer.valueOf(1),Integer.valueOf(2)));
		org.setActiveEmergencyIds(Arrays.asList(Integer.valueOf(3)));
		org.setClosedEmergencyIds(Arrays.asList(Integer.valueOf(4),Integer.valueOf(5)));
		organizationMap.put(Integer.valueOf(1), org);
	}
	
	public Organization getOrganization(Integer organizationUuid){
		return this.organizationMap.get(organizationUuid);
	}
	
	public boolean addPendingEmergency(Integer organizationUuid, Emergency emergency){
		//TODO: add id to organization and persist emergency with EmergencyService.
		return false;
	}
	public boolean movePendingEmergencyToActiveEmergency(Integer organizationUuid, Integer emergencyUuid){
		//TODO
		return false;
	}
	
	public boolean moveActiveEmergencyToClosedEmergency(Integer organizationUuid, Integer emergencyUuid){
		//TODO
		return false;
	}
}
