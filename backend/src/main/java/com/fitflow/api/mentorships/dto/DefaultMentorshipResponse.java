package com.fitflow.api.mentorships.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DefaultMentorshipResponse implements MentorshipResponse {
    private LocalDate fromDate;
    private LocalDate toDate;
    private BigDecimal price;
    private String trainne_Name;

    public DefaultMentorshipResponse() {
    }

    public DefaultMentorshipResponse(LocalDate fromDate, LocalDate toDate, BigDecimal price, String trainne_Name) {
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.price = price;
        this.trainne_Name = trainne_Name;
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
