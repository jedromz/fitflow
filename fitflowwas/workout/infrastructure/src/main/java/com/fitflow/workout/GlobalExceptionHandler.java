package com.fitflow.workout;

import com.fitflow.workout.error.EntityNotFoundException;
import lombok.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity handleEntityNotFoundException(EntityNotFoundException exc) {
        return new ResponseEntity(new NotFoundDto(exc.getEntityName(), exc.getFieldName(), exc.getFieldValue()), NOT_FOUND);
    }

    @Value
    class NotFoundDto {
        private String entityName;
        private String field;
        private String fieldValue;
    }
}
