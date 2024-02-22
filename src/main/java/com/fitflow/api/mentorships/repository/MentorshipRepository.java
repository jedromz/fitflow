package com.fitflow.api.mentorships.repository;

import com.fitflow.api.mentorships.controller.MentorshipResponse;
import com.fitflow.api.mentorships.model.Mentorship;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MentorshipRepository extends JpaRepository<Mentorship, Long> {
    List<MentorshipResponse> findAllBy();
    List<Mentorship> findAllByTrainerId(Long trainerId);
}
