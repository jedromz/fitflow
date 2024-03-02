package com.fitflow.api.mentorships.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;


public interface MentorshipResponse {
    LocalDate getFromDate();

    LocalDate getToDate();

    BigDecimal getPrice();
}

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
class DefaultMentorshipResponse implements MentorshipResponse {
    private LocalDate fromDate;
    private LocalDate toDate;
    private BigDecimal price;


    public LocalDate getFromDate() {
        return fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public BigDecimal getPrice() {
        return price;
    }
}



