package com.fitflow.api.workouts.controller;

import com.fitflow.api.workouts.model.WorkoutPlan;
import com.fitflow.api.workouts.service.WorkoutPlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/workoutplans")
@RequiredArgsConstructor
public class WorkoutPlanController {

    private final WorkoutPlanService workoutPlanService;

    @PostMapping
    public ResponseEntity<WorkoutPlan> addWorkoutPlan(@RequestBody CreateWorkoutPlanCommand command) {
        return ResponseEntity.ok(workoutPlanService.addWorkoutPlan(command));
    }
}
