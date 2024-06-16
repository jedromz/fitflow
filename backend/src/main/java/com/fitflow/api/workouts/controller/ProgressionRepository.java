package com.fitflow.api.workouts.controller;

import com.fitflow.api.workouts.model.Progression;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgressionRepository extends JpaRepository<Progression, Long> {
}
