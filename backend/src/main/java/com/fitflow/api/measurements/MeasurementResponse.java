package com.fitflow.api.measurements;

import java.time.LocalDate;

public interface MeasurementResponse {

    public Long getId();

    public BodyPart getBodyPart();

    public LocalDate getDate();

    public Measurement getMeasurement();
}
