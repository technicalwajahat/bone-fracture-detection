package com.wajahat.bone_fracture_detection.service.serviceImplementation;

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
        String userRole = String.valueOf(newUser.getRole());

        /**
         * Save Patient or Doctor to DB
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