package com.fitflow.api.reports;

import com.fitflow.api.base.BaseEntity;
import com.fitflow.api.mentorships.model.Trainer;
import com.fitflow.api.mentorships.model.Trainee;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Comment extends BaseEntity {
    @ManyToOne
    private Trainer trainer;
    @ManyToOne
    private Trainee trainee;
    private String text;
    private LocalDate createdAt;
    @ManyToOne
    private Report report;
}
