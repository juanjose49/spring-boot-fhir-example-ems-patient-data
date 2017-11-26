package com.fhirio.fhiremsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fhirio.fhiremsservice.domain.Note;
import com.fhirio.fhiremsservice.domain.Patient;
import com.fhirio.fhiremsservice.service.PatientService;

@RestController()
@RequestMapping("/api/patient")
@CrossOrigin(origins = "*")
public class PatientController {
	@Autowired
	private PatientService patientService;
	
	/**
	 * E.g. curl -X GET http://localhost:8080/api/patient/1
	 * 
	 * @param patientUuid
	 * @return
	 */
	@RequestMapping(value = "/{patientUuid}", method = RequestMethod.GET)
	public ResponseEntity<Patient> getPatient(@PathVariable Integer patientUuid) {
		Patient patient = patientService.getPatient(patientUuid);
		if(patient !=null){
			return new ResponseEntity<Patient>(patient, HttpStatus.OK);
		}else{
			return new ResponseEntity<Patient>(patient, HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * E.g. curl -H "Content-Type: application/json" -X PUT-d '{"patientUuid":"1","patientNotes":"urgent"}' http://localhost:8080/api/patient/1
	 *
	 * @param patient
	 * @return
	 */
	@RequestMapping(value = "", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Patient> updatePatient(@RequestBody Patient patient) {
		patient = patientService.updatePatient(patient);
		if(patient != null){
			return new ResponseEntity<Patient>(patient, HttpStatus.OK);
		}else{
			return new ResponseEntity<Patient>(patient, HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * New Org User (Created by Super User): E.g. curl -H "Content-Type: application/json" -X POST -d '{"patientUuid":"1e19bb7a-d990-4924-9fae-be84f19c53c1","medicalNote":"diarrhea", "systolicPressrure":"100", "diastolicPressrure":"80","bpm":"60"}' http://localhost:8080/api/patient
	 * @param note
	 * @return
	 */
	@RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Note> createNote(@RequestBody Note note) {
		if(note.getBpm() != null){
			patientService.addBPM(note.getPatientUuid(), note.getBpm());
			System.out.println(note.getBpm());
		}
		if(note.getDiastolicPressrure() != null){
			System.out.println(note.getDiastolicPressrure());
			patientService.addDiastolicPressure(note.getPatientUuid(), note.getDiastolicPressrure());
		}
		if(note.getSystolicPressrure() == null){
			System.out.println(note.getSystolicPressrure());
			patientService.addSystolicPressure(note.getPatientUuid(), note.getSystolicPressrure());
		}
		if(note.getMedicalNote() == null){
			System.out.println(note.getMedicalNote());
			patientService.addMedicalNote(note.getPatientUuid(), note.getMedicalNote());
		}

		if(note != null){
			return new ResponseEntity<Note>(note, HttpStatus.CREATED);
		}else{
			return new ResponseEntity<Note>(note, HttpStatus.CONFLICT);
		}
	}
}