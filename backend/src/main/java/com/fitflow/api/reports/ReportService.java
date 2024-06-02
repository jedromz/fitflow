package com.fitflow.api.reports;

import com.fitflow.api.mentorships.repository.TraineeRepository;
import com.fitflow.api.minio.MinioStorageService;
import com.fitflow.api.photos.Photo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportService {
    private final TraineeRepository traineeRepository;
    private final ReportRepository reportRepository;
    private final PhotoRepository photoRepository;
    private final MinioStorageService minioStorageService;
    private final ModelMapper modelMapper;

    public ReportService(TraineeRepository traineeRepository, ReportRepository reportRepository, PhotoRepository photoRepository, MinioStorageService minioStorageService, ModelMapper modelMapper) {
        this.traineeRepository = traineeRepository;
        this.reportRepository = reportRepository;
        this.photoRepository = photoRepository;
        this.minioStorageService = minioStorageService;
        this.modelMapper = modelMapper;
    }

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
        var trainer = traineeRepository.findById(trainerId)
                .orElseThrow(() -> new IllegalArgumentException("Trainee not found"))
                .currentTrainer();

        return reportRepository.findAllByTrainer(trainer);
    }

    public List<Report> getTraineeReports(long traineeId) {
        var trainee = traineeRepository.findById(traineeId)
                .orElseThrow(() -> new IllegalArgumentException("Trainee not found"));

        return reportRepository.findAllByTrainee(trainee);
    }
}
