package com.fitflow.api.workouts.controller;

import com.fitflow.api.mentorships.repository.TraineeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class ProgressionController {

    private final ProgressionService progressionService;
    private final TraineeRepository traineeRepository;

    @PostMapping("/trainees/{traineeId}/progressions")
    public void addProgression(@PathVariable Long traineeId, @RequestBody ProgressionRequest request) {
        progressionService.addProgression(traineeId,request);
    }

    @GetMapping("/trainees/{traineeId}/progressions/{exerciseName}")
    public Map<String, String> getProgression(@PathVariable Long traineeId, @PathVariable String exerciseName) {
        return traineeRepository.findById(traineeId)
                .orElseThrow()
                .lastProgression(exerciseName);
    }

}
