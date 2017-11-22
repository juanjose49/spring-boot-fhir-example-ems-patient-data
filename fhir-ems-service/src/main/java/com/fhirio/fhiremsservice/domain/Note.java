package com.fhirio.fhiremsservice.domain;

/**
 * Created by swengineer on 11/20/17.
 */
public class Note {

    String patientUuid;
    String medicalNote;
    Double systolicPressrure;
    Double diastolicPressrure;
    Double bpm;

    public Note() {
    }

    public Note(String patientUuid, String medicalNote, Double systolicPressrure, Double diastolicPressrure, Double bpm) {
        this.patientUuid = patientUuid;
        this.medicalNote = medicalNote;
        this.systolicPressrure = systolicPressrure;
        this.diastolicPressrure = diastolicPressrure;
        this.bpm = bpm;
    }

    public String getPatientUuid() {
        return patientUuid;
    }

    public void setPatientUuid(String patientUuid) {
        this.patientUuid = patientUuid;
    }

    public String getMedicalNote() {
        return medicalNote;
    }

    public void setMedicalNote(String medicalNote) {
        this.medicalNote = medicalNote;
    }

    public Double getSystolicPressrure() {
        return systolicPressrure;
    }

    public void setSystolicPressrure(Double systolicPressrure) {
        this.systolicPressrure = systolicPressrure;
    }

    public Double getDiastolicPressrure() {
        return diastolicPressrure;
    }

    public void setDiastolicPressrure(Double diastolicPressrure) {
        this.diastolicPressrure = diastolicPressrure;
    }

    public Double getBpm() {
        return bpm;
    }

    public void setBpm(Double bpm) {
        this.bpm = bpm;
    }
}
