package com.demo.hospital.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.hospital.DAO.patient.PatientDAO;
import com.demo.hospital.models.MedicalRecord;
import com.demo.hospital.models.Patient;
import com.demo.hospital.service.MedicalRecordService;


@RestController
public class PatientController {

    @Autowired
    PatientDAO patientDAO;

    @Autowired
    MedicalRecordService medicalRecordService;

    // private final MedicalRecordService medicalRecordService;

    // public PatientController(MedicalRecordService medicalRecordService){
    //     this.medicalRecordService = medicalRecordService;
    // } 
    
       
    @RequestMapping(value = "api/patient/{id}", method = RequestMethod.GET)
    public Patient getPatient(@PathVariable Long id){
        return patientDAO.getPatient(id);
    }    

    @RequestMapping(value = "api/patients", method = RequestMethod.GET  )
    public List<Patient> getPatients(){
        return patientDAO.getPatients();
    }

    @RequestMapping(value = "/patient/{patientId}", method = RequestMethod.GET)
    public ResponseEntity<List<MedicalRecord>> getMedicalRecordByPatientId(@PathVariable Long patientId){
        List<MedicalRecord> records = medicalRecordService.getMedicalRecordsByPatientId(patientId);
        return ResponseEntity.ok(records);
    }
    
}
