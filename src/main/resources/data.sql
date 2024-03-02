-- Insert trainers
INSERT INTO trainer (id, name, email, password, phone) VALUES
    (1, 'John Doe', 'johndoe@example.com', 'encryptedpassword', '1234567890');

-- Insert trainees
INSERT INTO trainee (id, name, email) VALUES
    (1, 'Jane Doe', 'janedoe@example.com');

-- Insert mentorships
INSERT INTO mentorship (id, start_date, end_date,price, trainer_id, trainee_id) VALUES
    (1, '2024-01-01', '2024-06-30',300.0, 1, 1),
    (2, '2024-01-01', '2024-06-30',300.0, 1, 1),
    (3, '2024-01-01', '2024-06-30',300.0, 1, 1),
    (4, '2024-01-01', '2024-06-30',300.0, 1, 1);

-- Insert workout plans
INSERT INTO workout_plan (id, name, description, from_date, to_date, trainee_id, trainer_id) VALUES
    (1, 'Beginner Plan', 'A plan for beginners.', '2024-01-01', '2024-04-01', 1, 1);

-- Insert workouts
INSERT INTO workout (id, date, workout_plan_id) VALUES
    (1, '2024-01-02', 1);

-- Insert exercises into the dictionary (no sets, reps, or workout_id here)
INSERT INTO exercise (id, name) VALUES
                                    (1, 'Push-ups'),
                                    (2, 'Squats');

-- Insert workout exercises linking workouts to exercises and defining sets and reps
INSERT INTO workout_exercise (id, workout_id, exercise_id, sets, reps) VALUES
                                                                           (1, 1, 1, 3, 12), -- Linking Push-ups to Workout 1 with 3 sets of 12 reps
                                                                           (2, 1, 2, 3, 15); -- Linking Squats to Workout 1 with 3 sets of 15 reps
