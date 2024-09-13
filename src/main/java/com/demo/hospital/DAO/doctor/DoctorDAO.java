package com.demo.hospital.DAO.doctor;

import java.util.List;

import com.demo.hospital.models.Doctor;


public interface DoctorDAO {

    public Doctor getDoctor(Long id);
    public List<Doctor> getDoctors();
    public boolean getDoctorByCredentials(Doctor doctor);
    public void createDoctor(Doctor doctor);
}
