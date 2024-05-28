package com.fitflow.api.workouts.controller;

import com.fitflow.api.workouts.model.WorkoutPlan;
import com.fitflow.api.workouts.service.WorkoutPlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class WorkoutPlanController {

    private final WorkoutPlanService workoutPlanService;

    @PostMapping("/workoutplans")
    public ResponseEntity<WorkoutPlan> addWorkoutPlan(@RequestBody CreateWorkoutPlanCommand command) {
        return ResponseEntity.ok(workoutPlanService.addWorkoutPlan(command));
    }

    @GetMapping("/trainers/{trainerId}/workoutplans")
    public List<WorkoutPlanResponse> getWorkoutPlans(@PathVariable long trainerId) {
        return workoutPlanService.findTrainersWorkoutPlans(trainerId);
    }

    @GetMapping("/trainees/{traineeId}/workoutplans")
    public List<WorkoutPlanResponse> getTraineesWorkoutPlans(@PathVariable long traineeId) {
        return workoutPlanService.findTraineesWorkoutPlans(traineeId);
    }
}
