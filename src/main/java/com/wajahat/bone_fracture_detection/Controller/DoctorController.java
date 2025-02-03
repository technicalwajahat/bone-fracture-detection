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
import com.wajahat.bone_fracture_detection.entity.Feedback;
import com.wajahat.bone_fracture_detection.entity.Users;
import com.wajahat.bone_fracture_detection.service.AppointmentService;
import com.wajahat.bone_fracture_detection.service.FeedbackService;
import com.wajahat.bone_fracture_detection.service.UserService;

@Controller
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private UserService userService;

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private FeedbackService feedbackService;

    @ModelAttribute
    public void addCommonAttributes(Model model) {
        model.addAttribute("role", "ROLE_DOCTOR");
    }

    @GetMapping("/")
    public String doctorDashboard(Model model) {
        model.addAttribute("title", "Doctor Dashboard");
        return "doctor/home";
    }

    @GetMapping("/profile")
    public String profile(Principal principal, Model model) {

        Optional<Users> currentUser = userService.findByUsername(principal.getName());

        model.addAttribute("title", "Doctor Profile");
        model.addAttribute("name", currentUser.get().getName());
        model.addAttribute("email", currentUser.get().getEmail());
        model.addAttribute("username", currentUser.get().getUsername());
        model.addAttribute("role", currentUser.get().getRole().getRoleName());

        return "profile";
    }

    @GetMapping("/appointments")
    public String appointment(Model model) {

        List<Appointment> appointments = appointmentService.getAppointments();

        model.addAttribute("title", "Appointments");
        model.addAttribute("appointments", appointments);

        return "appointment/appointments";
    }

    @GetMapping("/feedbacks")
    public String feedback(Model model) {

        List<Feedback> feedbacks = feedbackService.getFeedbacks();

        model.addAttribute("title", "Feedbacks");
        model.addAttribute("feedbacks", feedbacks);

        return "feedback/feedbacks";
    }
}