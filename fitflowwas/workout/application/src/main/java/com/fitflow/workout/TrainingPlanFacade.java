package com.fitflow.workout;

public class TrainingPlanFacade {

    private final TrainingPlanRepository trainingPlanRepository;

    public TrainingPlanFacade(TrainingPlanRepository trainingPlanRepository) {
        this.trainingPlanRepository = trainingPlanRepository;
    }

    public TrainingPlanSnapshot save(TrainingPlan trainingPlan) {
        return trainingPlanRepository.save(trainingPlan);
    }
}
