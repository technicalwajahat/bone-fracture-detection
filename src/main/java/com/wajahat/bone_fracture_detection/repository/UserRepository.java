package com.wajahat.bone_fracture_detection.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wajahat.bone_fracture_detection.entity.Users;

public interface UserRepository extends JpaRepository<Users, Long> {

    Optional<Users> findByUsername(String username);

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);
}