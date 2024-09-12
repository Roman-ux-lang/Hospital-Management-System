package com.demo.hospital.DAO.patient;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.demo.hospital.models.Patient;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class PatientDAOImp implements PatientDAO {

    @PersistenceContext 
    EntityManager entityManager;

    @Override
    public Patient getPatient(Long id){
        Patient patient = entityManager.find(Patient.class, id);
        return patient;
    }

    @Override
    public List<Patient> getPatients(){
        String query = "FROM Patient";
        return entityManager.createQuery(query).getResultList();
    }
}
