package com.wajahat.bone_fracture_detection.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.wajahat.bone_fracture_detection.entity.Role;
import com.wajahat.bone_fracture_detection.repository.RoleRepository;

@Component
public class InitialData implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        try {
            addRoleIfNotExists("doctor");
            addRoleIfNotExists("patient");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error occurred while adding initial data: " + e.getMessage());
        }
    }

    private void addRoleIfNotExists(String roleName) {
        if (roleRepository.findByRoleName(roleName) == null) {
            roleRepository.save(new Role(null, roleName));
        }
    }
}