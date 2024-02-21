package com.fitflow.api.workouts.model;

import com.fitflow.api.base.BaseEntity;
import com.fitflow.api.mentorships.model.Trainee;
import com.fitflow.api.mentorships.model.Trainer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WorkoutPlan extends BaseEntity {
    private String name;
    private String description;
    private LocalDate fromDate;
    private LocalDate toDate;

    @ManyToOne
    private Trainee trainee;

    @ManyToOne
    private Trainer trainer;

    @OneToMany(mappedBy = "workoutPlan", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Workout> workouts;
}

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
class Workout extends BaseEntity {
    private LocalDate date;

    @ManyToOne
    private WorkoutPlan workoutPlan;

    @OneToMany(mappedBy = "workout", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<WorkoutExercise> workoutExercises; // Updated to use WorkoutExercise
}


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
class WorkoutExercise extends BaseEntity {
    @ManyToOne
    private Workout workout;

    @ManyToOne
    private Exercise exercise;

    private int sets;
    private int reps;
}

