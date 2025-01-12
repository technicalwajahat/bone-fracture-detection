package com.wajahat.bone_fracture_detection.service;

import java.util.Optional;

import com.wajahat.bone_fracture_detection.entity.Role;

public interface RoleService {

    Optional<Role> getRoleById(Long id);
}