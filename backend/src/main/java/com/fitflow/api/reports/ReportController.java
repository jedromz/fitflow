package com.fitflow.api.reports;

import com.fitflow.api.minio.MinioStorageService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
public class ReportController {

    private final ReportService reportService;
    private final ModelMapper modelMapper;
    private final MinioStorageService minioStorageService;

    public ReportController(ReportService reportService, ModelMapper modelMapper, MinioStorageService minioStorageService) {
        this.reportService = reportService;
        this.modelMapper = modelMapper;
        this.minioStorageService = minioStorageService;
    }

    @PostMapping("/trainees/{traineeId}/report")
    public ResponseEntity<ReportDto> createReport(
            @RequestParam("files") List<MultipartFile> files,
            @RequestParam("title") String title,
            @RequestParam("content") String content,
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            @PathVariable long traineeId) {

        CreateReportCommand command = new CreateReportCommand(title, content, date);

        ReportDto reportDto = modelMapper.map(reportService.createReport(command, traineeId, files), ReportDto.class);
        return ResponseEntity.ok(reportDto);
    }


    @GetMapping("/trainer/{trainerId}/reports")
    public ResponseEntity<List<ReportDto>> getReports(@PathVariable long trainerId) {
        return ResponseEntity.ok(reportService.getReports(trainerId).stream()
                .map(report -> modelMapper.map(report, ReportDto.class))
                .collect(toList()));
    }

    @GetMapping("/trainees/{traineeId}/reports")
    public ResponseEntity<List<ReportDto>> getTraineeReports(@PathVariable long traineeId) {
        return ResponseEntity.ok(reportService.getTraineeReports(traineeId).stream()
                .map(report -> modelMapper.map(report, ReportDto.class))
                .collect(toList()));
    }

    @GetMapping("/objects")
    public List<String> listFileUrls() {
        return minioStorageService.listObjectUrls();
    }

    @GetMapping("/objects/{path}")
    public String getFileUrl(@PathVariable String path) {
        return minioStorageService.getObjectByPath(path);
    }

    @PostMapping("/reports/comment")
    public ResponseEntity<CommentDto> addComment(@RequestBody CreateCommentCommand command) {
        reportService.addComment(command, command.getReportId());
        return null;
    }

    @GetMapping("/reports/{reportId}/comments")
    public ResponseEntity<List<CommentDto>> getComments(@PathVariable long reportId) {
        return ResponseEntity.ok(reportService.getComments(reportId).stream()
                .map(comment -> modelMapper.map(comment, CommentDto.class))
                .collect(toList()));
    }
}
