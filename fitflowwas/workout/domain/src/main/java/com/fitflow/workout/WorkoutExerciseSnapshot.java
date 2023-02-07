package com.fitflow.workout;

class WorkoutExerciseSnapshot {
    private int numberOfReps;
    private int numberOfSets;
    private int suggestedProgression;

    WorkoutExerciseSnapshot() {
    }

    WorkoutExerciseSnapshot(int numberOfReps, int numberOfSets, int suggestedProgression) {
        this.numberOfReps = numberOfReps;
        this.numberOfSets = numberOfSets;
        this.suggestedProgression = suggestedProgression;
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
}
