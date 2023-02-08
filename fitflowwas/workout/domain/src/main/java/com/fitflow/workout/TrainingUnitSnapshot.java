package com.fitflow.workout;

import java.util.List;

public class TrainingUnitSnapshot {
    private int id;
    private String name;
    private List<WorkoutExerciseSnapshot> workouts;

    TrainingUnitSnapshot() {
    }

    TrainingUnitSnapshot(String name) {
        this.name = name;
    }

    TrainingUnitSnapshot(String name, List<WorkoutExerciseSnapshot> workouts) {
        this.name = name;
        this.workouts = workouts;
    }

    int getId() {
        return id;
    }

    void setId(int id) {
        this.id = id;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    List<WorkoutExerciseSnapshot> getWorkouts() {
        return workouts;
    }

    void setWorkouts(List<WorkoutExerciseSnapshot> workouts) {
        this.workouts = workouts;
    }
}
