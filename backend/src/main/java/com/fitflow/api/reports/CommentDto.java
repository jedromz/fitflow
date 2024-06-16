package com.fitflow.api.reports;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CommentDto {
    private long id;
    private String text;
    private String trainerName;
    private String trainerEmail;
    private String traineeName;
    private String traineeEmail;
    private String createdAt;

    public CommentDto(Long id, String text) {
        this.id = id;
        this.text = text;
    }
}
