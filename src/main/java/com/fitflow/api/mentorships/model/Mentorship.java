package com.fitflow.api.mentorships.model;

import com.fitflow.api.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Mentorship extends BaseEntity {

    @Column(name = "start_date", nullable = false)
    private LocalDate fromDate;
    @Column(name = "end_date", nullable = false)
    private LocalDate toDate;
    @Column(name = "price", nullable = false)
    private BigDecimal price;
    @ManyToOne
    private Trainer trainer;
    @ManyToOne
    private Trainee trainee;
}
