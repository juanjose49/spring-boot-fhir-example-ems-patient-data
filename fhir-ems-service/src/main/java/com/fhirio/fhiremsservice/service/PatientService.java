package com.fhirio.fhiremsservice.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fhirio.fhiremsservice.domain.*;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import com.fhirio.fhiremsservice.FhirClient;

public class PatientService {
	private Map<Integer, Patient> patientMap = new HashMap<>();
	@Autowired
	private FhirClient fhirClient;
	/**
	 * Basic constructor used to initialize mock data.
	 */
	public PatientService(){
		patientMap.put(Integer.valueOf(131), new Patient(131,"Johnathan", "Borne"));
		patientMap.put(Integer.valueOf(132), new Patient(132,"Mary", "Carry"));
		patientMap.put(Integer.valueOf(133), new Patient(133,"Thomas", "Storm"));
		patientMap.put(Integer.valueOf(134), new Patient(134,"Jake", "Flyer"));
		patientMap.put(Integer.valueOf(135), new Patient(135,"Sam", "Martin"));
		patientMap.put(Integer.valueOf(136), new Patient(136,"Terry", "Salami"));
		patientMap.put(Integer.valueOf(137), new Patient(137,"Lily", "Fangs"));
		patientMap.put(Integer.valueOf(138), new Patient(138,"Henry", "Fierce"));
		patientMap.put(Integer.valueOf(139), new Patient(139,"Charles", "Clark"));
		patientMap.put(Integer.valueOf(1310), new Patient(1310,"Adam", "Klein"));
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
		patient = createPatient(patient);
		List<Integer> possiblePatientUuids = new ArrayList<>();
		possiblePatientUuids.add(patient.getPatientUuid());
		for(Patient fhirPatient : fhirClient.getPossiblePatients(patient)){
			fhirPatient = createPatient(fhirPatient);
			possiblePatientUuids.add(fhirPatient.getPatientUuid());
		}
		return possiblePatientUuids;
	}

	public Patient createPatient(Patient patient) {
		patient.setPatientUuid(UuidService.getUuid());
		patient = savePatient(patient);
		return patient;
	}

	public Patient savePatient(Patient patient) {
		patientMap.put(patient.getPatientUuid(), patient);
		return patient;
	}

	public String getNameByPatientID(String id) {
		return fhirClient.getNameByPatientID(id);
	}


	public List<String> getIDByPatientName(String id) {
		return fhirClient.getIDByPatientName(id);
	}

	public List<String> getIDByPatientFullName(String firstName, String lastName) {
		return fhirClient.getIDByPatientFullName(firstName, lastName);
	}

	public List<com.fhirio.fhiremsservice.domain.Patient> getPossiblePatients(
			com.fhirio.fhiremsservice.domain.Patient patient) {
		return fhirClient.getPossiblePatients(patient);
	}

	public List<JSONObject> getPatientDetails(String name, Address address) {
		return fhirClient.getPatientDetails(name, address);
	}

	public List<Medication> getPatientMedications(String patientUuid) {
		return fhirClient.getPatientMedications(patientUuid);
	}

	public List<Condition> getPatientConditions(String patientUuid) {
		return fhirClient.getPatientConditions(patientUuid);
	}

	public String addPatient(String firstName, String lastName) {
		return fhirClient.addPatient(firstName, lastName);
	}

	public String addObservation(String patientId, String loincCode,
								 String loincDisplayName, double value, String valueUnit,
								 String valueCode) {
		return fhirClient.addObservation(patientId, loincCode, loincDisplayName, value, valueUnit, valueCode);
	}

	public String updateObservationValue(String observationId, double value) {
		return fhirClient.updateObservationValue(observationId, value);
	}

	public Measurement getObservation(String patientId, String loincCode) {
		return fhirClient.getObservation(patientId, loincCode);
	}


	public Patient updatePatient(Patient patient) {
		if(getPatient(patient.getPatientUuid()) != null){
			return savePatient(patient);
		}
		return null;
	}
	
	public void addBPM(String patientId, Double bpm) {
		addObservation(patientId, "8867-4", "Heart rate", bpm, "BPM", "BPM");
	}

	public void addDiastolicPressure(String patientId, Double diastolicPressrure) {
		addObservation(patientId, "8462-4", "Diastolic blood pressure", diastolicPressrure, "mmHg", "mmHg");
	}

	public void addSystolicPressure(String patientId, Double systolicPressrure) {
		addObservation(patientId, "8480-6", "Systolic blood pressure", systolicPressrure, "mmHg", "mmHg");
	}

	public void addMedicalNote(String patientId, String medicalNote) {
		addObservation(patientId, "34133-9", "Episode Note", 0, "Episode Note", medicalNote);
	}

	public Double getBPM(String patientId) {
		return getObservation(patientId, "8867-4").getValue();
	}

	public Double getDiastolicPressure(String patientId) {
		return getObservation(patientId, "8462-4").getValue();
	}

	public Double getSystolicPressure(String patientId) {
		return getObservation(patientId, "8480-6").getValue();
	}

	public String getMedicalNote(String patientId) {
		return getObservation(patientId, "34133-9").getValueCode();
	}


}

