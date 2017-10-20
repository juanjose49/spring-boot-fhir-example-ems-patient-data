package com.fhirio.fhiremsservice.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.fhirio.fhiremsservice.domain.Emergency;

public class EmergencyService {
	private Map<Integer, Emergency> emergencyMap = new HashMap<>();
	
	/**
	 * Basic constructor that initializes EmergencyService with mock
	 * data.
	 */
	public EmergencyService(){
		Emergency emergency = new Emergency(Integer.valueOf(1),"Student Fainted in Class","1122 Fowler St. 30309",Arrays.asList(1,2));
		emergencyMap.put(Integer.valueOf(1), emergency);
		
		emergency = new Emergency(Integer.valueOf(2),"Car Accident on I85","I85 between exits 89 and 91",Arrays.asList(3,4));
		emergencyMap.put(Integer.valueOf(2), emergency);
		
		emergency = new Emergency(Integer.valueOf(3),"Man had Heart Attack in Restaurant","Subway on Georgia Tech Campus",Arrays.asList(5,6));
		emergencyMap.put(Integer.valueOf(3), emergency);
		
		emergency = new Emergency(Integer.valueOf(4),"Dog bit Man in Neighborhood","2022 Happy Hills 30456",Arrays.asList(7,8));
		emergencyMap.put(Integer.valueOf(4), emergency);
		
		emergency = new Emergency(Integer.valueOf(5),"Alcohol Poisoning at PIKE Fraternity","3212 Notso Happy Hills 30213",Arrays.asList(9,10));
		emergencyMap.put(Integer.valueOf(5), emergency);
	}
	/**
	 * Get an Emergency based on the Emergency's UUID.
	 * 
	 * @param emergencyUuid the Emergency UUID.
	 * @return the Emergency.
	 */
	public Emergency getEmergency(Integer emergencyUuid){
		return emergencyMap.get(emergencyUuid);
	}
	
	/**
	 * Saves an Emergency object to memory assigning it a 
	 * UUID. The updated Emergency object is returned with its new
	 * UUID.
	 * 
	 * @param emergency the Emergency that will be saved.
	 * @return the updated Emergency with new UUID.
	 */
	public Emergency saveEmergency(Emergency emergency){
		//TODO
		return null;
	}
	
	/**
	 * This method is invoked once a Patient has been positively
	 * identified. The Emergency represented by the emergencyUuid
	 * will be updated to reflect the identifiedPatient's UUID.
	 * 
	 * @param emergencyUuid the UUID of the Emergency that needs to be updated.
	 * @param identifiedPatientUuid the identified Patient's UUID.
	 * @return the updated Emergency reflecting the changes.
	 */
	public Emergency identifyPatient(Integer emergencyUuid,Integer identifiedPatientUuid){
		//TODO
		return null;
	}
	
	/**
	 * Gets the Emergency Map, which maps the Emergency's UUID
	 * to the Emergency itself.
	 * 
	 * @return the Emergency Map.
	 */
	public Map<Integer, Emergency> getEmergencyMap() {
		return emergencyMap;
	}
	
	/**
	 * Sets the Emergency Map, which maps the Emergency's UUID
	 * to the Emergency itself.
	 */
	public void setEmergencyMap(Map<Integer, Emergency> emergencyMap) {
		this.emergencyMap = emergencyMap;
	}
}
