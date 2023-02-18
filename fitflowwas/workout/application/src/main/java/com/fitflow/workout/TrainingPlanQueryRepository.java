package com.fitflow.workout;

import com.fitflow.workout.dto.TrainingPlanDto;

import java.util.Optional;

public interface TrainingPlanQueryRepository {
    Optional<TrainingPlanDto> findDtoById(Integer id);
}
