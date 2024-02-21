package com.fitflow.api.mentorships.controller;

import java.time.LocalDate;


public interface MentorshipResponse {
    LocalDate getFromDate();
    LocalDate getToDate();
}

