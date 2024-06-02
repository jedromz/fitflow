import * as React from 'react';
import { Routes, Route } from 'react-router-dom';
import TraineeList from './pages/trainer/trainees/TraineeList'
import Dashboard from './pages/trainer/dashboard/Dashboard'
import MentorshipsList from './pages/trainer/mentorships/MentorshipsList'
import WorkoutsList from './pages/trainer/workouts/WorkoutsList'
import Exercises from './pages/trainer/exercises/Exercises'
import Reports from './pages/trainer/reports/Reports'
import WorkoutBuilder from './pages/trainer/workouts/WorkoutBuilder'
import TraineeDashboard from './pages/trainee/TraineeDashboard';
import TraineesMeasurements from './pages/trainee/TraineeMeasurements';
import TraineeWorkoutsList from './pages/trainee/TraineeWorkouts';
import TraineeReports from './pages/trainee/TraineeReports';
import TraineesPhotos from './pages/trainee/TraineePhotos';
import TraineeCurrentTrainer from './pages/trainee/TraineeCurrentTrainer';

export default function App() {
    return (
        <div>
            <Routes>
                <Route path="/trainer/:trainerId/trainees" element={<TraineeList />} />
                <Route path="/trainer/:trainerId/dashboard" element={<Dashboard id={1} />} />
                <Route path="/trainer/:trainerId/mentorships" element={<MentorshipsList />} />
                <Route path="/trainer/:trainerId/workouts" element={<WorkoutsList />} />
                <Route path="/trainer/:trainerId/reports" element={<Reports/>} />
                <Route path="/exercises" element={<Exercises />} />
                <Route path="/trainer/:trainerId/builder" element={<WorkoutBuilder />} />
                
                <Route path="/trainee/:traineeId/dashboard" element={<TraineeDashboard id={1} />} />
                <Route path="/trainee/:traineeId/measurements" element={<TraineesMeasurements id={1} />} />
                <Route path="/trainee/:traineeId/workoutplans" element={<TraineeWorkoutsList id={1} />} />
                <Route path="/trainee/:traineeId/reports" element={<TraineeReports id={1} />} />
                <Route path="/trainee/:traineeId/photos" element={<TraineesPhotos id={1} />} />
                <Route path="/trainee/:traineeId/trainer" element={<TraineeCurrentTrainer id={1} />} />
            </Routes>
        </div>
    );
}
