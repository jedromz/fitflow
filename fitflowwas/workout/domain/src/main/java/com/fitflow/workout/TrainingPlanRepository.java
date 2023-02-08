package com.fitflow.workout;

import java.util.Optional;

interface TrainingPlanRepository {

    Optional<TrainingPlan> findById(Integer id);

    TrainingPlan save(TrainingPlan trainingPlan);
}
