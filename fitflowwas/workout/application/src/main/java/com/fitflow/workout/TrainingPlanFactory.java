package com.fitflow.workout;

import com.fitflow.workout.dto.TrainingPlanDto;
import com.fitflow.workout.vo.TrainingPlanPeriod;

import java.util.stream.Collectors;

class TrainingPlanFactory {

    TrainingPlan from(TrainingPlanDto source) {
        return TrainingPlan.restore(new TrainingPlanSnapshot(
                source.getId(),
                source.getName(),
                new TrainingPlanPeriod(source.getTrainingPlanPeriod().getDateStart(), source.getTrainingPlanPeriod().getDateEnd()),
                source.isDeleted(),
                source.getVersion(),
                source.getTrainingUnits().stream()
                        .map(tu -> new TrainingUnitSnapshot(tu.getName(), tu.getWorkoutExercises()
                                .stream()
                                .map(we -> new WorkoutExerciseSnapshot(we.getNumberOfReps(), we.getNumberOfSets(), we.getSuggestedProgression(), new Exercise(we.getExercise().getName(), we.getExercise().getTips())))
                                .toList()))
                        .collect(Collectors.toSet()))
        );
    }
}
