package com.fitflow.workout;

import java.time.LocalDate;
import java.util.List;

class TrainingPlanSnapshot {
    private int id;
    private String name;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    TrainingPlanSnapshot() {
    }

    TrainingPlanSnapshot(int id, String name, LocalDate dateStart, LocalDate dateEnd) {
        this.id = id;
        this.name = name;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }


    int getId() {
        return id;
    }

    String getName() {
        return name;
    }

    LocalDate getDateStart() {
        return dateStart;
    }

    LocalDate getDateEnd() {
        return dateEnd;
    }

}
