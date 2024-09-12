package com.demo.hospital.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.hospital.DAO.patient.PatientDAO;
import com.demo.hospital.models.Patient;

@RestController
@RequestMapping("/api/")
public class PatientController {

    @Autowired
    PatientDAO patientDAO;

    @GetMapping("patient/{id}")
    public ResponseEntity<Patient> getPatient(@PathVariable Long id){
        Patient patient = patientDAO.getPatient(id); 
        return ResponseEntity.ok(patient);
    }    
  
    @GetMapping("patients")
    public ResponseEntity<List<Patient>> getPatients(){
        List<Patient> patients = patientDAO.getPatients();
        return ResponseEntity.ok(patients);
    }
}
