package com.fitflow.api.reports;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    @PostMapping("/trainee/{traineeId}/report")
    public void createReport(@RequestBody CreateReportCommand command, @PathVariable long traineeId) {
        reportService.createReport(command,traineeId);
    }
}
