package com.fitflow.workout.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

@JsonDeserialize(as = TrainingPlanDto.DeserializationImpl.class)
public interface TrainingPlanDto {
    int getId();

    String getName();

    TrainingPlanPeriodDto getTrainingPlanPeriod();

    boolean isDeleted();

    int getVersion();

    List<TrainingUnitDto> getTrainingUnits();

    class DeserializationImpl implements TrainingPlanDto {
        private int id;
        private String name;
        private TrainingPlanPeriodDto trainingPlanPeriod;
        boolean deleted;
        int version;
        private List<TrainingUnitDto> trainingUnits;

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public boolean isDeleted() {
            return deleted;
        }

        public int getVersion() {
            return version;
        }

        public TrainingPlanPeriodDto getTrainingPlanPeriod() {
            return trainingPlanPeriod;
        }

        public List<TrainingUnitDto> getTrainingUnits() {
            return trainingUnits;
        }
    }
}
