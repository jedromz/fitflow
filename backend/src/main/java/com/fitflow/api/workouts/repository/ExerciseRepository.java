package com.fitflow.api.workouts.repository;

import com.fitflow.api.workouts.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExerciseRepository extends JpaRepository<Exercise, Long>{

    Optional<Exercise> findByName(String name);
}
