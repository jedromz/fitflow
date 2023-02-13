package com.fitflow.workout.vo;

import java.time.LocalDate;

public class TrainingPlanPeriod {
    private LocalDate dateStart;
    private LocalDate dateEnd;

    TrainingPlanPeriod() {
    }

    public TrainingPlanPeriod(LocalDate dateStart, LocalDate dateEnd) {
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    LocalDate getDateStart() {
        return dateStart;
    }

    void setDateStart(LocalDate dateStart) {
        this.dateStart = dateStart;
    }

    LocalDate getDateEnd() {
        return dateEnd;
    }

    void setDateEnd(LocalDate dateEnd) {
        this.dateEnd = dateEnd;
    }
}
