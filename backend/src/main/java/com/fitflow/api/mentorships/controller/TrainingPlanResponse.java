package com.fitflow.api.mentorships.controller;


import com.fitflow.api.workouts.model.WorkoutExercise;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TrainingPlanResponse {
    private String name;
    private String description;
    private LocalDate fromDate;
    private LocalDate toDate;
    private List<ExerciseDto> exercies;
}
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
class ExerciseDto {
    private String name;
    private DayOfWeek dayOfWeek;
    private int exerciseOrder;
}