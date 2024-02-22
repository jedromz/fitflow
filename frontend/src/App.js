import * as React from 'react';
import { Routes, Route } from 'react-router-dom';
import TraineeList from './pages/trainer/TraineeList';
import Dashboard from "./pages/trainer/Dashboard";
import MentorshipsList from "./pages/trainer/MentorshipsList";
import Exercises from "./pages/trainer/Exercises";
import Reports from "./pages/trainer/Reports";

export default function App() {
    return (
        <div>
            <Routes>
                <Route path="/trainer/:trainerId/trainees" element={<TraineeList />} />
                <Route path="/trainer/:trainerId/dashboard" element={<Dashboard />} />
                <Route path="/trainer/:trainerId/mentorships" element={<MentorshipsList />} />
                <Route path="/trainer/:trainerId/reports" element={<Reports/>} />
                <Route path="/exercises" element={<Exercises />} />
            </Routes>
        </div>
    );
}

