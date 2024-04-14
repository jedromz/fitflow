package com.fitflow.api.workouts.controller;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateWorkoutPlanCommand {
    private String name;
    private String description;
    private LocalDate fromDate;
    private LocalDate toDate;
    private Long trainerId;
    private String traineeEmail;
    private List<WorkoutDto> workouts;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class WorkoutDto {
        private String name;
        private List<ExerciseDto> exercises;
    }
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class ExerciseDto {
        private String name;
        private int sets;
        private int reps;
    }
}
