/**
 * Project      :   bone_fracture_detection
 * Developer    :   Wajahat Awan
 * Date         :   27/01/2024
 * Language     :   Java
 * Framework    :   Spring Boot
 */

package com.wajahat.bone_fracture_detection.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wajahat.bone_fracture_detection.entity.Appointment;
import com.wajahat.bone_fracture_detection.entity.Doctor;
import com.wajahat.bone_fracture_detection.entity.Users;
import com.wajahat.bone_fracture_detection.service.AppointmentService;
import com.wajahat.bone_fracture_detection.service.UserService;

@Controller
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private UserService userService;

    @Autowired
    private AppointmentService appointmentService;

    @ModelAttribute
    public void addCommonAttributes(Model model) {
        model.addAttribute("role", "ROLE_PATIENT");
    }

    @GetMapping("/")
    public String patientDashboard(Model model) {
        model.addAttribute("title", "Patient Dashboard");
        return "patient/home";
    }

    @GetMapping("/profile")
    public String profile(Principal principal, Model model) {

        Optional<Users> currentUser = userService.findByUsername(principal.getName());

        model.addAttribute("title", "Pateint Profile");
        model.addAttribute("name", currentUser.get().getName());
        model.addAttribute("email", currentUser.get().getEmail());
        model.addAttribute("username", currentUser.get().getUsername());
        model.addAttribute("role", currentUser.get().getRole().getRoleName());

        return "/profile";
    }

    @GetMapping("/doctors")
    public String doctors(Model model) {

        List<Doctor> doctors = userService.getDoctors();

        model.addAttribute("title", "Doctors");
        model.addAttribute("doctors", doctors);

        return "patient/doctor";
    }

    @GetMapping("/appointments")
    public String appointment(Model model) {

        List<Appointment> appointments = appointmentService.getAppointments();

        model.addAttribute("title", "Appointments");
        model.addAttribute("appointments", appointments);

        return "appointment/appointments";
    }
}