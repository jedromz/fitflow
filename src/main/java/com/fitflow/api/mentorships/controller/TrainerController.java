package com.fitflow.api.mentorships.controller;

import com.fitflow.api.mentorships.model.Trainee;
import com.fitflow.api.mentorships.service.MentorshipService;
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

    @GetMapping("/{trainerId}/mentorships")
    public List<MentorshipResponse> getMentorship(@PathVariable long trainerId) {
        return mentorshipService.findTrainersMentorships(trainerId).stream()
                .toList();
    }

    @GetMapping("/{trainerId}/trainees")
    public List<TraineeResponse> getTrainees(@PathVariable long trainerId) {
        return mentorshipService.findTrainersTrainees(trainerId).stream()
                .toList();
    }
}
