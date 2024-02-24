import React, { useState } from 'react';

// Initial workout items
const initialWorkouts = [
    { id: 1, name: 'Push-ups' },
    { id: 2, name: 'Pull-ups' },
    { id: 3, name: 'Squats' },
    { id: 4, name: 'Lunges' },
    { id: 5, name: 'Planks' }
];

// Assuming a predefined list of trainees
const trainees = [
    { id: 1, name: 'John Doe' },
    { id: 2, name: 'Jane Smith' }
];

const days = ['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday'];

const WorkoutBuilder = () => {
    const [availableWorkouts, setAvailableWorkouts] = useState(initialWorkouts);
    const [plan, setPlan] = useState(days.reduce((acc, day) => ({ ...acc, [day]: [] }), {}));
    const [planName, setPlanName] = useState('');
    const [selectedTrainee, setSelectedTrainee] = useState('');

    const onDragStart = (e, item, origin, day = null) => {
        const dragData = { item, origin, day };
        e.dataTransfer.setData('application/reactflow', JSON.stringify(dragData));
        e.dataTransfer.effectAllowed = 'move';
    };

    const onDropToDay = (e, day) => {
        e.preventDefault();
        const { item, origin } = JSON.parse(e.dataTransfer.getData('application/reactflow'));
        if (origin === 'available' || origin === 'day') {
            if (!plan[day].find((i) => i.id === item.id)) {
                setPlan((current) => ({
                    ...current,
                    [day]: [...current[day], { ...item, sets: item.sets || 3, reps: item.reps || 10 }]
                }));
            }
        }
    };

    const onDragOver = (e) => {
        e.preventDefault();
    };

    const handlePlanNameChange = (e) => {
        setPlanName(e.target.value);
    };

    const handleTraineeChange = (e) => {
        setSelectedTrainee(e.target.value);
    };

    const handleExerciseChange = (day, id, field, value) => {
        setPlan((current) => ({
            ...current,
            [day]: current[day].map((exercise) =>
                exercise.id === id ? { ...exercise, [field]: parseInt(value, 10) || '' } : exercise
            )
        }));
    };

    const removeExerciseFromDay = (day, id) => {
        setPlan((current) => ({
            ...current,
            [day]: current[day].filter((exercise) => exercise.id !== id)
        }));
    };

    const savePlan = () => {
        console.log('Saving plan:', { planName, selectedTrainee, plan });
    };

    return (
        <div className="flex flex-col gap-4 p-5" >
            <div className="flex gap-4 mb-4">
                <input
                    type="text"
                    placeholder="Plan Name"
                    value={planName}
                    onChange={handlePlanNameChange}
                    className="p-2 border rounded"
                />
                <select
                    value={selectedTrainee}
                    onChange={handleTraineeChange}
                    className="p-2 border rounded"
                >
                    <option value="">Select Trainee</option>
                    {trainees.map((trainee) => (
                        <option key={trainee.id} value={trainee.id}>
                            {trainee.name}
                        </option>
                    ))}
                </select>
                <button onClick={savePlan} className="p-2 bg-blue-500 text-white rounded">
                    Save Plan
                </button>
            </div>
            <div className="flex gap-4">
                <div
                    className="w-1/8 p-4 bg-blue-100 rounded shadow"
                    onDragOver={onDragOver}
                >
                    <h2 className="text-lg font-bold mb-4">Available Exercises</h2>
                    <ul className="space-y-2">
                        {availableWorkouts.map((item) => (
                            <li
                                key={item.id}
                                draggable
                                onDragStart={(e) => onDragStart(e, item, 'available')}
                                className="cursor-move p-2 bg-gray-300 rounded shadow"
                            >
                                {item.name}
                            </li>
                        ))}
                    </ul>
                </div>
                <div className="w-full p-4 bg-blue-100 rounded shadow h-screen">
                    <h2 className="text-lg font-bold mb-4">Your Workout Plan</h2>
                    <div className="grid grid-cols-7 gap-4">
                        {days.map((day) => (
                            <div
                                key={day}
                                className="p-4 rounded "
                                onDragOver={onDragOver}
                                onDrop={(e) => onDropToDay(e, day)}
                            >
                                <h3 className="font-bold">{day}</h3>
                                <ul className="space-y-2">
                                    {plan[day].map((exercise) => (
                                        <li
                                            key={`${exercise.id}-${day}`}
                                            draggable
                                            onDragStart={(e) => onDragStart(e, exercise, 'day', day)}
                                            className="flex justify-between items-center p-2 bg-gray-300 rounded shadow"
                                        >
                                            {exercise.name}
                                            <div className="flex items-center">
                                                <input
                                                    type="text"
                                                    min="1"
                                                    value={exercise.sets}
                                                    onChange={(e) => handleExerciseChange(day, exercise.id, 'sets', e.target.value)}
                                                    className="w-8 p-1 rounded border mx-2"
                                                    placeholder="Sets"
                                                />
                                                <input
                                                    type="text"
                                                    min="1"
                                                    value={exercise.reps}
                                                    onChange={(e) => handleExerciseChange(day, exercise.id, 'reps', e.target.value)}
                                                    className="w-8 p-1 rounded border"
                                                    placeholder="Reps"
                                                />
                                                <button
                                                    onClick={() => removeExerciseFromDay(day, exercise.id)}
                                                    className="ml-2 bg-red-500 text-white p-1 rounded"
                                                >
                                                    X
                                                </button>
                                            </div>
                                        </li>
                                    ))}
                                </ul>
                            </div>
                        ))}
                    </div>
                </div>
            </div>
        </div>
    );
};

export default WorkoutBuilder;
