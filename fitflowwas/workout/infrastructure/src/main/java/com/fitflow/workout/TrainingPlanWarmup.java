package com.fitflow.workout;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class TrainingPlanWarmup implements ApplicationListener<ContextRefreshedEvent> {
    private final TrainingPlanInitializer trainingPlanInitializer;

    public TrainingPlanWarmup(TrainingPlanRepository trainingPlanRepository) {
        this.trainingPlanInitializer = new TrainingPlanInitializer(trainingPlanRepository);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        trainingPlanInitializer.init();
    }
}
