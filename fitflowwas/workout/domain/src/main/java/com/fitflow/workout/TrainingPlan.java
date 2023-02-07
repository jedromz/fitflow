package com.fitflow.workout;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Training Plan is an Aggregate Root for building workouts.
 * List<TrainingUnit> trainingUnits - a list containing a set of exercises with guidelines such as: number of reps, number of sets, suggested progression etc.
 */
class TrainingPlan {

    static TrainingPlan restore(TrainingPlanSnapshot snapshot) {
        return new TrainingPlan(
                snapshot.getId(),
                snapshot.getName(),
                snapshot.getDateStart(),
                snapshot.getDateEnd());
    }

    private int id;
    private String name;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private List<TrainingUnit> trainingUnits = new ArrayList<>();

    private TrainingPlan(int id, String name, LocalDate dateStart, LocalDate dateEnd) {
        this.id = id;
        this.name = name;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    static class TrainingUnit {
        private int id;
        private String name;
        private List<WorkoutExercise> workouts = new ArrayList<>();

        TrainingUnit(int id, String name) {
            this.id = id;
            this.name = name;
        }

        void addExercise(WorkoutExercise exercise) {
            workouts.add(exercise);
        }

        List<WorkoutExercise> getWorkouts() {
            return workouts;
        }

    }

    void addTrainingUnit(TrainingUnit trainingUnit) {
        trainingUnits.add(trainingUnit);
    }

    void removeTrainingUnit(TrainingUnit trainingUnit) {
        trainingUnits.remove(trainingUnit);
    }

    void extendEndDate(Period period) {
        dateEnd.plus(period);
    }

    void modifyExercise(int trainingUnitId, int exerciseId, int numberOfReps, int numberOfSets, int suggestedProgression) {
        trainingUnits.stream()
                .filter(tu -> tu.id == trainingUnitId)
                .map(tu -> tu.workouts)
                .flatMap(Collection::stream)
                .filter(w -> w.getExercise().getExerciseId().id() == exerciseId)
                .forEach(w -> w.update(numberOfReps, numberOfSets, suggestedProgression));
    }

    void addExercise(int trainingUnitId, WorkoutExercise workoutExercise) {
        trainingUnits.stream()
                .filter(tu -> tu.id == trainingUnitId)
                .forEach(tu -> tu.addExercise(workoutExercise));
    }

    TrainingPlanSnapshot getSnapshot() {
        return new TrainingPlanSnapshot(
                id, name, dateStart, dateEnd);
    }
}
