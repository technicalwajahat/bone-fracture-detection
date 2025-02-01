package com.wajahat.bone_fracture_detection.service;

import java.util.List;
import java.util.Optional;

import com.wajahat.bone_fracture_detection.entity.Appointment;

public interface AppointmentService {

    List<Appointment> getAppointments();

    Appointment saveAppointment(Appointment appointment);

    Optional<Appointment> getAppointmentById(Long id);
}