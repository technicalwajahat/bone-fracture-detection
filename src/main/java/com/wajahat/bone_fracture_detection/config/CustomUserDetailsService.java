/**
 * Project      :   bone_fracture_detection
 * Developer    :   Wajahat Awan
 * Date         :   27/01/2024
 * Language     :   Java
 * Framework    :   Spring Boot
 */

package com.wajahat.bone_fracture_detection.config;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.wajahat.bone_fracture_detection.entity.Users;
import com.wajahat.bone_fracture_detection.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    private static final String ROLE_PREFIX = "ROLE_";

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Users> user = userRepository.findByUsername(username);

        CustomUserDetails userDetails = user.map(u -> new CustomUserDetails(
                u.getUsername(),
                u.getPassword(),
                authorities(u),
                u.getName()))
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        return userDetails;
    }

    private Collection<? extends GrantedAuthority> authorities(Users user) {
        String role = String.valueOf(user.getRole().getId());

        if (role.equals("1")) {
            role = ROLE_PREFIX + "DOCTOR";
        } else {
            role = ROLE_PREFIX + "PATIENT";
        }

        return Collections.singletonList(new SimpleGrantedAuthority(role));
    }
}
