package com.fitflow.api.mentorships.controller;

import com.fitflow.api.mentorships.dto.MentorshipResponse;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DefaultMentorshipResponse implements MentorshipResponse {

    private LocalDate fromDate;
    private LocalDate toDate;
    private BigDecimal price;
    private String trainee_Name;

    // Constructor with all fields
    public DefaultMentorshipResponse(LocalDate fromDate, LocalDate toDate, BigDecimal price, String trainee_Name) {
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.price = price;
        this.trainee_Name = trainee_Name;
    }

    // Default constructor
    public DefaultMentorshipResponse() {
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
        return trainee_Name;
    }

    // Setter methods (optional, if needed)
    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setTrainee_Name(String trainee_Name) {
        this.trainee_Name = trainee_Name;
    }
}
