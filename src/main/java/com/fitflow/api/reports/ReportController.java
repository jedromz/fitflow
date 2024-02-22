package com.fitflow.api.reports;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;
    private final ModelMapper modelMapper;

    @PostMapping("/trainee/{traineeId}/report")
    public ResponseEntity<ReportDto> createReport(@RequestBody CreateReportCommand command, @PathVariable long traineeId) {
        return ResponseEntity.ok(modelMapper.map(reportService.createReport(command, traineeId), ReportDto.class));
    }

    @GetMapping("/trainer/{trainerId}/reports")
    public ResponseEntity<List<ReportDto>> getReports(@PathVariable long trainerId) {
        return ResponseEntity.ok(reportService.getReports(trainerId).stream()
                .map(report -> modelMapper.map(report, ReportDto.class))
                .collect(toList()));
    }
}
