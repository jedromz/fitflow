package com.fitflow.api.workouts.model;

import com.fitflow.api.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.DayOfWeek;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WorkoutExercise extends BaseEntity {
    @ManyToOne
    private Workout workout;

    @ManyToOne
    private Exercise exercise;

    private DayOfWeek dayOfWeek;
    private int exerciseOrder;
    private int sets;
    private int reps;
}