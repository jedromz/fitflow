package com.fitflow.api.measurements;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MeasurementController {

    private final MeasurementService measurementService;

    public MeasurementController(MeasurementService measurementService) {
        this.measurementService = measurementService;
    }


    //GetMeasurements by trainee id
    @GetMapping("/trainees/{traineeId}/measurements")
    public List<MeasurementResponse> getTraineesMeasurements(@PathVariable long traineeId) {
        return measurementService.findTraineesMeasurements(traineeId);
    }

    @PostMapping("/trainees/{traineeId}/measurements")
    public void createMeasurement(@PathVariable long traineeId, @RequestBody CreateMeasurementCommand command) {
        measurementService.createMeasurements(traineeId, command.getMeasurements());
    }

}
