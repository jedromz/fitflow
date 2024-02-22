package com.fitflow.api.mentorships.repository;

import com.fitflow.api.mentorships.model.Trainee;
import com.fitflow.api.mentorships.model.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TraineeRepository extends JpaRepository<Trainee, Long> {


    @Query("select t from Trainee t inner join t.mentorships mentorships where mentorships.trainer = ?1")
    List<Trainee> findByTrainer(Trainer trainer);
}

