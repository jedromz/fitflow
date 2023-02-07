package com.fitflow.workout;

import java.util.Optional;

interface TrainingPlanRepository {

    Optional<TrainingPlan> findById(Integer id);

    TrainingPlanSnapshot save(TrainingPlan trainingPlan);
}
