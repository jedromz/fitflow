package com.fitflow.api;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.fitflow.api.mentorships.model.Trainee;
import com.fitflow.api.mentorships.model.Trainer;
import com.fitflow.api.mentorships.repository.TraineeRepository;
import com.fitflow.api.mentorships.repository.TrainerRepository;
import com.fitflow.api.minio.MinioStorageService;
import com.fitflow.api.photos.Photo;
import com.fitflow.api.reports.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ReportServiceTest {

    @Mock
    private TraineeRepository traineeRepository;

    @Mock
    private TrainerRepository trainerRepository;

    @Mock
    private ReportRepository reportRepository;

    @Mock
    private PhotoRepository photoRepository;

    @Mock
    private MinioStorageService minioStorageService;

    @Mock
    private ModelMapper modelMapper;

    private ReportService reportService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        reportService = new ReportService(traineeRepository, trainerRepository, reportRepository, photoRepository, minioStorageService, modelMapper);
    }

    @Test
    public void testCreateReport() {
        CreateReportCommand command = new CreateReportCommand();
        long traineeId = 1L;
        MultipartFile file = mock(MultipartFile.class);
        List<MultipartFile> files = List.of(file);

        Trainee trainee = mock(Trainee.class);
        Trainer trainer = mock(Trainer.class);
        Report report = new Report();
        Photo photo = new Photo();
        String filePath = "path/to/file";

        when(traineeRepository.findById(traineeId)).thenReturn(Optional.of(trainee));
        when(trainee.currentTrainer()).thenReturn(trainer);
        when(modelMapper.map(command, Report.class)).thenReturn(report);
        when(minioStorageService.store(file)).thenReturn(filePath);
        when(photoRepository.saveAll(anyList())).thenReturn(Collections.singletonList(photo));
        when(reportRepository.save(report)).thenReturn(report);

        Report result = reportService.createReport(command, traineeId, files);

        assertEquals(report, result);
        verify(traineeRepository).findById(traineeId);
        verify(trainee).currentTrainer();
        verify(modelMapper).map(command, Report.class);
        verify(minioStorageService).store(file);
        verify(photoRepository).saveAll(anyList());
        verify(reportRepository).save(report);
    }

    @Test
    public void testGetReports() {
        long trainerId = 1L;
        Trainer trainer = mock(Trainer.class);
        List<Report> reports = List.of(new Report());

        when(trainerRepository.findById(trainerId)).thenReturn(Optional.of(trainer));
        when(reportRepository.findAllByTrainer(trainer)).thenReturn(reports);

        List<Report> result = reportService.getReports(trainerId);

        assertEquals(reports, result);
        verify(trainerRepository).findById(trainerId);
        verify(reportRepository).findAllByTrainer(trainer);
    }

    @Test
    public void testGetTraineeReports() {
        long traineeId = 1L;
        Trainee trainee = mock(Trainee.class);
        List<Report> reports = List.of(new Report());

        when(traineeRepository.findById(traineeId)).thenReturn(Optional.of(trainee));
        when(reportRepository.findAllByTrainee(trainee)).thenReturn(reports);

        List<Report> result = reportService.getTraineeReports(traineeId);

        assertEquals(reports, result);
        verify(traineeRepository).findById(traineeId);
        verify(reportRepository).findAllByTrainee(trainee);
    }

    @Test
    public void testAddComment() {
        CreateCommentCommand command = new CreateCommentCommand();
        command.setText("Test comment");
        command.setTraineeId(1L);
        command.setTrainerId(2L);

        long reportId = 1L;
        Report report = new Report();
        Trainee trainee = new Trainee();
        Trainer trainer = new Trainer();

        when(reportRepository.findById(reportId)).thenReturn(Optional.of(report));
        when(traineeRepository.findByUser_Id(1L)).thenReturn(Optional.of(trainee));
        when(trainerRepository.findByUser_Id(2L)).thenReturn(Optional.of(trainer));

        reportService.addComment(command, reportId);

        ArgumentCaptor<Comment> commentCaptor = ArgumentCaptor.forClass(Comment.class);
        verify(reportRepository).save(report);
        verify(report).getComments().add(commentCaptor.capture());

        Comment capturedComment = commentCaptor.getValue();
        assertEquals("Test comment", capturedComment.getText());
        assertEquals(trainee, capturedComment.getTrainee());
        assertEquals(trainer, capturedComment.getTrainer());
        assertEquals(report, capturedComment.getReport());
    }

    @Test
    public void testGetComments() {
        long reportId = 1L;
        Report report = mock(Report.class);
        List<Comment> comments = List.of(new Comment());

        when(reportRepository.findById(reportId)).thenReturn(Optional.of(report));
        when(report.getComments()).thenReturn(comments);

        List<Comment> result = reportService.getComments(reportId);

        assertEquals(comments, result);
        verify(reportRepository).findById(reportId);
        verify(report).getComments();
    }
}
