package com.demo.hospital.DAO.patient;

import java.util.List;

import com.demo.hospital.models.Patient;

public interface PatientDAO {
    
    public Patient getPatient(Long id);
    public List<Patient> getPatients();
}
