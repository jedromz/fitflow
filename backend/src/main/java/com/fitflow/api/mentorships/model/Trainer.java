package com.fitflow.api.mentorships.model;

import com.fitflow.api.auth.User;
import com.fitflow.api.base.BaseEntity;
import com.fitflow.api.reports.Report;
import com.fitflow.api.workouts.model.WorkoutPlan;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
public class Trainer extends BaseEntity {
    private String name;
    private String email;
    private String phone;
    private String instagram;
    private String website;
    @Lob
    private String bio;
    private String photo;
    private String password;
    @OneToMany(mappedBy = "trainer")
    private List<Mentorship> mentorships = new ArrayList<>();
    @OneToMany(mappedBy = "trainer")
    private List<WorkoutPlan> workoutPlans = new ArrayList<>();
    @OneToMany(mappedBy = "trainer")
    private List<Report> reports = new ArrayList<>();
    @OneToOne
    private User user;
}
