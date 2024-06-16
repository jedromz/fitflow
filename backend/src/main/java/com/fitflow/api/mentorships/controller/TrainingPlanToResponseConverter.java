package com.fitflow.api.mentorships.controller;

import com.fitflow.api.workouts.model.WorkoutExercise;
import com.fitflow.api.workouts.model.WorkoutPlan;
import org.hibernate.annotations.Comment;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class TrainingPlanToResponseConverter implements Converter<WorkoutPlan, TrainingPlanResponse> {
    @Override
    public TrainingPlanResponse convert(MappingContext<WorkoutPlan, TrainingPlanResponse> mappingContext) {
        WorkoutPlan workoutPlan = mappingContext.getSource();
        TrainingPlanResponse response = new TrainingPlanResponse();
        response.setName(workoutPlan.getName());
        response.setDescription(workoutPlan.getDescription());
        response.setFromDate(workoutPlan.getFromDate());
        response.setToDate(workoutPlan.getToDate());
        response.setExercies(workoutPlan.getWorkouts()
                .stream()
                .flatMap(w -> w.getWorkoutExercises().stream()
                        .map(we -> new ExerciseDto(
                                we.getExercise().getName(),
                                we.getDayOfWeek(),
                                we.getExerciseOrder()
                        )))
                .collect(Collectors.toList()));
        return response;
    }
}
