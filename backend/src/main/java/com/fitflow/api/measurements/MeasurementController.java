package com.fitflow.api.measurements;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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

}
