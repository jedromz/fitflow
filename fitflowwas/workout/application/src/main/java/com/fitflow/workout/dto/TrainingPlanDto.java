package com.fitflow.workout.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDate;
import java.util.List;

@JsonDeserialize(as = TrainingPlanDto.DeserializationImpl.class)
public interface TrainingPlanDto {
    int getId();

    String getName();

    LocalDate getDateStart();

    LocalDate getDateEnd();

    List<TrainingUnitDto> getTrainingUnits();

    class DeserializationImpl implements TrainingPlanDto {
        private int id;
        private String name;
        private LocalDate dateStart;
        private LocalDate dateEnd;
        private List<TrainingUnitDto> trainingUnits;

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public LocalDate getDateStart() {
            return dateStart;
        }

        public LocalDate getDateEnd() {
            return dateEnd;
        }

        public List<TrainingUnitDto> getTrainingUnits() {
            return trainingUnits;
        }
    }
}
