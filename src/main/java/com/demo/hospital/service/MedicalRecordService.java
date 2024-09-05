package com.demo.hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.hospital.models.MedicalRecord;
import com.demo.hospital.repository.MedicalRecordRepository;

@Service
public class MedicalRecordService {

    // private final MedicalRecordRepository medicalRecordRepository;

    // @Autowired
    // public MedicalRecordService(MedicalRecordRepository medicalRecordRepository){
    //     this.medicalRecordRepository = medicalRecordRepository;
    // }

    @Autowired
    MedicalRecordRepository medicalRecordRepository;

    public List<MedicalRecord> getMedicalRecordsByPatientId(Long patientId){
        return medicalRecordRepository.findMedicalRecordsByPatientId(patientId);
    }

}
