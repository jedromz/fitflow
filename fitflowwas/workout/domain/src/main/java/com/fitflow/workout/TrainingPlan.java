package com.fitflow.workout;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
                snapshot.getDateEnd(),
                snapshot.getTrainingUnits().stream()
                        .map(tu -> TrainingUnit.restore(tu)).toList());
    }

    private int id;
    private String name;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private List<TrainingUnit> trainingUnits;

    TrainingPlan(int id, String name, LocalDate dateStart, LocalDate dateEnd, List<TrainingUnit> trainingUnits) {
        this.id = id;
        this.name = name;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.trainingUnits = trainingUnits;
    }

    static class TrainingUnit {

        static TrainingUnit restore(TrainingUnitSnapshot snapshot) {
            return new TrainingUnit(snapshot.getName(), snapshot.getWorkoutExercises()
                    .stream()
                    .peek(tu-> tu.getExercise())
                    .map(we -> new WorkoutExercise(we.getNumberOfReps(), we.getNumberOfSets(), we.getSuggestedProgression(), we.getExercise())).toList());
        }

        private int id;
        private String name;
        private List<WorkoutExercise> workouts = new ArrayList<>();

        TrainingUnit(int id, String name) {
            this.id = id;
            this.name = name;
        }

        TrainingUnit(String name, List<WorkoutExercise> workouts) {
            this.name = name;
            this.workouts = workouts;
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

//    void modifyExercise(int trainingUnitId, int exerciseId, int numberOfReps, int numberOfSets, int suggestedProgression) {
//        trainingUnits.stream()
//                .filter(tu -> tu.id == trainingUnitId)
//                .map(tu -> tu.workouts)
//                .flatMap(Collection::stream)
//                .filter(w -> w.getExercise().getExerciseId() == exerciseId)
//                .forEach(w -> w.update(numberOfReps, numberOfSets, suggestedProgression));
//    }

    void addExercise(int trainingUnitId, WorkoutExercise workoutExercise) {
        trainingUnits.stream()
                .filter(tu -> tu.id == trainingUnitId)
                .forEach(tu -> tu.addExercise(workoutExercise));
    }

    TrainingPlanSnapshot getSnapshot() {
        return new TrainingPlanSnapshot(
                id, name, dateStart, dateEnd, trainingUnits.stream().map(tu -> new TrainingUnitSnapshot(tu.name, tu.workouts.stream().map(w -> new WorkoutExerciseSnapshot(w.getNumberOfReps(), w.getNumberOfSets(), w.getSuggestedProgression(), w.getExercise())).toList())).collect(Collectors.toSet()));
    }
}
