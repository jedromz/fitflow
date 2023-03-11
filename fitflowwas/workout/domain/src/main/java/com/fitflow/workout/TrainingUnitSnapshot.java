package com.fitflow.workout;

import java.util.ArrayList;
import java.util.List;

class TrainingUnitSnapshot {
    private int id;
    private String name;
    private List<WorkoutExerciseSnapshot> workoutExercises;

    TrainingUnitSnapshot() {
    }

    TrainingUnitSnapshot(String name) {
        this.name = name;
    }

    TrainingUnitSnapshot(String name, List<WorkoutExerciseSnapshot> workoutExercises) {
        this.name = name;
        this.workoutExercises = workoutExercises;
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

    List<WorkoutExerciseSnapshot> getWorkoutExercises() {
        return workoutExercises;
    }
}
