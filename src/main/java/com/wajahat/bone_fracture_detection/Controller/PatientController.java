package com.wajahat.bone_fracture_detection.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/patient")
public class PatientController {

    @GetMapping("/")
    public String patientDashboard(Model model) {
        model.addAttribute("title", "Patient Dashboard");
        model.addAttribute("role", "ROLE_PATIENT");
        return "patient/home";
    }
}