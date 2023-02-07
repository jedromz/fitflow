package com.fitflow.workout;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class TrainingPlanConfiguration {

    @Bean
    public TrainingPlanFacade trainingPlanFacade(final TrainingPlanRepository trainingPlanRepository) {
        return new TrainingPlanFacade(trainingPlanRepository);
    }
}
