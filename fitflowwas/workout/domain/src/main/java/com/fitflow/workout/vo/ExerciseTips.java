package com.fitflow.workout.vo;

public record ExerciseTips(String tips) {
    public static ExerciseTips of(String tips) {
        return new ExerciseTips(tips);
    }
}
