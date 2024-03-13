package com.fitflow.api.mentorships.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.math.BigDecimal;
import java.time.LocalDate;


public interface MentorshipResponse {
    LocalDate getFromDate();

    LocalDate getToDate();

    BigDecimal getPrice();
}



