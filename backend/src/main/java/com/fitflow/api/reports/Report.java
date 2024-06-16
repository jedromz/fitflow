package com.fitflow.api.reports;

import com.fitflow.api.base.BaseEntity;
import com.fitflow.api.mentorships.model.Trainee;
import com.fitflow.api.mentorships.model.Trainer;
import com.fitflow.api.photos.Photo;
import jakarta.persistence.*;
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
    @Lob
    private String content;
    private LocalDate date;
    @OneToMany(mappedBy = "report", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private final List<Comment> comments = new ArrayList<>();
    @OneToMany(mappedBy = "report", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private final List<Photo> photos = new ArrayList<>();
}
