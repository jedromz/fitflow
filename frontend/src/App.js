import * as React from 'react';
import { Routes, Route } from 'react-router-dom';
import TraineeList from './pages/trainer/TraineeList';
import Dashboard from "./pages/trainer/Dashboard";
import MentorshipsList from "./pages/trainer/MentorshipsList";
import Exercises from "./pages/trainer/Exercises";
import Reports from "./pages/trainer/Reports";
import WorkoutBuilder from "./pages/trainer/WorkoutBuilder";
import WorkoutsList from "./pages/trainer/WorkoutsList";

export default function App() {
     const getTrainerMentorships = async (trainerId) => {

         fetch(`/api/trainers/1/mentorships`)
             .then(response => {
                 if (!response.ok) {
                     throw new Error('Network response was not ok');
                 }
                 return response.json();
             })
             .then(data => {

             })
             .catch(error => {
                 console.error("There was an error fetching the mentorships: ", error);
             });
    };
    return (
        <div>
            <Routes>
                <Route path="/trainer/:trainerId/trainees" element={<TraineeList />} />
                <Route path="/trainer/:trainerId/dashboard" element={<Dashboard />} />
                <Route path="/trainer/:trainerId/mentorships" element={<MentorshipsList />} />
                <Route path="/trainer/:trainerId/workouts" element={<WorkoutsList />} />
                <Route path="/trainer/:trainerId/reports" element={<Reports/>} />
                <Route path="/exercises" element={<Exercises />} />
                <Route path="/trainer/:trainerId/builder" element={<WorkoutBuilder />} />
            </Routes>
        </div>
    );
}

