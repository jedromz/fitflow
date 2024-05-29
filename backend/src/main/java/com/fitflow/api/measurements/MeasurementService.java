package com.fitflow.api.measurements;

import com.fitflow.api.mentorships.model.Trainee;
import com.fitflow.api.mentorships.repository.TraineeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
public class MeasurementService {

    private final MeasurementRepository measurementRepository;
    private final TraineeRepository traineeRepository;

    public MeasurementService(MeasurementRepository measurementRepository, TraineeRepository traineeRepository) {
        this.measurementRepository = measurementRepository;
        this.traineeRepository = traineeRepository;
    }

    public List<MeasurementResponse> findTraineesMeasurements(long traineeId) {
        return measurementRepository.findDistinctByTrainee_Id(traineeId);
    }

    public List<MeasurementRecord> createMeasurements(long traineeId, List<MeasurementDetail> measurements) {
        Trainee trainee = traineeRepository.findById(traineeId).orElseThrow();
        List<MeasurementRecord> savedRecords = new ArrayList<>();

        for (MeasurementDetail detail : measurements) {
            MeasurementRecord record = new MeasurementRecord();
            record.setBodyPart(detail.getBodyPart());
            record.setMeasurement(detail.getMeasurement());
            record.setTrainee(trainee);
            savedRecords.add(measurementRepository.save(record));
        }

        return savedRecords;
    }
}
