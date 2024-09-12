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

import com.demo.hospital.DAO.doctor.DoctorDAO;
import com.demo.hospital.models.Doctor;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    DoctorDAO doctorDAO;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Doctor doctor){
        boolean loggedInDoctor = doctorDAO.getDoctorByCredentials(doctor);

        if(loggedInDoctor != false){
            return  ResponseEntity.ok("Welcome");
        }
        return ResponseEntity.ok("Fail");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctor(@PathVariable Long id){
        return ResponseEntity.ok(doctorDAO.getDoctor(id));
    }

    @GetMapping
    public ResponseEntity<List<Doctor>> getDoctors(){
        return ResponseEntity.ok(doctorDAO.getDoctors());
    }
}
