package com.fitflow.workout;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import java.util.Optional;

interface SqlTrainingPlanRepository extends JpaRepository<TrainingPlanSnapshot, Integer> {
}

interface SqlTrainingPlanQueryRepository extends TrainingPlanQueryRepository, Repository<TrainingPlanSnapshot, Integer> {
}

@org.springframework.stereotype.Repository
class SimpleTrainingPlanRepository implements TrainingPlanRepository {

    private final SqlTrainingPlanRepository sqlTrainingPlanRepository;

    SimpleTrainingPlanRepository(SqlTrainingPlanRepository sqlTrainingPlanRepository) {
        this.sqlTrainingPlanRepository = sqlTrainingPlanRepository;
    }


    @Override
    public TrainingPlan save(TrainingPlan trainingPlan) {
        return TrainingPlan.restore(sqlTrainingPlanRepository.save(trainingPlan.getSnapshot()));
    }

    @Override
    public Optional<TrainingPlan> findById(Integer id) {
        return sqlTrainingPlanRepository.findById(id).map(TrainingPlan::restore);
    }
}