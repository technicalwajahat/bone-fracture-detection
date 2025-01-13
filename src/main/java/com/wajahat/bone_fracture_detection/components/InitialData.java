package com.wajahat.bone_fracture_detection.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.wajahat.bone_fracture_detection.entity.Role;
import com.wajahat.bone_fracture_detection.repository.RoleRepository;

public class InitialData implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        roleRepository.save(new Role(1L, "doctor"));
        roleRepository.save(new Role(2L, "patient"));

        System.out.println("DATA Added Role Based");
    }
}