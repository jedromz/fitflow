package com.fitflow.api.mentorships.service;

import com.fitflow.api.mentorships.controller.TraineeResponse;
import com.fitflow.api.mentorships.dto.CreateMentorshipRequest;
import com.fitflow.api.mentorships.dto.MentorshipResponse;
import com.fitflow.api.mentorships.model.Mentorship;
import com.fitflow.api.mentorships.model.Trainee;
import com.fitflow.api.mentorships.repository.MentorshipRepository;
import com.fitflow.api.mentorships.repository.TraineeRepository;
import com.fitflow.api.mentorships.repository.TrainerRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MentorshipService {

    private final TrainerRepository trainerRepository;
    private final TraineeRepository traineeRepository;
    private final MentorshipRepository mentorshipRepository;
    private final ModelMapper modelMapper;

    public Mentorship createMentorship(CreateMentorshipRequest mentorshipRequest) {
        if (mentorshipRequest.getType().equals("existing_trainee")) {
            final var trainer = trainerRepository.findById(mentorshipRequest.getTrainerId())
                    .orElseThrow(() -> new RuntimeException("Trainer not found"));
            final var trainee = traineeRepository.findByEmail(mentorshipRequest.getTraineeEmail())
                    .orElseThrow(() -> new RuntimeException("Trainee not found"));
            final var mentorship = modelMapper.map(mentorshipRequest, Mentorship.class);
            mentorship.setTrainer(trainer);
            mentorship.setTrainee(trainee);
            return mentorshipRepository.save(mentorship);
        } else {
            final var trainer = trainerRepository.findById(mentorshipRequest.getTrainerId())
                    .orElseThrow(() -> new RuntimeException("Trainer not found"));
            Trainee trainee = new Trainee();
            trainee.setName(mentorshipRequest.getTraineeName());
            trainee.setEmail(mentorshipRequest.getTraineeEmail());
            trainee = traineeRepository.save(trainee);
            final var mentorship = modelMapper.map(mentorshipRequest, Mentorship.class);
            mentorship.setTrainer(trainer);
            mentorship.setTrainee(trainee);
            return mentorshipRepository.save(mentorship);
        }
    }

    public List<MentorshipResponse> findTrainersMentorships(Long trainerId) {
        return mentorshipRepository.findAllByTrainerId(trainerId);
    }

    public List<TraineeResponse> findTrainersTrainees(long trainerId) {
        var trainer = trainerRepository.findById(trainerId)
                .orElseThrow(() -> new RuntimeException("Trainer not found"));
        return traineeRepository.findByTrainer(trainer)
                .stream()
                .distinct()
                .toList();
    }
}