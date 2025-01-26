package com.wajahat.bone_fracture_detection.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/doctor")
public class DoctorController {

    @GetMapping("/")
    public String doctorDashboard(Model model) {
        model.addAttribute("title", "Doctor Dashboard");
        model.addAttribute("role", "ROLE_DOCTOR");
        return "doctor/home";
    }
}