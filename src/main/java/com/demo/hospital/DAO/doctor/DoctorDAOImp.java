package com.demo.hospital.DAO.doctor;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.demo.hospital.models.Doctor;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
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

    @Override
    public Doctor getDoctorByCredentials(Doctor doctor){
        String query = "FROM Doctor WHERE email = :email";
        List<Doctor> list = entityManager.createQuery(query)
        .setParameter("email", doctor.getEmail())
        .getResultList();

        if(list.isEmpty()){return null;}

        String passwordHashed = list.get(0).getPassword();
        
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        
        if(argon2.verify(passwordHashed, doctor.getPassword())){
            return list.get(0);
        }
        return null;
    }

    @Override
    public void createDoctor(Doctor doctor){
        entityManager.merge(doctor);
    }
}
