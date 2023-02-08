package com.fitflow.workout;

public class TrainingPlanFacade {

    private final TrainingPlanRepository trainingPlanRepository;
    private final TrainingPlanFactory trainingPlanFactory;

    public TrainingPlanFacade(TrainingPlanRepository trainingPlanRepository, TrainingPlanFactory trainingPlanFactory) {
        this.trainingPlanRepository = trainingPlanRepository;
        this.trainingPlanFactory = trainingPlanFactory;
    }

    public TrainingPlanSnapshot save(TrainingPlanCommand toCreate) {

        return trainingPlanRepository.save(trainingPlanFactory.from(toCreate)).getSnapshot();
    }
}
