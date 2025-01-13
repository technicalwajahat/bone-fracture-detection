package com.wajahat.bone_fracture_detection.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wajahat.bone_fracture_detection.entity.Users;
import com.wajahat.bone_fracture_detection.service.UserService;

@RestController
@RequestMapping("/user")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/saveUser")
    public String createUser(@ModelAttribute Users user) {
        userService.saveUser(user);

        return "redirect:auth/register";
    }
}