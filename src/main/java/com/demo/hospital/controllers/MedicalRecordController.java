package com.demo.hospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.hospital.models.MedicalRecord;
import com.demo.hospital.service.MedicalRecordService;

@RestController
@RequestMapping("/api/medical-records")
public class MedicalRecordController {
    
    @Autowired
    MedicalRecordService medicalRecordService;

    // private final MedicalRecordService medicalRecordService;

    // public PatientController(MedicalRecordService medicalRecordService){
    //     this.medicalRecordService = medicalRecordService;
    // } 

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<MedicalRecord> getMedicalRecordsByPatientId(@PathVariable Long patientId){
        MedicalRecord records = medicalRecordService.getMedicalRecordsByPatientId(patientId);
        return ResponseEntity.ok(records);
    }

}
