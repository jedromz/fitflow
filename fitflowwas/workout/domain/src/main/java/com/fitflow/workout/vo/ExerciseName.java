package com.fitflow.workout.vo;

public record ExerciseName(String name) {
    public static ExerciseName of(String name) {
        return new ExerciseName(name);
    }
}
