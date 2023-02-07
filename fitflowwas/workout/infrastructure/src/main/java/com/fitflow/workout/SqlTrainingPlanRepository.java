package com.fitflow.workout;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SqlTrainingPlanRepository extends JpaRepository<TrainingPlanSnapshot, Integer> {
}

@org.springframework.stereotype.Repository
class SimpleTrainingPlanRepository implements TrainingPlanRepository {

    private final SqlTrainingPlanRepository sqlTrainingPlanRepository;

    SimpleTrainingPlanRepository(SqlTrainingPlanRepository sqlTrainingPlanRepository) {
        this.sqlTrainingPlanRepository = sqlTrainingPlanRepository;
    }

    @Override
    public Optional<TrainingPlan> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public TrainingPlanSnapshot save(TrainingPlan trainingPlan) {
         return sqlTrainingPlanRepository.save(trainingPlan.getSnapshot());
    }
}