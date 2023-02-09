package com.fitflow.workout.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = WorkoutExerciseDto.DeserializationImpl.class)
public interface WorkoutExerciseDto {
    int getNumberOfSets();

    int getNumberOfReps();

    int getSuggestedProgression();

    ExerciseDto getExercise();

    class DeserializationImpl implements WorkoutExerciseDto {
        private int numberOfSets;
        private int numberOfReps;
        private int suggestedProgression;
        private ExerciseDto exercise;

        DeserializationImpl(int numberOfSets, int numberOfReps, int suggestedProgression, ExerciseDto exercise) {
            this.numberOfSets = numberOfSets;
            this.numberOfReps = numberOfReps;
            this.suggestedProgression = suggestedProgression;
            this.exercise = exercise;
        }

        @Override
        public int getNumberOfSets() {
            return numberOfSets;
        }

        @Override
        public int getNumberOfReps() {
            return numberOfReps;
        }

        @Override
        public int getSuggestedProgression() {
            return suggestedProgression;
        }

        @Override
        public ExerciseDto getExercise() {
            return exercise;
        }
    }

}
