package com.fitflow.api.measurements;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeasurementService {

    private final MeasurementRepository measurementRepository;

    public MeasurementService(MeasurementRepository measurementRepository) {
        this.measurementRepository = measurementRepository;
    }


    public List<MeasurementResponse> findTraineesMeasurements(long traineeId) {
        return measurementRepository.findDistinctByTrainee_Id(traineeId);
    }
}
