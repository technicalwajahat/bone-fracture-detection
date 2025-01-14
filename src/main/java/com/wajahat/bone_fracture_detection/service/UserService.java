package com.wajahat.bone_fracture_detection.service;

import com.wajahat.bone_fracture_detection.entity.Users;

public interface UserService {

    boolean isUsernameTaken(String username);

    boolean isEmailTaken(String email);

    Users saveUser(Users user);
}
