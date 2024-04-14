package com.fitflow.api.workouts.controller;

import com.fitflow.api.workouts.model.Exercise;
import com.fitflow.api.workouts.repository.ExerciseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ExerciseController {

    private final ExerciseRepository exerciseRepository;

    public ExerciseController(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    @GetMapping("/exercises")
    public List<Exercise> getExercises() {
        return exerciseRepository.findAll();
    }

}
