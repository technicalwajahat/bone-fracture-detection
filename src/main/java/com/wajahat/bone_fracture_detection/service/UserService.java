/**
 * Project      :   bone_fracture_detection
 * Developer    :   Wajahat Awan
 * Date         :   27/01/2024
 * Language     :   Java
 * Framework    :   Spring Boot
 */

package com.wajahat.bone_fracture_detection.service;

import java.util.List;
import java.util.Optional;

import com.wajahat.bone_fracture_detection.entity.Doctor;
import com.wajahat.bone_fracture_detection.entity.Users;

public interface UserService {

    boolean isUsernameTaken(String username);

    boolean isEmailTaken(String email);

    Users saveUser(Users user);

    Optional<Users> findByUsername(String username);

    List<Doctor> getDoctors();
}
