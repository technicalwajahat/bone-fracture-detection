/**
 * Project      :   bone_fracture_detection
 * Developer    :   Wajahat Awan
 * Date         :   27/01/2024
 * Language     :   Java
 * Framework    :   Spring Boot
 */

package com.wajahat.bone_fracture_detection.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wajahat.bone_fracture_detection.entity.Users;

public interface UserRepository extends JpaRepository<Users, Long> {

    Optional<Users> findByUsername(String username);

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);
}