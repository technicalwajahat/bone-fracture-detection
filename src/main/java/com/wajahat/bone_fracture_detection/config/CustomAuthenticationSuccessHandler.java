package com.wajahat.bone_fracture_detection.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
        String role = authentication.getAuthorities().toString();

        System.out.println("Role: " + role);

        if (role.contains("ROLE_DOCTOR")) {
            response.sendRedirect("/doctor/dashboard");
        } else if (role.contains("ROLE_PATIENT")) {
            response.sendRedirect("/patient/dashboard");
        } else {
            response.sendRedirect("/user/login");
        }
    }
}