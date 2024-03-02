package com.fitflow.api.workouts.repository;

import com.fitflow.api.workouts.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepository extends JpaRepository<Exercise, Long>{
}
