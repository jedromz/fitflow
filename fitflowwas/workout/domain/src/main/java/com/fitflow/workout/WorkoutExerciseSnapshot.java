package com.fitflow.workout;

class WorkoutExerciseSnapshot {
    private int id;
    private int numberOfReps;
    private int numberOfSets;
    private int suggestedProgression;
    private Exercise exercise;

    WorkoutExerciseSnapshot() {
    }

    WorkoutExerciseSnapshot(int id, int numberOfReps, int numberOfSets, int suggestedProgression, Exercise exercise) {
        this.id = id;
        this.numberOfReps = numberOfReps;
        this.numberOfSets = numberOfSets;
        this.suggestedProgression = suggestedProgression;
        this.exercise = exercise;
    }

    WorkoutExerciseSnapshot(int numberOfReps, int numberOfSets, int suggestedProgression) {
        this.numberOfReps = numberOfReps;
        this.numberOfSets = numberOfSets;
        this.suggestedProgression = suggestedProgression;
    }

    WorkoutExerciseSnapshot(int numberOfReps, int numberOfSets, int suggestedProgression, Exercise exercise) {
        this.numberOfReps = numberOfReps;
        this.numberOfSets = numberOfSets;
        this.suggestedProgression = suggestedProgression;
        this.exercise = exercise;
    }

    int getNumberOfReps() {
        return numberOfReps;
    }

    int getNumberOfSets() {
        return numberOfSets;
    }

    int getSuggestedProgression() {
        return suggestedProgression;
    }

    int getId() {
        return id;
    }

    Exercise getExercise() {
        return exercise;
    }
}
