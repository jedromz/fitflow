package com.fitflow.api.workouts.repository;

import com.fitflow.api.workouts.controller.WorkoutPlanResponse;
import com.fitflow.api.workouts.model.WorkoutPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WorkoutPlanRepository extends JpaRepository<WorkoutPlan, Long> {
    List<WorkoutPlanResponse> findAllByTrainerId(long trainerId);
    List<WorkoutPlanResponse> findAllByTraineeId(long traineeId);
    Optional<WorkoutPlanResponse> findById(long workoutPlanId, Class<WorkoutPlanResponse> clazz);
}
