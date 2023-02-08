package com.fitflow.workout;

public class WorkoutExerciseDto {
    private int numberOfReps;
    private int numberOfSets;
    private int suggestedProgression;
    private ExerciseDto exercise;

    WorkoutExerciseDto(int numberOfReps, int numberOfSets, int suggestedProgression, ExerciseDto exercise) {
        this.numberOfReps = numberOfReps;
        this.numberOfSets = numberOfSets;
        this.suggestedProgression = suggestedProgression;
        this.exercise = exercise;
    }

    int getNumberOfReps() {
        return numberOfReps;
    }

    void setNumberOfReps(int numberOfReps) {
        this.numberOfReps = numberOfReps;
    }

    int getNumberOfSets() {
        return numberOfSets;
    }

    void setNumberOfSets(int numberOfSets) {
        this.numberOfSets = numberOfSets;
    }

    int getSuggestedProgression() {
        return suggestedProgression;
    }

    void setSuggestedProgression(int suggestedProgression) {
        this.suggestedProgression = suggestedProgression;
    }

    ExerciseDto getExercise() {
        return exercise;
    }

    void setExercise(ExerciseDto exercise) {
        this.exercise = exercise;
    }
}
