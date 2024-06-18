package com.fitflow.api.mentorships.model;

import com.fitflow.api.auth.User;
import com.fitflow.api.base.BaseEntity;
import com.fitflow.api.measurements.MeasurementRecord;
import com.fitflow.api.reports.Report;
import com.fitflow.api.workouts.model.Progression;
import com.fitflow.api.workouts.model.WorkoutPlan;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.time.LocalDate;
import java.util.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Trainee extends BaseEntity {
    private String name;
    @Column(unique = true)
    private String email;
    private double height; // Height in meters or centimeters
    private double weight; // Weight in kilograms

    @OneToMany(mappedBy = "trainee")
    private List<Mentorship> mentorships = new ArrayList<>();
    @OneToMany(mappedBy = "trainee")
    private List<WorkoutPlan> workoutPlans = new ArrayList<>();
    @OneToMany(mappedBy = "trainee")
    private List<Report> reports = new ArrayList<>();
    @OneToMany(mappedBy = "trainee")
    private List<MeasurementRecord> measurements = new ArrayList<>();
    @OneToMany(mappedBy = "trainee")
    private List<Progression> progressions = new ArrayList<>();
    @OneToOne
    private User user;

    public Map<String, String> lastProgression(String exerciseName) {
        return progressions.stream()
                .filter(progression -> progression.getExercise().getName().equals(exerciseName))
                .max(Comparator.comparing(Progression::getDate))
                .map(progression -> Map.of("sets", String.valueOf(progression.getSets()),
                        "reps", String.valueOf(progression.getReps()),
                        "weight", String.valueOf(progression.getWeight())))
                .orElseGet(() -> Map.of("sets", "0", "reps", "0", "weight", "0"));
    }

    public Trainer currentTrainer() {
        return mentorships.stream()
                .min(Comparator.comparing(Mentorship::getFromDate))
                .map(Mentorship::getTrainer)
                .orElseThrow();
    }

    public Mentorship currentMentorship() {
        return mentorships.stream()
                .filter(mentorship -> mentorship.getFromDate().isBefore(LocalDate.now()))
                .filter(mentorship -> mentorship.getToDate().isAfter(LocalDate.now())).max(Comparator.comparing(Mentorship::getFromDate))
                .orElseThrow();
    }

    public WorkoutPlan currentTrainingPlan() {
        return workoutPlans.stream()
                .filter(workoutPlan -> workoutPlan.getFromDate().isBefore(LocalDate.now()))
                .filter(workoutPlan -> workoutPlan.getToDate().isAfter(LocalDate.now()))
                .max(Comparator.comparing(WorkoutPlan::getFromDate))
                .orElseGet(() -> workoutPlans.stream()
                        .filter(workoutPlan -> workoutPlan.getToDate().isBefore(LocalDate.now()))
                        .max(Comparator.comparing(WorkoutPlan::getFromDate))
                        .orElseThrow());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trainee trainee = (Trainee) o;
        return Objects.equals(name, trainee.name) && Objects.equals(email, trainee.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, email);
    }
}
