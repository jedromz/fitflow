package com.fitflow.api.workouts.controller;

import com.fitflow.api.workouts.model.Exercise;
import com.fitflow.api.workouts.repository.ExerciseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RequiredArgsConstructor
@RestController
public class ExerciseController {

    private final ExerciseRepository exerciseRepository;
    @GetMapping("/exercises")
    public List<Exercise> getExercises() {
        return exerciseRepository.findAll();
    }

}
