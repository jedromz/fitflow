package com.fitflow.api.mentorships.dto;

import java.math.BigDecimal;
import java.time.LocalDate;


public interface MentorshipResponse {

    Long getId();

    LocalDate getFromDate();

    LocalDate getToDate();

    BigDecimal getPrice();

    String getTrainee_Name();
}



