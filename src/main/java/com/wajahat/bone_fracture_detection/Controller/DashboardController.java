package com.wajahat.bone_fracture_detection.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/login")
    public String login() {
        return "auth/login";
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/doctor/feedback")
    public String viewFeedback() {
        return "view_feedback";
    }

    @GetMapping("/patient/feedback/add")
    public String addFeedback() {
        return "add_feedback";
    }

    @GetMapping("/patient/doctor")
    public String viewDoctor() {
        return "view_doctors";
    }

    @GetMapping("/doctor/patient")
    public String viewPatient() {
        return "view_patient";
    }

    @GetMapping("/patient/appointment/add")
    public String addAppointment() {
        return "add_appointment";
    }

    @GetMapping("/patient/appointment/edit")
    public String editAppointment() {
        return "edit_appointment";
    }

    @GetMapping("/patient/appointment")
    public String appointment() {
        return "edit_appointment";
    }
}