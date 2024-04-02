package com.fitflow.api.mentorships.controller;

import com.fitflow.api.mentorships.dto.MentorshipResponse;
import com.fitflow.api.mentorships.repository.TrainerRepository;
import com.fitflow.api.mentorships.service.MentorshipService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/trainers")
@RequiredArgsConstructor
public class TrainerController {

    private final MentorshipService mentorshipService;
    private final TrainerRepository trainerRepository;

    @GetMapping("/{trainerId}/mentorships")
    @Operation(summary = "Get mentorships by trainer id")
    public List<MentorshipResponse> getMentorship(@PathVariable long trainerId) {
        return mentorshipService.findTrainersMentorships(trainerId);
    }

    @GetMapping("/{trainerId}/trainees")
    @Operation(summary = "Get trainees by trainer id")
    public List<TraineeResponse> getTrainees(@PathVariable long trainerId) {
        return mentorshipService.findTrainersTrainees(trainerId).stream()
                .toList();
    }

    @GetMapping("/{trainerId}")
    @Operation(summary = "Get trainer by id")
    public TrainerResponse get(@PathVariable long trainerId) {
        return trainerRepository.findById(trainerId, TrainerResponse.class)
                .orElseThrow(() -> new RuntimeException("Trainer not found"));
    }
}
