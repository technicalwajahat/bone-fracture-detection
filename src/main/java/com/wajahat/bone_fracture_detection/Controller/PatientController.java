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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wajahat.bone_fracture_detection.entity.Appointment;
import com.wajahat.bone_fracture_detection.entity.Doctor;
import com.wajahat.bone_fracture_detection.entity.Feedback;
import com.wajahat.bone_fracture_detection.entity.Users;
import com.wajahat.bone_fracture_detection.service.AppointmentService;
import com.wajahat.bone_fracture_detection.service.FeedbackService;
import com.wajahat.bone_fracture_detection.service.UserService;

@Controller
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private UserService userService;

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private FeedbackService feedbackService;

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

    @GetMapping("/appointments/create")
    public String addAppointment(Principal principal, Model model) {

        Optional<Users> currentUser = userService.findByUsername(principal.getName());
        List<Doctor> doctors = userService.getDoctors();

        model.addAttribute("patientName", currentUser.get().getName());
        model.addAttribute("doctors", doctors);
        model.addAttribute("title", "Book Appointment");

        return "appointment/add_appointment";
    }

    @PostMapping("/save-appointment")
    public String bookAppointment(@ModelAttribute Appointment appointment) {
        appointmentService.saveAppointment(appointment);
        return "redirect:/patient/appointments";
    }

    @GetMapping("/appointments/{id}")
    public String deleteAppointment(@PathVariable("id") Long id) {
        appointmentService.deleteAppointment(id);
        return "redirect:/patient/appointments";
    }

    @GetMapping("/feedbacks")
    public String feedback(Model model) {

        List<Feedback> feedbacks = feedbackService.getFeedbacks();

        model.addAttribute("title", "Feedbacks");
        model.addAttribute("feedbacks", feedbacks);

        return "feedback/feedbacks";
    }

    @GetMapping("/feedbacks/create")
    public String addFeedback(Principal principal, Model model) {

        List<Doctor> doctors = userService.getDoctors();

        model.addAttribute("doctors", doctors);
        model.addAttribute("title", "Add Feedback");

        return "feedback/add_feedback";
    }

    @PostMapping("/save-feedback")
    public String bookFeedback(@ModelAttribute Feedback feedback) {
        feedbackService.addFeedback(feedback);
        return "redirect:/patient/feedbacks";
    }

    @GetMapping("/feedbacks/{id}")
    public String deleteFeedback(@PathVariable("id") Long id) {
        feedbackService.deleteFeedback(id);
        return "redirect:/patient/feedbacks";
    }
}