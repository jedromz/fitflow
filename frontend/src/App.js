import * as React from 'react';
import Appbar from "./pages/trainer/Appbar";
import Dashboard from "./pages/trainer/Dashboard";


export default function App() {
    return (
        <div className="flex h-screen">
            <div className="flex-none">
                <Appbar />
            </div>
            <div className="flex-grow flex justify-center items-center">
                <Dashboard />
            </div>
        </div>
    );
}

