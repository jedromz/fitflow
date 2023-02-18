package com.fitflow.workout;

import com.fitflow.workout.vo.TrainingPlanPeriod;

import java.util.HashSet;
import java.util.Set;

class TrainingPlanSnapshot {
    private int id;
    private String name;
    private TrainingPlanPeriod trainingPlanPeriod;
    private boolean deleted;
    private int version;
    private Set<TrainingUnitSnapshot> trainingUnits = new HashSet<>();

    TrainingPlanSnapshot() {
    }

    TrainingPlanSnapshot(int id, String name, TrainingPlanPeriod trainingPlanPeriod, boolean deleted, int version, Set<TrainingUnitSnapshot> trainingUnits) {
        this.id = id;
        this.name = name;
        this.trainingPlanPeriod = trainingPlanPeriod;
        this.deleted = deleted;
        this.version = version;
        this.trainingUnits = trainingUnits;
    }

    TrainingPlanSnapshot(String name, TrainingPlanPeriod trainingPlanPeriod, Set<TrainingUnitSnapshot> trainingUnits) {
        this.name = name;
        this.trainingPlanPeriod = trainingPlanPeriod;
        this.trainingUnits = trainingUnits;
    }

    int getId() {
        return id;
    }

    String getName() {
        return name;
    }

    Set<TrainingUnitSnapshot> getTrainingUnits() {
        return trainingUnits;
    }

    TrainingPlanPeriod getTrainingPlanPeriod() {
        return trainingPlanPeriod;
    }

    boolean isDeleted() {
        return deleted;
    }

    int getVersion() {
        return version;
    }
}
