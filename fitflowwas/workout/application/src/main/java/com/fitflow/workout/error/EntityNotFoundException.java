package com.fitflow.workout.error;

public class EntityNotFoundException extends Exception {

    private final String entityName;
    private final String fieldName;
    private final String fieldValue;

    public EntityNotFoundException(String entityName, String fieldName, String fieldValue) {
        this.entityName = entityName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getEntityName() {
        return entityName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getFieldValue() {
        return fieldValue;
    }
}
