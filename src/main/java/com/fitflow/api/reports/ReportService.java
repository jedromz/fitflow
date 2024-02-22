package com.fitflow.api.reports;

import com.fitflow.api.mentorships.repository.TraineeRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@AllArgsConstructor
public class ReportService {
    private final TraineeRepository traineeRepository;
    private final ReportRepository reportRepository;
    private final ModelMapper modelMapper;
    public Report createReport(CreateReportCommand command, long traineeId) {
        var trainee = traineeRepository.findById(traineeId)
                .orElseThrow(() -> new IllegalArgumentException("Trainee not found"));
        var trainer = trainee.currentTrainer();

        Report report = modelMapper.map(command, Report.class);
        report.setTrainee(trainee);
        report.setTrainer(trainer);

        return reportRepository.save(report);
    }

    public List<Report> getReports(long trainerId) {
        var trainer = traineeRepository.findById(trainerId)
                .orElseThrow(() -> new IllegalArgumentException("Trainee not found"))
                .currentTrainer();

        return reportRepository.findAllByTrainer(trainer);
    }
}
