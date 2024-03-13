package com.fitflow.api.mentorships.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DefaultMentorshipResponse extends RepresentationModel<DefaultMentorshipResponse> implements MentorshipResponse {
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
