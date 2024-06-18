package com.fitflow.api.workouts.controller;

import java.time.LocalDate;

public interface WorkoutPlanResponse {

    Long getId();

    String getName();

    String getDescription();

    LocalDate getFromDate();

    LocalDate getToDate();
}
