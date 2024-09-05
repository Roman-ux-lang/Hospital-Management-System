package com.demo.hospital.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "medical_records")
public class MedicalRecord {

    @Id
    @Column(name = "record_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recordId;  // Field name should follow Java naming conventions

    @OneToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "patient_id")
    private Patient patient;

    @Column(name = "doctor_id")
    private Long doctorId;  // Field name should follow Java naming conventions

    @Column(name = "visit_date")  // Correct the spelling to "visit_date"
    private String visitDate;  // Consider using LocalDate for visit date

    @Column(name = "diagnosis")
    private String diagnosis;

    @Column(name = "prescribed_medication")
    private String prescribedMedication;  // Field name should follow Java naming conventions

    @Column(name = "notes")
    private String notes;
}
