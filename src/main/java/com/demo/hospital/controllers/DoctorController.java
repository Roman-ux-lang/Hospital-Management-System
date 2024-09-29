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

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    DoctorDAO doctorDAO;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Doctor doctor){
        Doctor loggedInDoctor = doctorDAO.getDoctorByCredentials(doctor);

        if(loggedInDoctor != null){
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

    @PostMapping("/create")
    public void createDoctor(@RequestBody Doctor doctor){
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1,1024,1, doctor.getPassword());
        doctor.setPassword(hash);
        doctorDAO.createDoctor(doctor);
    }
}
