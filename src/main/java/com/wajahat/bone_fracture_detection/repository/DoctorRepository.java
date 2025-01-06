package com.wajahat.bone_fracture_detection.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wajahat.bone_fracture_detection.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
