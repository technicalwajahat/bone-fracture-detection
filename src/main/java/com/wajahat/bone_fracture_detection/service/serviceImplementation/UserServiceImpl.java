package com.wajahat.bone_fracture_detection.service.serviceImplementation;

import java.util.List;

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
    UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public Users saveUser(Users user) {

        String password = passwordEncoder.encode(user.getPassword());
        user.setPassword(password);

        Users newUser = userRepository.save(user);

        if (newUser.getRole().equals("1")) {
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

    @Override
    public List<Users> getAllUsers() {
        throw new UnsupportedOperationException("Unimplemented method 'getAllUsers'");
    }
}