package com.fitflow.workout;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

class TrainingPlanSnapshot {
    private int id;
    private String name;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private Set<TrainingUnitSnapshot> trainingUnits = new HashSet<>();

    TrainingPlanSnapshot() {
    }

    TrainingPlanSnapshot(int id, String name, LocalDate dateStart, LocalDate dateEnd, Set<TrainingUnitSnapshot> trainingUnits) {
        this.id = id;
        this.name = name;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.trainingUnits = trainingUnits;
    }

    TrainingPlanSnapshot(String name, LocalDate dateStart, LocalDate dateEnd, Set<TrainingUnitSnapshot> trainingUnits) {
        this.name = name;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.trainingUnits = trainingUnits;
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

    Set<TrainingUnitSnapshot> getTrainingUnits() {
        return trainingUnits;
    }
}
