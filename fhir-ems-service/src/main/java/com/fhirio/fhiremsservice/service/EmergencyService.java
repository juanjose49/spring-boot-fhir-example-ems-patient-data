package com.fhirio.fhiremsservice.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.fhirio.fhiremsservice.domain.Emergency;
import com.fhirio.fhiremsservice.domain.EmergencyState;
import com.fhirio.fhiremsservice.domain.Patient;

public class EmergencyService {
	private Map<Integer, Emergency> emergencyMap = new HashMap<>();
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private OrganizationService orgService;
	
	/**
	 * Basic constructor that initializes EmergencyService with mock
	 * data.
	 */
	public EmergencyService(){
		Emergency emergency = new Emergency(Integer.valueOf(101),"Student Fainted in Class","1122 Fowler St. 30309",Arrays.asList(131,132), EmergencyState.PENDING,121);
		saveEmergency(emergency);
		
		emergency = new Emergency(Integer.valueOf(102),"Car Accident on I85","I85 between exits 89 and 91",Arrays.asList(133,134), EmergencyState.PENDING,121);
		saveEmergency(emergency);
		
		emergency = new Emergency(Integer.valueOf(103),"Man had Heart Attack in Restaurant","Subway on Georgia Tech Campus",Arrays.asList(135,136), EmergencyState.ACTIVE,121);
		saveEmergency(emergency);
		
		emergency = new Emergency(Integer.valueOf(104),"Dog bit Man in Neighborhood","2022 Happy Hills 30456",Arrays.asList(137,138), EmergencyState.CLOSED,121);
		saveEmergency(emergency);
		
		emergency = new Emergency(Integer.valueOf(105),"Alcohol Poisoning at PIKE Fraternity","3212 Notso Happy Hills 30213",Arrays.asList(139,1310), EmergencyState.CLOSED,121);
		saveEmergency(emergency);
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
	
	public Emergency getVerboseEmergency(Integer emergencyUuid) {
		Emergency emergency = this.getEmergency(emergencyUuid);
		
		List<Patient> possiblePatients = new ArrayList<>();
		for(Integer patientId : emergency.getPossiblePatientUuids()){
			Patient patient = patientService.getPatient(patientId);
			if(patient != null){
				if(patient.isIdentified()){
					possiblePatients = new ArrayList<>();
					possiblePatients.add(patient);
					break;
				}else{
					possiblePatients.add(patient);
				}
			}
		}
		
		Emergency verboseEmergency = new Emergency();
		verboseEmergency.setEmergencyUuid(emergency.getEmergencyUuid());
		verboseEmergency.setEmergencyState(emergency.getEmergencyState());
		verboseEmergency.setEmergencyTitle(emergency.getEmergencyTitle());
		verboseEmergency.setIdentifiedPatientUuid(emergency.getIdentifiedPatientUuid());
		verboseEmergency.setPickupLocation(emergency.getPickupLocation());
		verboseEmergency.setPossiblePatients(possiblePatients);
		return verboseEmergency;
	}
	
	/**
	 * Saves an Emergency object to memory assigning it a 
	 * UUID. The updated Emergency object is returned with its new
	 * UUID.
	 * 
	 * @param emergency the Emergency that will be saved.
	 * @return the updated Emergency with new UUID.
	 */
	public Emergency createEmergency(Emergency emergency) {
		emergency.setEmergencyUuid(UuidService.getUuid());
		emergency.setEmergencyState(EmergencyState.PENDING);
		List<Integer> possiblePatientUuids = 
				patientService.getPossiblePatientUuids(emergency.getPatient());
		emergency.setPossiblePatientUuids(possiblePatientUuids);
		emergency = saveEmergency(emergency);
		orgService.addEmergencyUuidToOrganization(
				emergency.getOrganizationUuid(), emergency.getEmergencyUuid());
		return emergency;
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
	
	protected Emergency saveEmergency(Emergency emergency){
		emergencyMap.put(emergency.getEmergencyUuid(), emergency);
		return emergency;
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
	public Emergency updateEmergency(Emergency emergency) {
		if(getEmergency(emergency.getEmergencyUuid()) != null){
			return saveEmergency(emergency);
		}
		return null;
	}
	public Emergency deleteEmergency(Integer emergencyUuid) {
		Emergency emergency = getEmergency(emergencyUuid);
		if(emergency != null){
			orgService.removeEmergencyUuidFromOrganization(
					emergency.getOrganizationUuid(), emergency.getEmergencyUuid());
			emergencyMap.remove(emergency.getEmergencyUuid());
			return emergency;
		}
		return null;
	}


}
