package com.wajahat.bone_fracture_detection.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wajahat.bone_fracture_detection.entity.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
