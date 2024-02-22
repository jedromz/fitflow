package com.fitflow.api.mentorships.repository;

import com.fitflow.api.mentorships.model.Trainee;
import com.fitflow.api.mentorships.model.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TraineeRepository extends JpaRepository<Trainee, Long> {
    List<Trainee> findAllByTrainer(Trainer trainer);
}

