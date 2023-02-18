package com.fitflow.report.domain;

import java.util.ArrayList;
import java.util.List;

class Report {

    int traineeId;
    int trainerId;
    List<Question> questions = new ArrayList<>();
    List<Comment> comments = new ArrayList<>();
}
