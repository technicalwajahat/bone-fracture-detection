package com.wajahat.bone_fracture_detection.service;

import java.util.List;

import com.wajahat.bone_fracture_detection.entity.Users;

public interface UserService {

    Users saveUser(Users user);

    List<Users> getAllUsers();
}
