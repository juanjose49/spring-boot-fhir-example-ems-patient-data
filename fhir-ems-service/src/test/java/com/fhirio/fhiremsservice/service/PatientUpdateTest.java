package com.fhirio.fhiremsservice.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fhirio.fhiremsservice.domain.Condition;
import com.fhirio.fhiremsservice.domain.Medication;
import com.fhirio.fhiremsservice.domain.Patient;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientUpdateTest {
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

    //162209 Jon Snow
    //1e19bb7a-d990-4924-9fae-be84f19c53c1 Carlos Barton

    @Test
    public void testSimpleRead() {
        String patientName = this.patientService.getNameByPatientID("1e19bb7a-d990-4924-9fae-be84f19c53c1");
        assertThat(patientName).isNotNull();
        System.out.println(patientName);
        assertEquals("Carlos Barton", patientName);
    }

    @Test
    public void testgetIDByPatientName() {
//        List<String> patientList = this.patientService.getIDByPatientName("Barton");
        List<String> patientList = this.patientService.getIDByPatientFullName("Carlos", "Barton");
        assertThat(patientList).isNotNull();
        System.out.println(patientList.size());
        for (String p : patientList) {
            System.out.println(this.patientService.getNameByPatientID(p) + "#" + p);
        }
    }

    @Test
    public void testgetPatientMedications() {
        List<Medication> medList = this.patientService.getPatientMedications("162209");
        assertThat(medList).isNotNull();
        System.out.println(medList.size());
        for (Medication m : medList) {
            System.out.println(m.getName() + "#" + m.getConditionName() + "#" + m.getDescription());
        }
    }

    @Test
    public void testgetPatientConditions() {
        List<Condition> condList = this.patientService.getPatientConditions("162209");
        assertThat(condList).isNotNull();
        System.out.println(condList.size());
        for (Condition c : condList) {
            System.out.println(c.getName() + "#" + c.getClinicalStatus() + "#" + c.getAssertedDate() + "#" + c.getOnsetDateTime());
        }
    }

    @Test
    public void testaddPatient() {
        String patientID = this.patientService.addPatient("Jon", "Snow");
        assertThat(patientID).isNotNull();
        System.out.println("add patient : " + patientID);
    }

//    @Test
//    public void testaddObservation() {
//        String observationID = this.patientService.addObservation("162209", "85354-9", "blood pressure", 107, "mmHg", "mm[Hg]");
//        assertThat(observationID).isNotNull();
//        System.out.println("add observation : " + observationID);
//    }

//    @Test
//    public void testgetObservation() {
//        Measurement measurement = this.patientService.getObservation("162209", "85354-9");
//        assertThat(measurement).isNotNull();
//        System.out.println("get observation : " + measurement.getName() + measurement.getValue() + measurement.getValueUnit());
//    }


    @Test
    public void testaddObservation() {
        this.patientService.addBPM("1e19bb7a-d990-4924-9fae-be84f19c53c1", 60.0);
        Double bmp = this.patientService.getBPM("1e19bb7a-d990-4924-9fae-be84f19c53c1");
        assertThat(bmp).isNotNull();
        System.out.println("get bmp : " + bmp);
    }
}
