package com.fitflow.api.mentorships.model;

import com.fitflow.api.base.BaseEntity;
import com.fitflow.api.measurements.MeasurementRecord;
import com.fitflow.api.reports.Report;
import com.fitflow.api.workouts.model.WorkoutPlan;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Trainee extends BaseEntity {
    private String name;
    @Column(unique = true)
    private String email;
    @OneToMany(mappedBy = "trainee")
    private List<Mentorship> mentorships = new ArrayList<>();
    @OneToMany(mappedBy = "trainee")
    private List<WorkoutPlan> workoutPlans = new ArrayList<>();
    @OneToMany(mappedBy = "trainee")
    private List<Report> reports = new ArrayList<>();
    @OneToMany(mappedBy = "trainee")
    private List<MeasurementRecord> measurements = new ArrayList<>();

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
