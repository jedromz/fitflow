package com.fitflow.workout.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = ExerciseDto.DeserializationImpl.class)
public interface ExerciseDto {
    String getName();

    String getTips();

    class DeserializationImpl implements ExerciseDto {
        private final String name;
        private final String tips;

        DeserializationImpl(String name, String tips) {
            this.name = name;
            this.tips = tips;
        }


        @Override
        public String getName() {
            return name;
        }

        @Override
        public String getTips() {
            return tips;
        }
    }
}
