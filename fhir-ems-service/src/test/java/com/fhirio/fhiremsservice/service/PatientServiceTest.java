package com.fhirio.fhiremsservice.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fhirio.fhiremsservice.domain.Patient;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientServiceTest {
	@Autowired
	private PatientService patientService;
	
	@Before 
	public void setup(){
		Map<Integer, Patient> patientMap = new HashMap<>();
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
		this.patientService.setPatientMap(patientMap);
	}
	
	@Test
	public void testGetPatient_patient_is_available() {
		Patient patient = this.patientService.getPatient(3);
		assertThat(patient).isNotNull();
		assertThat(patient.getFirstName()).isEqualTo("Thomas");
	}
	
	@Test
	public void testGetPatient_patient_is_not_available() {
		Patient patient = this.patientService.getPatient(-1);
		assertThat(patient).isNull();
	}


}
