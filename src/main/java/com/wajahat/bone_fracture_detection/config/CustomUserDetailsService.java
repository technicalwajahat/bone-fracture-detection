package com.wajahat.bone_fracture_detection.config;

import java.util.Arrays;
import java.util.Collection;
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Users> user = userRepository.findByUsername(username);

        CustomUserDetails userDetails = user.map(u -> new CustomUserDetails(
                u.getUsername(),
                u.getPassword(),
                authorities(),
                u.getName()))
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        return userDetails;
    }

    public Collection<? extends GrantedAuthority> authorities() {
        return Arrays.asList(new SimpleGrantedAuthority("1"));
    }
}