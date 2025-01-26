/**
 * Project      :   bone_fracture_detection
 * Developer    :   Wajahat Awan
 * Date         :   27/01/2024
 * Language     :   Java
 * Framework    :   Spring Boot
 */

package com.wajahat.bone_fracture_detection.service.serviceImplementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.wajahat.bone_fracture_detection.entity.Doctor;
import com.wajahat.bone_fracture_detection.entity.Patient;
import com.wajahat.bone_fracture_detection.entity.Users;
import com.wajahat.bone_fracture_detection.repository.DoctorRepository;
import com.wajahat.bone_fracture_detection.repository.PatientRepository;
import com.wajahat.bone_fracture_detection.repository.UserRepository;
import com.wajahat.bone_fracture_detection.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    private BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public boolean isEmailTaken(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public boolean isUsernameTaken(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public Optional<Users> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Users saveUser(Users user) {

        /**
         * Password Encoder
         */
        String password = this.passwordEncoder.encode(user.getPassword());
        user.setPassword(password);

        /**
         * Save User to DB
         */
        Users newUser = userRepository.save(user);
        String userRole = String.valueOf(newUser.getRole().getId());

        /**
         * Save Patient or Doctor to thier Table
         */
        if (userRole.equals("1")) {
            Doctor doctor = new Doctor();
            doctor.setUser(newUser);
            doctorRepository.save(doctor);
        } else {
            Patient patient = new Patient();
            patient.setUser(newUser);
            patientRepository.save(patient);
        }

        return newUser;
    }
}