package com.fitflow.api.mentorships.repository;

import com.fitflow.api.mentorships.controller.TraineeResponse;
import com.fitflow.api.mentorships.model.Trainee;
import com.fitflow.api.mentorships.model.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TraineeRepository extends JpaRepository<Trainee, Long> {


    @Query("select t from Trainee t inner join t.mentorships mentorships where mentorships.trainer = ?1")
    List<TraineeResponse> findByTrainer(Trainer trainer);


    Optional<TraineeResponse> findById(long traineeId, Class<TraineeResponse> clazz);
}

