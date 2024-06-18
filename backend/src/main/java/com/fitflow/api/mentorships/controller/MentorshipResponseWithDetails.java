package com.fitflow.api.mentorships.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MentorshipResponseWithDetails {

    private LocalDate fromDate;
    private LocalDate toDate;
    private BigDecimal price;
    private TrainerDetails trainer;
    private TraineeDetails trainee;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class TraineeDetails {
        private String name;
        private String email;
        private double height;
        private double weight;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class TrainerDetails {
        private String name;
        private String email;
    }
}
