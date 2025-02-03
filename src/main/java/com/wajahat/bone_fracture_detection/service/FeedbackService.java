package com.wajahat.bone_fracture_detection.service;

import java.util.List;

import com.wajahat.bone_fracture_detection.entity.Feedback;

public interface FeedbackService {
    public void addFeedback(Feedback feedback);

    public void deleteFeedback(Long id);

    public List<Feedback> getFeedbacks();

    public Feedback getFeedback(Long id);
}
