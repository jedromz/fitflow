package com.fitflow.api;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.fitflow.api.mentorships.controller.TraineeResponse;
import com.fitflow.api.mentorships.dto.CreateMentorshipRequest;
import com.fitflow.api.mentorships.dto.DefaultMentorshipResponse;
import com.fitflow.api.mentorships.dto.MentorshipResponse;
import com.fitflow.api.mentorships.model.Mentorship;
import com.fitflow.api.mentorships.model.Trainee;
import com.fitflow.api.mentorships.model.Trainer;
import com.fitflow.api.mentorships.repository.MentorshipRepository;
import com.fitflow.api.mentorships.repository.TraineeRepository;
import com.fitflow.api.mentorships.repository.TrainerRepository;
import com.fitflow.api.mentorships.service.MentorshipService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;

public class MentorshipServiceTest {

    @Mock
    private TrainerRepository trainerRepository;

    @Mock
    private TraineeRepository traineeRepository;

    @Mock
    private MentorshipRepository mentorshipRepository;

    @Mock
    private ModelMapper modelMapper;

    private MentorshipService mentorshipService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mentorshipService = new MentorshipService(trainerRepository, traineeRepository, mentorshipRepository, modelMapper);
    }

    @Test
    public void testCreateMentorshipWithExistingTrainee() {
        CreateMentorshipRequest request = new CreateMentorshipRequest();
        request.setType("existing_trainee");
        request.setTrainerId(1L);
        request.setTraineeEmail("existing@example.com");

        Trainer trainer = new Trainer();
        Trainee trainee = new Trainee();
        Mentorship mentorship = new Mentorship();

        when(trainerRepository.findById(1L)).thenReturn(Optional.of(trainer));
        when(traineeRepository.findByEmail("existing@example.com")).thenReturn(Optional.of(trainee));
        when(modelMapper.map(request, Mentorship.class)).thenReturn(mentorship);
        when(mentorshipRepository.save(mentorship)).thenReturn(mentorship);

        Mentorship result = mentorshipService.createMentorship(request);

        assertEquals(mentorship, result);
        verify(trainerRepository).findById(1L);
        verify(traineeRepository).findByEmail("existing@example.com");
        verify(modelMapper).map(request, Mentorship.class);
        verify(mentorshipRepository).save(mentorship);
    }

    @Test
    public void testCreateMentorshipWithNewTrainee() {
        CreateMentorshipRequest request = new CreateMentorshipRequest();
        request.setType("new_trainee");
        request.setTrainerId(1L);
        request.setTraineeName("New Trainee");
        request.setTraineeEmail("new@example.com");

        Trainer trainer = new Trainer();
        Trainee trainee = new Trainee();
        Mentorship mentorship = new Mentorship();

        when(trainerRepository.findById(1L)).thenReturn(Optional.of(trainer));
        when(traineeRepository.save(any(Trainee.class))).thenReturn(trainee);
        when(modelMapper.map(request, Mentorship.class)).thenReturn(mentorship);
        when(mentorshipRepository.save(mentorship)).thenReturn(mentorship);

        Mentorship result = mentorshipService.createMentorship(request);

        assertEquals(mentorship, result);
        verify(trainerRepository).findById(1L);
        verify(traineeRepository).save(any(Trainee.class));
        verify(modelMapper).map(request, Mentorship.class);
        verify(mentorshipRepository).save(mentorship);
    }

    @Test
    public void testFindTrainersMentorships() {
        Long trainerId = 1L;
        List<MentorshipResponse> responses = List.of(new DefaultMentorshipResponse());

        when(mentorshipRepository.findAllByTrainerId(trainerId)).thenReturn(responses);

        List<MentorshipResponse> result = mentorshipService.findTrainersMentorships(trainerId);

        assertEquals(responses, result);
        verify(mentorshipRepository).findAllByTrainerId(trainerId);
    }
}
