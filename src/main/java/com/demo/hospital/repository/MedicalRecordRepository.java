package com.demo.hospital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.demo.hospital.models.MedicalRecord;

public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Long> {

    @Query("SELECT mr FROM MedicalRecord mr INNER JOIN mr.patient p WHERE p.patientId = :patientId")
    List<MedicalRecord> findMedicalRecordsByPatientId(@Param("patientId") Long patientId);
    

}
