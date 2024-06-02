package com.fitflow.api.photos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PhotosRepository extends JpaRepository<Photo, Long> {


    @Query("select distinct p from Photo p where p.report.trainee.id = ?1")
    List<PhotoUrl> findAllByTraineeId(Long id);
}
