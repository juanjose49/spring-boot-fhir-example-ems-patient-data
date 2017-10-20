package com.fhirio.fhiremsservice.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.fhirio.fhiremsservice.domain.Emergency;

public class EmergencyService {
	private Map<Integer, Emergency> emergencyMap = new HashMap<>();
	
	public EmergencyService(){
		Emergency emergency = new Emergency(Integer.valueOf(1),"Student Fainted in Class","1122 Fowler St. 30309",Arrays.asList(1,2));
		emergencyMap.put(Integer.valueOf(1), emergency);
		
		emergency = new Emergency(Integer.valueOf(2),"Car Accident on I85","I85 between exits 89 and 91",Arrays.asList(3,4));
		emergencyMap.put(Integer.valueOf(2), emergency);
		
		emergency = new Emergency(Integer.valueOf(3),"Man had Heart Attack in Restaurant","Subway on Georgia Tech Campus",Arrays.asList(5,6));
		emergencyMap.put(Integer.valueOf(3), emergency);
		
		emergency = new Emergency(Integer.valueOf(4),"Dog bit Man in Neighborhood","2022 Happy Hills 30456",Arrays.asList(7,8));
		emergencyMap.put(Integer.valueOf(4), emergency);
		
		emergency = new Emergency(Integer.valueOf(5),"Alcohol Poisening at PIKE Fraternity","3212 Notso Happy Hills 30213",Arrays.asList(9,10));
		emergencyMap.put(Integer.valueOf(5), emergency);
	}
	public Emergency getEmergency(Integer emergencyUuid){
		return emergencyMap.get(emergencyUuid);
	}
	
	public boolean addEmergency(){
		//TODO
		return false;
	}
	
	public boolean identifyPatient(Integer emergencyUuid,Integer identifiedPatient){
		//TODO
		return false;
	}
}
