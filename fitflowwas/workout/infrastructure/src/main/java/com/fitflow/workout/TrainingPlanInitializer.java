package com.fitflow.workout;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class TrainingPlanInitializer {
    private final TrainingPlanRepository trainingPlanRepository;

    public TrainingPlanInitializer(TrainingPlanRepository trainingPlanRepository) {
        this.trainingPlanRepository = trainingPlanRepository;
    }

    void init() {
        trainingPlanRepository.save(TrainingPlan.restore(
                        new TrainingPlanSnapshot(
                                "TestTrainingPlan1",
                                LocalDate.now(),
                                LocalDate.now(),
                                Set.of(
                                        new TrainingUnitSnapshot("TestTrainingUnit1", List.of(
                                                new WorkoutExerciseSnapshot(3, 10, 10, new Exercise("Test Exercise1", "test tips")))))
                        )
                )
        );
    }
}
