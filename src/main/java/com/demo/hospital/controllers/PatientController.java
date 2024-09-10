package com.demo.hospital.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.hospital.DAO.patient.PatientDAO;
import com.demo.hospital.models.Patient;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

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

    @PostMapping("register/patient")
    public void createPatient(@RequestBody Patient patient){
        Argon2  argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1024, 1, patient.getPassword());
        patient.setPassword(hash);
        patientDAO.createPatient(patient);
    }
   
}
