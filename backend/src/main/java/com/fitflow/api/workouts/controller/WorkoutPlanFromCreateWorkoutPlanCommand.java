package com.fitflow.api.workouts.controller;

import com.fitflow.api.workouts.model.WorkoutPlan;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Service;

@Service
public class WorkoutPlanFromCreateWorkoutPlanCommand implements Converter<CreateWorkoutPlanCommand, WorkoutPlan> {
    @Override
    public WorkoutPlan convert(MappingContext<CreateWorkoutPlanCommand, WorkoutPlan> mappingContext) {
        CreateWorkoutPlanCommand source = mappingContext.getSource();
        WorkoutPlan workoutPlan = new WorkoutPlan();
        workoutPlan.setName(source.getName());
        workoutPlan.setDescription(source.getDescription());
        return workoutPlan;
    }
}
