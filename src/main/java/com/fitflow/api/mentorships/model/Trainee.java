package com.fitflow.api.mentorships.model;

import com.fitflow.api.base.BaseEntity;
import com.fitflow.api.workouts.model.WorkoutPlan;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Trainee extends BaseEntity {
    private String name;
    private String email;
    @OneToMany(mappedBy = "trainee")
    private List<Mentorship> mentorships = new ArrayList<>();
    @OneToMany(mappedBy = "trainee")
    private List<WorkoutPlan> workoutPlans = new ArrayList<>();
}
