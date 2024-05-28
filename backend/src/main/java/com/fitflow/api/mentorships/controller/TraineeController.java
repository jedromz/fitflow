package com.fitflow.api.mentorships.controller;

import com.fitflow.api.mentorships.dto.MentorshipResponse;
import com.fitflow.api.mentorships.model.Mentorship;
import com.fitflow.api.mentorships.model.Trainer;
import com.fitflow.api.mentorships.repository.TraineeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/trainees")
public class TraineeController {

    private final TraineeRepository traineeRepository;
    private final ModelMapper modelMapper;

    public TraineeController(TraineeRepository traineeRepository, ModelMapper modelMapper) {
        this.traineeRepository = traineeRepository;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/{traineeId}")
    public TraineeResponse get(@PathVariable long traineeId) {
        return traineeRepository.findById(traineeId, TraineeResponse.class)
                .orElseThrow(() -> new RuntimeException("Trainee not found"));
    }

    @GetMapping("/{traineeId}/trainers/current")
    public TrainerResponse getCurrentTrainer(@PathVariable long traineeId) {
        Trainer currentTrainer = traineeRepository.findById(traineeId)
                .orElseThrow(() -> new RuntimeException("Trainee not found"))
                .currentTrainer();
        return modelMapper.map(currentTrainer, DefaultTrainerResponse.class);
    }

    @GetMapping("/{traineeId}/mentorships/current")
    public MentorshipResponse getCurrentMentorship(@PathVariable long traineeId) {
        Mentorship currentMentorship = traineeRepository.findById(traineeId)
                .orElseThrow(() -> new RuntimeException("Trainee not found"))
                .currentMentorship();
        return modelMapper.map(currentMentorship, DefaultMentorshipResponse.class);
    }

}
