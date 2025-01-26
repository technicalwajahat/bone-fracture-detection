/**
 * Project      :   bone_fracture_detection
 * Developer    :   Wajahat Awan
 * Date         :   27/01/2024
 * Language     :   Java
 * Framework    :   Spring Boot
 */

package com.wajahat.bone_fracture_detection.controller;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wajahat.bone_fracture_detection.entity.Users;
import com.wajahat.bone_fracture_detection.service.UserService;

@Controller
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String patientDashboard(Model model) {
        model.addAttribute("title", "Patient Dashboard");
        model.addAttribute("role", "ROLE_PATIENT");
        return "patient/home";
    }

    @GetMapping("/profile")
    public String userPage(Principal principal, Model model) {

        Optional<Users> currentUser = userService.findByUsername(principal.getName());

        model.addAttribute("title", "Pateint Profile");
        model.addAttribute("name", currentUser.get().getName());
        model.addAttribute("email", currentUser.get().getEmail());
        model.addAttribute("username", currentUser.get().getUsername());
        model.addAttribute("role", currentUser.get().getRole().getRoleName());

        return "profile";
    }
}