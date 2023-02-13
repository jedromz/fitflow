package com.fitflow.workout;

import com.fitflow.workout.vo.TrainingPlanPeriod;

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
                snapshot.isDeleted(),
                snapshot.getVersion(),
                snapshot.getTrainingPlanPeriod(),
                snapshot.getTrainingUnits().stream()
                        .map(TrainingUnit::restore).toList());
    }

    private int id;
    private String name;
    private boolean deleted;
    private int version;
    private TrainingPlanPeriod trainingPlanPeriod;
    private List<TrainingUnit> trainingUnits;

    TrainingPlan(int id, String name, boolean deleted, int version, TrainingPlanPeriod trainingPlanPeriod, List<TrainingUnit> trainingUnits) {
        this.id = id;
        this.name = name;
        this.deleted = deleted;
        this.version = version;
        this.trainingPlanPeriod = trainingPlanPeriod;
        this.trainingUnits = trainingUnits;
    }

    static class TrainingUnit {

        static TrainingUnit restore(TrainingUnitSnapshot snapshot) {
            return new TrainingUnit(snapshot.getName(), snapshot.getWorkoutExercises()
                    .stream()
                    .peek(tu -> tu.getExercise())
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

    void addExercise(int trainingUnitId, WorkoutExercise workoutExercise) {
        trainingUnits.stream()
                .filter(tu -> tu.id == trainingUnitId)
                .forEach(tu -> tu.addExercise(workoutExercise));
    }

    void softDelete() {
        this.deleted = true;
    }

    TrainingPlanSnapshot getSnapshot() {
        return new TrainingPlanSnapshot(
                id, name, trainingPlanPeriod, deleted, version, trainingUnits.stream().map(tu -> new TrainingUnitSnapshot(tu.name, tu.workouts.stream().map(w -> new WorkoutExerciseSnapshot(w.getNumberOfReps(), w.getNumberOfSets(), w.getSuggestedProgression(), w.getExercise())).toList())).collect(Collectors.toSet()));
    }
}
