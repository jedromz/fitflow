package com.fitflow.workout;

import java.util.stream.Collectors;

class TrainingPlanFactory {

    TrainingPlan from(TrainingPlanCommand source) {
        return TrainingPlan.restore(new TrainingPlanSnapshot(
                source.getName(),
                source.getDateStart(),
                source.getDateEnd(),
                source.getTrainingUnits().stream()
                        .map(tu -> new TrainingUnitSnapshot(tu.getName(), tu.getWorkoutExercises()
                                .stream()
                                .peek(we -> System.out.println(we.getExercise()))
                                .map(we -> new WorkoutExerciseSnapshot(we.getNumberOfReps(), we.getNumberOfSets(), we.getSuggestedProgression(), new Exercise(we.getExercise().getName(), we.getExercise().getTips())))
                                .peek(we -> System.out.println(we.getExercise()))
                                .toList()))
                        .peek(x -> System.out.println(x.getWorkouts()))
                        .collect(Collectors.toSet()))
        );
    }
}
