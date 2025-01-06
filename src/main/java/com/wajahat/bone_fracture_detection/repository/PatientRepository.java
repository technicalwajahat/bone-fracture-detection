package com.wajahat.bone_fracture_detection.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wajahat.bone_fracture_detection.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
