package com.wajahat.bone_fracture_detection.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
        for (GrantedAuthority authority : authentication.getAuthorities()) {
            String role = authority.getAuthority();
            if ("ROLE_DOCTOR".equals(role)) {
                response.sendRedirect("/doctor/");
                return;
            }
            if ("ROLE_PATIENT".equals(role)) {
                response.sendRedirect("/patient/");
                return;
            }
        }

        response.sendRedirect("/user/login");
    }
}
