package com.wajahat.bone_fracture_detection.service.serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wajahat.bone_fracture_detection.entity.Feedback;
import com.wajahat.bone_fracture_detection.repository.FeedbackRepository;
import com.wajahat.bone_fracture_detection.service.FeedbackService;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Override
    public void addFeedback(Feedback feedback) {
        feedbackRepository.save(feedback);
    }

    @Override
    public void deleteFeedback(Long id) {
        feedbackRepository.deleteById(id);
    }

    @Override
    public List<Feedback> getFeedbacks() {
        return feedbackRepository.findAll();
    }

    @Override
    public Feedback getFeedback(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'getFeedback'");
    }

}
