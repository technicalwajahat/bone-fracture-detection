package com.wajahat.bone_fracture_detection.service;

import java.util.List;

import com.wajahat.bone_fracture_detection.entity.Feedback;

public interface FeedbackService {
    void addFeedback(Feedback feedback);

    void deleteFeedback(Long id);

    List<Feedback> getFeedbacks();

    Feedback getFeedback(Long id);

    List<Feedback> getFeedbacksByDoctorId(Long doctorId);
}
