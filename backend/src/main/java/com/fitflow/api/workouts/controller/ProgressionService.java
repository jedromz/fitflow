package com.fitflow.api.workouts.controller;

import com.fitflow.api.mentorships.repository.TraineeRepository;
import com.fitflow.api.workouts.model.Progression;
import com.fitflow.api.workouts.repository.ExerciseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProgressionService {
    private final ProgressionRepository progressionRepository;
    private final ExerciseRepository exerciseRepository;
    private final TraineeRepository traineeRepository;

    public void addProgression(Long traineeId, ProgressionRequest command) {
        final var trainee = traineeRepository.findById(traineeId).orElseThrow();
        final var progressions = command.getProgressions();
        progressions.forEach((exerciseName, exerciseProgression) -> {
            final var exercise = exerciseRepository.findByName(exerciseName).orElseThrow();
            final var progression = new Progression();
            progression.setTrainee(trainee);
            progression.setExercise(exercise);
            progression.setSets(exerciseProgression.getSets());
            progression.setReps(exerciseProgression.getReps());
            progression.setWeight(exerciseProgression.getWeight());
            progressionRepository.save(progression);
        });
    }
}
