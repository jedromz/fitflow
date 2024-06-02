package com.fitflow.api.measurements;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MeasurementCommand {
    private float measurementValue;
    private String unit;
}