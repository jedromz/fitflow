package com.fitflow.api.mentorships.repository;

import com.fitflow.api.mentorships.controller.TrainerResponse;
import com.fitflow.api.mentorships.model.Trainee;
import com.fitflow.api.mentorships.model.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TrainerRepository extends JpaRepository<Trainer, Long> {
    Optional<TrainerResponse> findById(long trainerId, Class<TrainerResponse> clazz);
    Optional<Trainer> findByUser_Id(Long id);
}
