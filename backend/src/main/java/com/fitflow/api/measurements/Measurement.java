package com.fitflow.api.measurements;


import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Embeddable
public class Measurement {
    private double measurementValue;
    @Enumerated(EnumType.STRING)
    private MeasurementUnit unit;

    // Constructors, getters, and setters
    public Measurement() {
    }

    public Measurement(double value, MeasurementUnit unit) {
        this.measurementValue = value;
        this.unit = unit;
    }

    public double getMeasurementValue() {
        return measurementValue;
    }

    public void setMeasurementValue(double measurementValue) {
        this.measurementValue = measurementValue;
    }

    public MeasurementUnit getUnit() {
        return unit;
    }

    public void setUnit(MeasurementUnit unit) {
        this.unit = unit;
    }
}
