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
public class CreateMentorshipRequest {
    private LocalDate fromDate;
    private LocalDate toDate;
    private Long trainerId;
    private BigDecimal price;
    private String traineeEmail;
    private String traineeName;
    private String type;
}
