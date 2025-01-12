package com.wajahat.bone_fracture_detection.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wajahat.bone_fracture_detection.entity.Users;

public interface UserRepository extends JpaRepository<Users, Long> {

    Users findByUsername(String username);
}