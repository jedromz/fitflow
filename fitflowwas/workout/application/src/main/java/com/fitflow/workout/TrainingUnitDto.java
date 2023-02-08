package com.fitflow.workout;

import java.util.ArrayList;
import java.util.List;

public class TrainingUnitDto {
    private String name;
    private List<WorkoutExerciseDto> workoutExercises = new ArrayList<>();

    TrainingUnitDto(String name, List<WorkoutExerciseDto> workoutExercises) {
        this.name = name;
        this.workoutExercises = workoutExercises;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    List<WorkoutExerciseDto> getWorkoutExercises() {
        return workoutExercises;
    }

    void setWorkoutExercises(List<WorkoutExerciseDto> workoutExercises) {
        this.workoutExercises = workoutExercises;
    }
}
