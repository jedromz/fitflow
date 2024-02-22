package com.fitflow.api.reports;

import com.fitflow.api.mentorships.model.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReportRepository extends JpaRepository<Report, Long> {
    List<Report> findAllByTrainer(Trainer trainer);
}
