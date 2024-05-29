package com.fitflow.api.measurements;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateMeasurementCommand {
    private List<MeasurementDetail> measurements;

}

@Getter
@Setter
class MeasurementDetail {
    private String date;
    private BodyPart bodyPart;
    private MeasurementCommand measurement;
}

@Getter
@Setter
class MeasurementCommand {
    private float measurementValue;
    private String unit;
}
