-- Insert trainers
INSERT INTO trainer (id, name, email, password, phone) VALUES
    (1000, 'John Doe', 'johndoe@example.com', 'encryptedpassword', '1234567890');

-- Insert trainees
INSERT INTO trainee (id, name, email, height, weight) VALUES
    (1000, 'Jane Doe', 'janedoe@example.com', 1.65, 60),
    (2000, 'Alice Smith', 'alice@smith.com', 1.70, 65),
    (3000, 'Bob Johnson', 'bob@johnson.com', 1.80, 75),
    (4000, 'Charlie Brown', 'charlie@brown.com', 1.75, 70);


-- Insert mentorships
INSERT INTO mentorship (id, start_date, end_date, price, trainer_id, trainee_id) VALUES
    (1000, '2024-01-01', '2024-06-30', 300.0, 1000, 1000),
    (1001, '2025-01-01', '2025-06-30', 300.0, 1000, 1000),
    (1002, '2024-05-05', '2025-10-30', 300.0, 1000, 1000),
    (2000, '2024-01-01', '2024-06-30', 300.0, 1000, 2000),
    (3000, '2024-01-01', '2024-06-30', 300.0, 1000, 3000),
    (4000, '2024-01-01', '2024-06-30', 300.0, 1000, 4000);

-- Insert workout plans
INSERT INTO workout_plan (id, name, description, from_date, to_date, trainee_id, trainer_id) VALUES
    (1000, 'Beginner Plan', 'A plan for beginners.', '2024-01-01', '2024-04-01', 1000, 1000);

-- Insert workouts
INSERT INTO workout (id, date, workout_plan_id) VALUES
    (1000, '2024-01-02', 1000);

-- Insert exercises into the dictionary (no sets, reps, or workout_id here)
INSERT INTO exercise (id, name, description, category) VALUES
    (4000, 'Lunges', 'Lunges are a great exercise for the legs and glutes.', 'Lower Body'),
    (5000, 'Bicep Curls', 'Bicep Curls are great for strengthening the biceps.', 'Upper Body'),
    (6000, 'Tricep Dips', 'Tricep Dips target the triceps and shoulders.', 'Upper Body'),
    (7000, 'Mountain Climbers', 'Mountain Climbers are great for cardiovascular endurance and core strength.', 'Core'),
    (8000, 'Deadlifts', 'Deadlifts are excellent for building lower back and leg strength.', 'Lower Body'),
    (9000, 'Shoulder Press', 'Shoulder Presses are great for building shoulder and upper back strength.', 'Upper Body'),
    (10000, 'Burpees', 'Burpees are a full-body exercise that builds strength and endurance.', 'Full Body'),
    (11000, 'Leg Raises', 'Leg Raises target the lower abs and hip flexors.', 'Core'),
    (12000, 'Pull-ups', 'Pull-ups are an excellent exercise for the upper back and arms.', 'Upper Body'),
    (13000, 'Russian Twists', 'Russian Twists are great for working the obliques and core.', 'Core'),
    (14000, 'Bench Press', 'Bench Presses are great for building chest and arm strength.', 'Upper Body'),
    (15000, 'Crunches', 'Crunches are effective for strengthening the abdominal muscles.', 'Core'),
    (16000, 'Calf Raises', 'Calf Raises target the calf muscles.', 'Lower Body'),
    (17000, 'Bicycle Crunches', 'Bicycle Crunches work the abs and obliques.', 'Core'),
    (18000, 'Leg Press', 'Leg Presses are great for strengthening the legs.', 'Lower Body'),
    (19000, 'Lat Pulldowns', 'Lat Pulldowns target the upper back and shoulders.', 'Upper Body'),
    (20000, 'Dumbbell Flyes', 'Dumbbell Flyes are great for building chest muscles.', 'Upper Body'),
    (21000, 'Seated Rows', 'Seated Rows strengthen the upper back and shoulders.', 'Upper Body'),
    (22000, 'Box Jumps', 'Box Jumps are great for building explosive leg power.', 'Lower Body'),
    (23000, 'Side Planks', 'Side Planks target the obliques and improve core stability.', 'Core'),
    (24000, 'Jumping Jacks', 'Jumping Jacks are a full-body exercise that improves cardiovascular fitness.', 'Full Body'),
    (25000, 'Hip Thrusts', 'Hip Thrusts target the glutes and lower back.', 'Lower Body'),
    (26000, 'Overhead Squats', 'Overhead Squats work the entire body, focusing on the core and shoulders.', 'Full Body'),
    (27000, 'Farmer’s Walk', 'Farmer’s Walk is great for building grip strength and overall conditioning.', 'Full Body'),
    (28000, 'Kettlebell Swings', 'Kettlebell Swings are a dynamic exercise for the hips, legs, and core.', 'Full Body');

-- Insert workout exercises linking workouts to exercises and defining sets and reps
INSERT INTO workout_exercise(id, workout_id, exercise_id, sets, reps, exercise_order, day_of_week) VALUES
    (1000, 1000, 4000, 3, 10, 1, 1),
    (2000, 1000, 5000, 3, 10, 2, 2),
    (3000, 1000, 6000, 3, 10, 3, 3),
    (4000, 1000, 7000, 3, 10, 4, 4),
    (5000, 1000, 8000, 3, 10, 5, 5),
    (6000, 1000, 9000, 3, 10, 6, 1),
    (7000, 1000, 10000, 3, 10, 7, 2),
    (8000, 1000, 11000, 3, 10, 8, 3),
    (9000, 1000, 12000, 3, 10, 9, 4),
    (1001, 1000, 13000, 3, 10, 10, 5),
    (1002, 1000, 14000, 3, 10, 11, 1),
    (1003, 1000, 15000, 3, 10, 12, 2),
    (1004, 1000, 16000, 3, 10, 13, 3),
    (1005, 1000, 17000, 3, 10, 14, 4),
    (1006, 1000, 18000, 3, 10, 15, 5),
    (1007, 1000, 19000, 3, 10, 16, 1),
    (1008, 1000, 20000, 3, 10, 17, 2),
    (1009, 1000, 21000, 3, 10, 18, 3),
    (1010, 1000, 22000, 3, 10, 19, 4),
    (1020, 1000, 23000, 3, 10, 20, 5),
    (1030, 1000, 24000, 3, 10, 21, 1),
    (1040, 1000, 25000, 3, 10, 22, 2),
    (1050, 1000, 26000, 3, 10, 23, 3),
    (1060, 1000, 27000, 3, 10, 24, 4),
    (1070, 1000, 28000, 3, 10, 25, 5);



-- Insert reports
INSERT INTO report (id, date, trainee_id, trainer_id, title, content) VALUES
    (1000, '2024-01-02', 1000, 1000, 'Week 1: Initial Assessment and Goal Setting', 'In the first week, we focused on understanding the trainee''s current fitness level through a series of assessments. We discussed the trainee''s goals and set realistic targets to achieve over the next few months. The trainee showed enthusiasm and commitment to the program.'),
    (2000, '2024-01-09', 1000, 1000, 'Week 2: Introduction to Training Regimen', 'During the second week, we introduced a customized training regimen tailored to the trainee''s goals. The trainee adapted well to the workout routines, showing improvement in strength and endurance. Feedback was collected to adjust the program as needed.'),
    (3000, '2024-01-16', 1000, 1000, 'Week 3: Progress in Strength and Stamina', 'By the third week, there was noticeable progress in the trainee''s strength and stamina. We increased the intensity of workouts slightly to continue challenging the trainee. The trainee remained motivated and consistent with the training schedule.'),
    (4000, '2024-01-23', 1000, 1000, 'Week 4: Mid-Program Evaluation and Adjustments', 'In the fourth week, we conducted a mid-program evaluation to assess the trainee''s progress. The results were positive, with significant improvements in various fitness parameters. Based on the evaluation, we made minor adjustments to the training plan to better align with the trainee''s evolving needs and goals.');

-- Insert into measurements
INSERT INTO measurement_record (id, body_part, measurement_value, unit, date, trainee_id)
VALUES
    (1000, 'WEIGHT', 70.5, 'KG', '2024-05-24', 1000),
    (2000, 'SHOULDERS', 120.0, 'CM', '2024-05-24', 1000),
    (3000, 'CHEST', 95.0, 'CM', '2024-05-24', 1000),
    (4000, 'RIGHT_ARM', 35.0, 'CM', '2024-05-24', 1000),
    (5000, 'LEFT_ARM', 34.5, 'CM', '2024-05-24', 1000),
    (6000, 'WAIST', 80.0, 'CM', '2024-05-24', 1000),
    (7000, 'HIPS', 90.0, 'CM', '2024-05-24', 1000),
    (8000, 'RIGHT_THIGH', 55.0, 'CM', '2024-05-24', 1000),
    (9000, 'LEFT_THIGH', 54.5, 'CM', '2024-05-24', 1000),
    (10000, 'RIGHT_CALF', 37.0, 'CM', '2024-05-24', 1000),
    (11000, 'LEFT_CALF', 36.5, 'CM', '2024-05-24', 1000);


-- Insert into users
INSERT INTO users (id, username, password, role) VALUES
    (1000, 'admin', '$2a$12$eI7rtBvngtesW4eGM8771eO4lXHfQ9cQkNbuEAbKhiBQtyWSELogC', 'ROLE_ADMIN'),
    (2000, 'trainer', '$2a$12$eI7rtBvngtesW4eGM8771eO4lXHfQ9cQkNbuEAbKhiBQtyWSELogC', 'ROLE_TRAINER'),
    (3000, 'trainee', '$2a$12$eI7rtBvngtesW4eGM8771eO4lXHfQ9cQkNbuEAbKhiBQtyWSELogC', 'ROLE_TRAINEE');