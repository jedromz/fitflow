package com.fitflow.api.measurements;

import com.fitflow.api.mentorships.model.Mentorship;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MeasurementRepository extends JpaRepository<MeasurementRecord, Long> {


    List<MeasurementResponse> findDistinctByTrainee_Id(Long id);
}
