package com.fitflow.api.workouts.service;

import com.fitflow.api.mentorships.repository.TraineeRepository;
import com.fitflow.api.mentorships.repository.TrainerRepository;
import com.fitflow.api.workouts.controller.CreateWorkoutPlanCommand;
import com.fitflow.api.workouts.controller.WorkoutPlanResponse;
import com.fitflow.api.workouts.model.WorkoutPlan;
import com.fitflow.api.workouts.repository.WorkoutPlanRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkoutPlanService {

    private final WorkoutPlanRepository workoutPlanRepository;
    private final TraineeRepository traineeRepository;
    private final TrainerRepository trainerRepository;
    private final ModelMapper modelMapper;

    public WorkoutPlanService(WorkoutPlanRepository workoutPlanRepository, TraineeRepository traineeRepository, TrainerRepository trainerRepository, ModelMapper modelMapper) {
        this.workoutPlanRepository = workoutPlanRepository;
        this.traineeRepository = traineeRepository;
        this.trainerRepository = trainerRepository;
        this.modelMapper = modelMapper;
    }


    public WorkoutPlan addWorkoutPlan(CreateWorkoutPlanCommand createWorkoutPlanCommand) {
        final var trainee = traineeRepository.findByEmail(createWorkoutPlanCommand.getTraineeEmail())
                .orElseThrow(() -> new RuntimeException("Trainee not found"));
        final var trainer = trainerRepository.findById(createWorkoutPlanCommand.getTrainerId())
                .orElseThrow(() -> new RuntimeException("Trainer not found"));

        var workoutPlan = modelMapper.map(createWorkoutPlanCommand, WorkoutPlan.class);
        workoutPlan.setTrainee(trainee);
        workoutPlan.setTrainer(trainer);

        return workoutPlanRepository.save(workoutPlan);
    }

    public List<WorkoutPlanResponse> findTrainersWorkoutPlans(long trainerId) {
        return workoutPlanRepository.findAllByTrainerId(trainerId);
    }

    public List<WorkoutPlanResponse> findTraineesWorkoutPlans(long traineeId) {
        return workoutPlanRepository.findAllByTraineeId(traineeId);
    }
}
