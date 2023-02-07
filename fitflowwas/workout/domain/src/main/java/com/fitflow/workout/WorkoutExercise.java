package com.fitflow.workout;

class WorkoutExercise {
    private int numberOfReps;
    private int numberOfSets;
    private int suggestedProgression;
    private Exercise exercise;

    WorkoutExercise(int numberOfReps, int numberOfSets, int suggestedProgression, Exercise exercise) {
        this.numberOfReps = numberOfReps;
        this.numberOfSets = numberOfSets;
        this.suggestedProgression = suggestedProgression;
        this.exercise = exercise;
    }

    void update(int numberOfReps, int numberOfSets, int suggestedProgression) {
        this.numberOfReps = numberOfReps;
        this.numberOfSets = numberOfSets;
        this.suggestedProgression = suggestedProgression;
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

    Exercise getExercise() {
        return exercise;
    }

    void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }
}
