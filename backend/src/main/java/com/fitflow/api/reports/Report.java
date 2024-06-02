package com.fitflow.api.reports;

import com.fitflow.api.base.BaseEntity;
import com.fitflow.api.mentorships.model.Trainee;
import com.fitflow.api.mentorships.model.Trainer;
import com.fitflow.api.photos.Photo;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Report extends BaseEntity {
    @ManyToOne
    private Trainee trainee;
    @ManyToOne
    private Trainer trainer;
    private String title;
    private String content;
    private LocalDate date;
    @OneToMany(mappedBy = "report")
    private final List<Comment> comments = new ArrayList<>();
    @OneToMany(mappedBy = "report")
    private final List<Photo> photos = new ArrayList<>();
}
