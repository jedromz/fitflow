import React, { useState } from 'react';

// Initial workout items
const initialWorkouts = [
    { id: 1, name: 'Push-ups' },
    { id: 2, name: 'Pull-ups' },
    { id: 3, name: 'Squats' },
    { id: 4, name: 'Lunges' },
    { id: 5, name: 'Planks' }
];

const WorkoutBuilder = () => {
    const [availableWorkouts, setAvailableWorkouts] = useState(initialWorkouts);
    const [plan, setPlan] = useState([]);

    const onDragStart = (e, item, origin) => {
        console.log("onDragStart")
        e.dataTransfer.setData('application/reactflow', JSON.stringify(item));
        e.dataTransfer.effectAllowed = 'move';
        e.dataTransfer.setData('origin', origin); // Track the origin of the drag
        console.log(availableWorkouts)
        console.log(plan)
    };

    const onDragEnd = (e) => {
        console.log("onDragEnd");
        const rawData = e.dataTransfer.getData('application/reactflow');
        if (!rawData) {
            console.warn('No data to parse on drag end.');
            return; // Exit the function if there's no data.
        }
        const item = JSON.parse(rawData);
        if (origin === 'plan') {
            setAvailableWorkouts((current) => [...current, item]);
            setPlan((current) => current.filter((p) => p.id !== item.id));
        }else{
            setPlan((current) => current.filter((p) => p.id !== item.id));
            setAvailableWorkouts((current) => [...current, item]);
        }
    };

    const onDropToPlan = (e) => {
        e.preventDefault(); // Prevent default to allow drop
        const item = JSON.parse(e.dataTransfer.getData('application/reactflow'));
        if (!plan.find((p) => p.id === item.id)) {
            setPlan((current) => [...current, item]);
            setAvailableWorkouts((current) => current.filter((w) => w.id !== item.id));
        }else{
            setAvailableWorkouts((current) => [...current, item]);
        }
    };

    const onDragOver = (e) => {
        e.preventDefault(); // Necessary to allow drop
    };

    return (
        <div className="flex gap-4 p-5">
            <div
                className="w-1/2 p-4 bg-blue-100 rounded shadow"
                onDragOver={onDragOver}
                onDrop={onDropToPlan}
            >
                <h2 className="text-lg font-bold mb-4">Your Workout Plan</h2>
                <ul className="space-y-2">
                    {availableWorkouts.map((item) => (
                        <li
                            key={item.id}
                            draggable
                            onDragStart={(e) => onDragStart(e, item, 'available')}
                            onDragEnd={onDragEnd}
                            className="cursor-move p-2 bg-gray-300 rounded shadow"
                        >
                            {item.name}
                        </li>
                    ))}

                </ul>
            </div>
            <div
                className="w-1/2 p-4 bg-blue-100 rounded shadow"
                onDragOver={onDragOver}
                onDrop={onDropToPlan}
            >
                <h2 className="text-lg font-bold mb-4">Your Workout Plan</h2>
                <ul className="space-y-2">
                    {plan.map((item) => (
                        <li
                            key={item.id}
                            draggable
                            onDragStart={(e) => onDragStart(e, item, 'plan')}
                            onDragEnd={onDragEnd}
                            className="cursor-move p-2 bg-gray-300 rounded shadow"
                        >
                            {item.name}
                        </li>
                    ))}
                    {plan.length === 0 && <p>Drag workouts here to build your plan.</p>}
                </ul>
            </div>
        </div>
    );
};

export default WorkoutBuilder;
