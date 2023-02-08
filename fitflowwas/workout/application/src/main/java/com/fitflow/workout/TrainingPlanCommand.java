package com.fitflow.workout;

import java.time.LocalDate;
import java.util.List;

public class TrainingPlanCommand {
    private String name;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private List<TrainingUnitDto> trainingUnits;

    TrainingPlanCommand(String name, LocalDate dateStart, LocalDate dateEnd, List<TrainingUnitDto> trainingUnits) {
        this.name = name;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.trainingUnits = trainingUnits;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
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

    List<TrainingUnitDto> getTrainingUnits() {
        return trainingUnits;
    }

    void setTrainingUnits(List<TrainingUnitDto> trainingUnits) {
        this.trainingUnits = trainingUnits;
    }
}
