package com.fitflow.api;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.fitflow.api.mentorships.model.Mentorship;
import com.fitflow.api.mentorships.model.Trainee;
import com.fitflow.api.mentorships.model.Trainer;
import com.fitflow.api.workouts.model.Progression;
import com.fitflow.api.workouts.model.WorkoutPlan;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TraineeTest {

    @Mock
    private Progression progression1;

    @Mock
    private Progression progression2;

    @Mock
    private WorkoutPlan workoutPlan1;

    @Mock
    private WorkoutPlan workoutPlan2;

    @Mock
    private Mentorship mentorship1;

    @Mock
    private Mentorship mentorship2;

    @Mock
    private Trainer trainer;

    private Trainee trainee;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        trainee = new Trainee();

        // Set up mock data for progressions
        when(progression1.getExercise().getName()).thenReturn("Squat");
        when(progression1.getDate()).thenReturn(LocalDate.of(2022, 1, 1));
        when(progression1.getSets()).thenReturn(3);
        when(progression1.getReps()).thenReturn(10);
        when(progression1.getWeight()).thenReturn((int) 100.0);

        when(progression2.getExercise().getName()).thenReturn("Squat");
        when(progression2.getDate()).thenReturn(LocalDate.of(2022, 2, 1));
        when(progression2.getSets()).thenReturn(4);
        when(progression2.getReps()).thenReturn(8);
        swhen(progression2.getWeight()).thenReturn((int) 120.0);

        trainee.getProgressions().add(progression1);
        trainee.getProgressions().add(progression2);

        // Set up mock data for workout plans
        when(workoutPlan1.getFromDate()).thenReturn(LocalDate.of(2022, 1, 1));
        when(workoutPlan1.getToDate()).thenReturn(LocalDate.of(2022, 6, 1));

        when(workoutPlan2.getFromDate()).thenReturn(LocalDate.of(2022, 7, 1));
        when(workoutPlan2.getToDate()).thenReturn(LocalDate.of(2022, 12, 1));

        trainee.getWorkoutPlans().add(workoutPlan1);
        trainee.getWorkoutPlans().add(workoutPlan2);

        // Set up mock data for mentorships
        when(mentorship1.getFromDate()).thenReturn(LocalDate.of(2022, 1, 1));
        when(mentorship1.getToDate()).thenReturn(LocalDate.of(2022, 6, 1));
        when(mentorship1.getTrainer()).thenReturn(trainer);

        when(mentorship2.getFromDate()).thenReturn(LocalDate.of(2022, 7, 1));
        when(mentorship2.getToDate()).thenReturn(LocalDate.of(2022, 12, 1));
        when(mentorship2.getTrainer()).thenReturn(trainer);

        trainee.getMentorships().add(mentorship1);
        trainee.getMentorships().add(mentorship2);
    }

    @Test
    public void testLastProgression() {
        Map<String, String> result = trainee.lastProgression("Squat");
        assertEquals("4", result.get("sets"));
        assertEquals("8", result.get("reps"));
        assertEquals("120.0", result.get("weight"));
    }

    @Test
    public void testCurrentTrainer() {
        Trainer currentTrainer = trainee.currentTrainer();
        assertEquals(trainer, currentTrainer);
    }

    @Test
    public void testCurrentMentorship() {
        Mentorship currentMentorship = trainee.currentMentorship();
        assertEquals(mentorship2, currentMentorship);
    }

    @Test
    public void testCurrentTrainingPlan() {
        WorkoutPlan currentWorkoutPlan = trainee.currentTrainingPlan();
        assertEquals(workoutPlan2, currentWorkoutPlan);
    }
}
