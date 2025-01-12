package com.wajahat.bone_fracture_detection.service.serviceImplementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.wajahat.bone_fracture_detection.entity.Role;
import com.wajahat.bone_fracture_detection.repository.RoleRepository;
import com.wajahat.bone_fracture_detection.service.RoleService;

public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public Optional<Role> getRoleById(Long id) {
        return roleRepository.findById(id);
    }

}
