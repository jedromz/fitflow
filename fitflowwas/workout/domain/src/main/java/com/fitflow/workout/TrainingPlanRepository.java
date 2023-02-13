package com.fitflow.workout;

import java.util.Optional;

interface TrainingPlanRepository {

    TrainingPlan save(TrainingPlan trainingPlan);

    Optional<TrainingPlan> findById(Integer id);

}
