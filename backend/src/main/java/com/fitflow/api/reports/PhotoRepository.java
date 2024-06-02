package com.fitflow.api.reports;

import com.fitflow.api.photos.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepository extends JpaRepository<Photo, Long> {
}
