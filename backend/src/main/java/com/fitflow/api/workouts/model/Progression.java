package com.fitflow.api.workouts.model;

import com.fitflow.api.base.BaseEntity;
import com.fitflow.api.mentorships.model.Trainee;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Progression extends BaseEntity {
    private LocalDate date;
    private int sets;
    private int reps;
    private int weight;
    @ManyToOne
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;
    @ManyToOne
    @JoinColumn(name = "trainee_id")
    private Trainee trainee;
}
