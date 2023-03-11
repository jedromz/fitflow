package com.fitflow.workout;

import com.fitflow.workout.vo.TrainingPlanPeriod;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

class TrainingPlanInitializer {
    private final TrainingPlanRepository trainingPlanRepository;

    public TrainingPlanInitializer(TrainingPlanRepository trainingPlanRepository) {
        this.trainingPlanRepository = trainingPlanRepository;
    }

    void init() {
        trainingPlanRepository.save(TrainingPlan.restore(
                        new TrainingPlanSnapshot(
                                "TestTrainingPlan1",
                                new TrainingPlanPeriod(LocalDate.now(), LocalDate.now()),
                                Set.of(
                                        new TrainingUnitSnapshot
                                                ("TestTrainingUnit1", List.of(
                                                        new WorkoutExerciseSnapshot(3, 10, 10, new Exercise("Test Exercise1", "test tips")))))
                        )
                )
        );
        trainingPlanRepository.save(TrainingPlan.restore(
                        new TrainingPlanSnapshot(
                                "TestTrainingPlan2",
                                new TrainingPlanPeriod(LocalDate.now(), LocalDate.now()),
                                Set.of(
                                        new TrainingUnitSnapshot
                                                ("TestTrainingUnit1", List.of(
                                                        new WorkoutExerciseSnapshot(3, 10, 10, new Exercise("Test Exercise1", "test tips")))))
                        )
                )
        );
    }
}
