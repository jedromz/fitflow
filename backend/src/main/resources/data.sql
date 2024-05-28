-- Insert trainers
INSERT INTO trainer (id, name, email, password, phone) VALUES
    (1, 'John Doe', 'johndoe@example.com', 'encryptedpassword', '1234567890');

-- Insert trainees
INSERT INTO trainee (id, name, email) VALUES
    (1, 'Jane Doe', 'janedoe@example.com'),
    (2, 'Alice Smith', 'alice@smith.com'),
    (3, 'Bob Johnson', 'bob@johnson.com'),
    (4, 'Charlie Brown', 'charlie@brown.com');

-- Insert mentorships
INSERT INTO mentorship (id, start_date, end_date,price, trainer_id, trainee_id) VALUES
    (1000, '2024-01-01', '2024-06-30',300.0, 1, 1),
     (1001, '2025-01-01', '2025-06-30',300.0, 1, 1),
     (1002, '2024-05-05', '2025-10-30',300.0, 1, 1),
    (2000, '2024-01-01', '2024-06-30',300.0, 1, 2),
    (3000, '2024-01-01', '2024-06-30',300.0, 1, 3),
    (4000, '2024-01-01', '2024-06-30',300.0, 1, 4);

-- Insert workout plans
INSERT INTO workout_plan (id, name, description, from_date, to_date, trainee_id, trainer_id) VALUES
    (1000, 'Beginner Plan', 'A plan for beginners.', '2024-01-01', '2024-04-01', 1, 1);

-- Insert workouts
INSERT INTO workout (id, date, workout_plan_id) VALUES
    (1000, '2024-01-02', 1000);

-- Insert exercises into the dictionary (no sets, reps, or workout_id here)
INSERT INTO exercise (id, name,description,category) VALUES
                                    (1000, 'Push-ups','Push-ups are a great exercise for the upper body.', 'Upper Body'),
                                    (2000, 'Squats','Squats are a great exercise for the lower body.', 'Lower Body'),
                                    (3000, 'Plank','Planks are a great exercise for the core.', 'Core');

-- Insert workout exercises linking workouts to exercises and defining sets and reps
INSERT INTO workout_exercise (id, workout_id, exercise_id, sets, reps) VALUES
                                                                           (1000, 1000, 1000, 3, 12), -- Linking Push-ups to Workout 1 with 3 sets of 12 reps
                                                                           (2000, 1000, 2000, 3000, 15); -- Linking Squats to Workout 1 with 3 sets of 15 reps

INSERT INTO report (id, date, trainee_id, trainer_id,title,content) VALUES
    (1000, '2024-01-02', 1,  1, 'Report 1','Content 1'),
    (2000, '2024-01-03', 1,  1, 'Report 2','Content 2'),
    (3000, '2024-01-04', 1,  1,'Report 3','Content 3'),
    (4000, '2024-01-05', 1,  1, 'Report 4','Content 4');

 --Insert into measurements

 INSERT INTO measurement_record (id,body_part, measurement_value, unit, date, trainee_id)
 VALUES (1,'ABS', 10.5, 'CM', '2024-05-24', 1);
