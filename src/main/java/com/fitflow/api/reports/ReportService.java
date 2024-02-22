package com.fitflow.api.reports;

import com.fitflow.api.mentorships.repository.TraineeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReportService {
    private final TraineeRepository traineeRepository;
    public void createReport(CreateReportCommand command, long traineeId) {
        var trainee = traineeRepository.findById(traineeId)
                .orElseThrow(() -> new IllegalArgumentException("Trainee not found"));
        var trainer = trainee.currentTrainer();

        System.out.println("OK");
    }
}
