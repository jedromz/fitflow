package com.fitflow.api.mentorships.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
public class DefaultMentorshipResponse implements MentorshipResponse {

    private Long id;
    private LocalDate fromDate;
    private LocalDate toDate;
    private BigDecimal price;
    private String trainne_Name;



    @Override
    public Long getId() {
        return id;
    }

    @Override
    public LocalDate getFromDate() {
        return fromDate;
    }

    @Override
    public LocalDate getToDate() {
        return toDate;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String getTrainee_Name() {
        return trainne_Name;
    }
}
