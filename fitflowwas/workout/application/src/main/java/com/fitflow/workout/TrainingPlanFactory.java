package com.fitflow.workout;

import com.fitflow.workout.dto.TrainingPlanDto;

import java.util.stream.Collectors;

class TrainingPlanFactory {

    TrainingPlan from(TrainingPlanDto source) {
        return TrainingPlan.restore(new TrainingPlanSnapshot(
                source.getId(),
                source.getName(),
                source.getDateStart(),
                source.getDateEnd(),
                source.getTrainingUnits().stream()
                        .map(tu -> new TrainingUnitSnapshot(tu.getName(), tu.getWorkoutExercises()
                                .stream()
                                .map(we -> new WorkoutExerciseSnapshot(we.getNumberOfReps(), we.getNumberOfSets(), we.getSuggestedProgression(), new Exercise(we.getExercise().getName(), we.getExercise().getTips())))
                                .toList()))
                        .collect(Collectors.toSet()))
        );
    }
}
