package com.fitflow.api.mentorships.controller;

import java.math.BigDecimal;
import java.time.LocalDate;


public interface MentorshipResponse {
    LocalDate getFromDate();

    LocalDate getToDate();

    BigDecimal getPrice();
}



