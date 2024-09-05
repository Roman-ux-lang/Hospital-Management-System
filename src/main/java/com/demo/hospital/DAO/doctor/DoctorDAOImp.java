package com.demo.hospital.DAO.doctor;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.demo.hospital.models.Doctor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class DoctorDAOImp implements DoctorDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Doctor getDoctor(Long id){
        Doctor doctor = entityManager.find(Doctor.class, id);
        return doctor;
    }

    @Override
    public List<Doctor> getDoctors(){
        String query = "FROM Doctor";
        return entityManager.createQuery(query).getResultList();

    }

}
