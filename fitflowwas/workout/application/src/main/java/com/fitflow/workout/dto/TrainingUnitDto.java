package com.fitflow.workout.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

@JsonDeserialize(as = TrainingUnitDto.DeserializationImpl.class)
public interface TrainingUnitDto {
    String getName();

    List<WorkoutExerciseDto> getWorkoutExercises();

    class DeserializationImpl implements TrainingUnitDto {

        private final String name;
        private final List<WorkoutExerciseDto> workoutExercises;

        DeserializationImpl(String name, List<WorkoutExerciseDto> workoutExercises) {
            this.name = name;
            this.workoutExercises = workoutExercises;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public List<WorkoutExerciseDto> getWorkoutExercises() {
            return workoutExercises;
        }
    }
}
