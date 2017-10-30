package com.fhirio.fhiremsservice.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import com.fhirio.fhiremsservice.domain.Patient;

public class PatientService {
	private Map<Integer, Patient> patientMap = new HashMap<>();
	
	/**
	 * Basic constructor used to initialize mock data.
	 */
	public PatientService(){
		patientMap.put(Integer.valueOf(1), new Patient(1,"Johnathan", "Borne"));
		patientMap.put(Integer.valueOf(2), new Patient(2,"Mary", "Carry"));
		patientMap.put(Integer.valueOf(3), new Patient(3,"Thomas", "Storm"));
		patientMap.put(Integer.valueOf(4), new Patient(4,"Jake", "Flyer"));
		patientMap.put(Integer.valueOf(5), new Patient(5,"Sam", "Martin"));
		patientMap.put(Integer.valueOf(6), new Patient(6,"Terry", "Salami"));
		patientMap.put(Integer.valueOf(7), new Patient(7,"Lily", "Fangs"));
		patientMap.put(Integer.valueOf(8), new Patient(8,"Henry", "Fierce"));
		patientMap.put(Integer.valueOf(9), new Patient(9,"Charles", "Clark"));
		patientMap.put(Integer.valueOf(10), new Patient(10,"Adam", "Klein"));
	}
	
	/**
	 * Retrieves a Patient based on a UUID. 
	 * TODO: use FHIR API to retrieve patients.
	 * 
	 * @param patientUuid the Patient's UUID.
	 * @return the Patient.
	 */
	public Patient getPatient(Integer patientUuid){
		return patientMap.get(patientUuid);
	}

	/**
	 * Gets the Patient Map, which maps a patient's UUID
	 * to the Patient.
	 * 
	 * @return the Patient Map
	 */
	public Map<Integer, Patient> getPatientMap() {
		return patientMap;
	}
	
	/**
	 * Gets the Patient Map, which maps a patient's UUID
	 * to the Patient.
	 */
	public void setPatientMap(Map<Integer, Patient> patientMap) {
		this.patientMap = patientMap;
	}

	public List<Integer> getPossiblePatientUuids(Patient patient) {
		List<Patient> patients = new ArrayList<>(patientMap.values());
		List<Integer> possiblePatientUuids = new ArrayList<>();
		for(int i=0; i<3; i++){
			possiblePatientUuids.add(patients.get(ThreadLocalRandom.current().nextInt(0, patients.size())).getPatientUuid());
		}
		return possiblePatientUuids;
	}
	
}
