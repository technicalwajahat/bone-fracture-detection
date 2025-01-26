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
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String doctorDashboard(Model model) {
        model.addAttribute("title", "Doctor Dashboard");
        model.addAttribute("role", "ROLE_DOCTOR");
        return "doctor/home";
    }

    @GetMapping("/profile")
    public String userPage(Principal principal, Model model) {

        Optional<Users> currentUser = userService.findByUsername(principal.getName());

        model.addAttribute("title", "Doctor Profile");
        model.addAttribute("name", currentUser.get().getName());
        model.addAttribute("email", currentUser.get().getEmail());
        model.addAttribute("username", currentUser.get().getUsername());
        model.addAttribute("role", currentUser.get().getRole().getRoleName());

        return "profile";
    }
}