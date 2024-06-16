package com.fitflow.api.reports;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateCommentCommand {
    private long traineeId;
    private long trainerId;
    private String text;
    private long reportId;

}
