package com.wajahat.bone_fracture_detection.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.wajahat.bone_fracture_detection.entity.Users;
import com.wajahat.bone_fracture_detection.service.UserService;

import jakarta.validation.Valid;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new Users());
        model.addAttribute("title", "Register");
        return "auth/register";
    }

    @GetMapping("/user/login")
    public String showLoginForm(Model model) {
        model.addAttribute("title", "Login");
        return "auth/login";
    }


    @PostMapping("/user/saveUser")
    public String createUser(@ModelAttribute("user") @Valid Users user, BindingResult bindingResult, Model model) {

        // Check if the username is already taken
        if (userService.isUsernameTaken(user.getUsername())) {
            bindingResult.rejectValue("username", "error.user", "*Username already exists");
        }

        // Check if the email is already taken
        if (userService.isEmailTaken(user.getEmail())) {
            bindingResult.rejectValue("email", "error.user", "*Email already exists");
        }

        if (bindingResult.hasErrors()) {
            model.addAttribute("user", user);
            return "auth/register";
        }

        // Save the user and redirect to the login page
        userService.saveUser(user);
        return "redirect:/user/login";
    }
}
