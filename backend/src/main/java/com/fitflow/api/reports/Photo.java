package com.fitflow.api.reports;

import com.fitflow.api.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Photo extends BaseEntity {
    private String path;
    private String description;

    @ManyToOne
    private Report report;
}
