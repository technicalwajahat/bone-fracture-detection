package com.wajahat.bone_fracture_detection.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/doctor/dashboard")
    public String doctorDashboard() {
        return "dashboard/patient";
    }

    @GetMapping("/patient/dashboard")
    public String patientDashboard() {
        return "dashboard/patient";
    }

}