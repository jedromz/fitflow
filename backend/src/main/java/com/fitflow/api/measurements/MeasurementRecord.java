package com.fitflow.api.measurements;

import com.fitflow.api.base.BaseEntity;
import com.fitflow.api.mentorships.model.Trainee;
import jakarta.persistence.*;
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
public class MeasurementRecord extends BaseEntity {
    @Enumerated(EnumType.STRING)
    private BodyPart bodyPart;
    @Embedded
    private Measurement measurement;
    private LocalDate date;
    @ManyToOne
    private Trainee trainee;
}
