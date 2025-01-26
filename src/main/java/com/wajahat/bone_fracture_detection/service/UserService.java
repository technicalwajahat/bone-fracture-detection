package com.wajahat.bone_fracture_detection.service;

import java.util.Optional;

import com.wajahat.bone_fracture_detection.entity.Users;

public interface UserService {

    boolean isUsernameTaken(String username);

    boolean isEmailTaken(String email);

    Users saveUser(Users user);

    Optional<Users> findByUsername(String username);
}
