package com.fitflow.api.reports;

import com.fitflow.api.mentorships.repository.TraineeRepository;
import com.fitflow.api.mentorships.repository.TrainerRepository;
import com.fitflow.api.minio.MinioStorageService;
import com.fitflow.api.photos.Photo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReportService {
    private final TraineeRepository traineeRepository;
    private final TrainerRepository trainerRepository;
    private final ReportRepository reportRepository;
    private final PhotoRepository photoRepository;
    private final MinioStorageService minioStorageService;
    private final ModelMapper modelMapper;


    @Transactional
    public Report createReport(CreateReportCommand command, long traineeId, List<MultipartFile> photoFiles) {
        var trainee = traineeRepository.findById(traineeId)
                .orElseThrow(() -> new IllegalArgumentException("Trainee not found"));
        var trainer = trainee.currentTrainer();

        Report report = modelMapper.map(command, Report.class);
        report.setTrainee(trainee);
        report.setTrainer(trainer);

        List<Photo> photos = photoFiles.stream()
                .map(file -> {
                    String path = minioStorageService.store(file);
                    Photo photo = new Photo();
                    photo.setPath(path);
                    photo.setReport(report);
                    return photo;
                })
                .collect(Collectors.toList());

        report.getPhotos().addAll(photos);
        photoRepository.saveAll(photos);

        return reportRepository.save(report);
    }

    public List<Report> getReports(long trainerId) {
        var trainer = trainerRepository.findById(trainerId)
                .orElseThrow(() -> new IllegalArgumentException("Trainee not found"));

        return reportRepository.findAllByTrainer(trainer);
    }

    public List<Report> getTraineeReports(long traineeId) {
        var trainee = traineeRepository.findById(traineeId)
                .orElseThrow(() -> new IllegalArgumentException("Trainee not found"));

        return reportRepository.findAllByTrainee(trainee);
    }

    @Transactional
    public void addComment(CreateCommentCommand command, long reportId) {
        var report = reportRepository.findById(reportId)
                .orElseThrow(() -> new IllegalArgumentException("Report not found"));
        Comment comment = new Comment();
        if (command.getTraineeId() != 0) {
            var trainee = traineeRepository.findByUser_Id(command.getTraineeId())
                    .orElseThrow(() -> new IllegalArgumentException("Trainee not found"));
            comment.setTrainee(trainee);
        }

        if (command.getTrainerId() != 0) {
            var trainer = trainerRepository.findByUser_Id(command.getTrainerId())
                    .orElseThrow(() -> new IllegalArgumentException("Trainer not found"));
            comment.setTrainer(trainer);
        }

        comment.setReport(report);
        comment.setText(command.getText());

        report.getComments().add(comment);
        reportRepository.save(report);
    }

    public List<Comment> getComments(long reportId) {
        var report = reportRepository.findById(reportId)
                .orElseThrow(() -> new IllegalArgumentException("Report not found"));

        return report.getComments();
    }
}
