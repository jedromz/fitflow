package com.fitflow.workout;

import com.fitflow.workout.dto.TrainingPlanDto;
import com.fitflow.workout.error.EntityNotFoundException;

public class TrainingPlanFacade {

    private final TrainingPlanRepository trainingPlanRepository;
    private final TrainingPlanFactory trainingPlanFactory;

    public TrainingPlanFacade(TrainingPlanRepository trainingPlanRepository, TrainingPlanFactory trainingPlanFactory) {
        this.trainingPlanRepository = trainingPlanRepository;
        this.trainingPlanFactory = trainingPlanFactory;
    }

    public TrainingPlanSnapshot save(TrainingPlanDto toCreate) {
        return trainingPlanRepository.save(trainingPlanFactory.from(toCreate)).getSnapshot();
    }

    public void delete(int id) throws EntityNotFoundException {
        TrainingPlan trainingPlan = trainingPlanRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("training_plan", "id", String.valueOf(id)));
        trainingPlan.softDelete();
        trainingPlanRepository.save(trainingPlan);

    }
}
