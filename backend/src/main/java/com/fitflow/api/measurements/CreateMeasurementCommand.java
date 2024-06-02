package com.fitflow.api.measurements;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
