/**
 * Project      :   bone_fracture_detection
 * Developer    :   Wajahat Awan
 * Date         :   27/01/2024
 * Language     :   Java
 * Framework    :   Spring Boot
 */

package com.wajahat.bone_fracture_detection.service;

import java.util.Optional;

import com.wajahat.bone_fracture_detection.entity.Role;

public interface RoleService {

    Optional<Role> getRoleById(Long id);
}