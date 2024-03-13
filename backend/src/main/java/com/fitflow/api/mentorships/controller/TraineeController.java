package com.fitflow.api.mentorships.controller;

import com.fitflow.api.mentorships.repository.TraineeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/trainees")
@RequiredArgsConstructor
public class TraineeController {

    private final TraineeRepository traineeRepository;
    @GetMapping("/{traineeId}")
    public TraineeResponse get(@PathVariable long traineeId) {
        return traineeRepository.findById(traineeId, TraineeResponse.class)
                .orElseThrow(() -> new RuntimeException("Trainee not found"));
    }

}
