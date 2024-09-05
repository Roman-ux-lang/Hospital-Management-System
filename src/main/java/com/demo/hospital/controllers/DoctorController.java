package com.demo.hospital.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.hospital.DAO.doctor.DoctorDAO;
import com.demo.hospital.models.Doctor;

@RestController
public class DoctorController {

    @Autowired
    DoctorDAO doctorDAO;

    @RequestMapping(value = "api/doctor/{id}", method = RequestMethod.GET)
    public Doctor getDoctor(@PathVariable Long id){
        return doctorDAO.getDoctor(id);
    }

    @RequestMapping(value = "api/doctors", method = RequestMethod.GET )
    public List<Doctor> getDoctors(){
        return doctorDAO.getDoctors();
    }

}
