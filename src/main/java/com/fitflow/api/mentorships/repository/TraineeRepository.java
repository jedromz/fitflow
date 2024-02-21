package com.fitflow.api.mentorships.repository;

import com.fitflow.api.mentorships.model.Trainee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TraineeRepository extends JpaRepository<Trainee, Long> {
}

