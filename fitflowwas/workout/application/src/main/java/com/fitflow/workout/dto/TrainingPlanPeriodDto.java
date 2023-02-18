package com.fitflow.workout.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDate;

@JsonDeserialize(as = TrainingPlanPeriodDto.DeserializationImpl.class)
public interface TrainingPlanPeriodDto {
    LocalDate getDateStart();

    LocalDate getDateEnd();

    class DeserializationImpl implements TrainingPlanPeriodDto {
        LocalDate dateStart;
        LocalDate dateEnd;


        public LocalDate getDateStart() {
            return dateStart;
        }


        public LocalDate getDateEnd() {
            return dateEnd;
        }
    }
}
