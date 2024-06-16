import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import Appbar from '../trainer/components/Appbar';

export default function TraineeTrainingPlan() {
    const [trainingPlan, setTrainingPlan] = useState(null);
    const [progressions, setProgressions] = useState({});
    const { traineeId } = useParams();

    useEffect(() => {
        fetch(`/api/trainees/${traineeId}/trainingplans/current`)
            .then(response => response.json())
            .then(data => setTrainingPlan(data))
            .catch(error => console.error('Error fetching training plan:', error));
    }, [traineeId]);

    useEffect(() => {
        if (trainingPlan) {
            trainingPlan.exercies.forEach(exercise => {
                fetch(`/trainees/${traineeId}/progressions/${exercise.name}`)
                    .then(response => response.json())
                    .then(data => {
                        setProgressions(prevState => ({
                            ...prevState,
                            [exercise.name]: data
                        }));
                    })
                    .catch(error => console.error(`Error fetching progression for ${exercise.name}:`, error));
            });
        }
    }, [trainingPlan, traineeId]);

    const handleProgressionChange = (exerciseName, field, value) => {
        setProgressions(prevState => ({
            ...prevState,
            [exerciseName]: {
                ...prevState[exerciseName],
                [field]: value
            }
        }));
    };

    const handleFormSubmit = (e, exerciseName) => {
        e.preventDefault();
        const { sets, reps, weight } = progressions[exerciseName];
        fetch(`/trainees/${traineeId}/progressions/${exerciseName}`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ sets, reps, weight })
        })
            .then(response => response.json())
            .then(data => {
                console.log('Progressions saved:', data);
                // Optionally, fetch the latest progression again after saving
                fetch(`/trainees/${traineeId}/progressions/${exerciseName}`)
                    .then(response => response.json())
                    .then(data => {
                        setProgressions(prevState => ({
                            ...prevState,
                            [exerciseName]: data
                        }));
                    })
                    .catch(error => console.error(`Error fetching progression for ${exerciseName}:`, error));
            })
            .catch(error => console.error('Error saving progressions:', error));
    };

    const daysOfWeek = ['MONDAY', 'TUESDAY', 'WEDNESDAY', 'THURSDAY', 'FRIDAY', 'SATURDAY', 'SUNDAY'];

    return (
        <div className="flex h-screen">
            <Appbar />
            <div className="overflow-x-auto w-full">
                <div className="m-5">
                    <h1 className="text-xl font-semibold mb-4">Training Plan</h1>
                    {trainingPlan ? (
                        <div>
                            <h2 className="text-lg font-semibold mb-4">{trainingPlan.name}</h2>
                            <p className="mb-4">{trainingPlan.description}</p>
                            {daysOfWeek.map(day => (
                                <div key={day} className="mb-6">
                                    <h3 className="text-lg font-semibold mb-2">{day}</h3>
                                    <ul>
                                        {trainingPlan.exercies.filter(exercise => exercise.dayOfWeek === day).sort((a, b) => a.exerciseOrder - b.exerciseOrder).map(exercise => (
                                            <li key={exercise.name} className="mb-2">
                                                <div className="flex justify-between items-center">
                                                    <span>{exercise.name}</span>
                                                    <form className="flex space-x-2" onSubmit={(e) => handleFormSubmit(e, exercise.name)}>
                                                        <input
                                                            type="number"
                                                            placeholder="Sets"
                                                            value={progressions[exercise.name]?.sets || ''}
                                                            onChange={(e) => handleProgressionChange(exercise.name, 'sets', e.target.value)}
                                                            className="border rounded py-1 px-2"
                                                        />
                                                        <input
                                                            type="number"
                                                            placeholder="Reps"
                                                            value={progressions[exercise.name]?.reps || ''}
                                                            onChange={(e) => handleProgressionChange(exercise.name, 'reps', e.target.value)}
                                                            className="border rounded py-1 px-2"
                                                        />
                                                        <input
                                                            type="number"
                                                            placeholder="Weight"
                                                            value={progressions[exercise.name]?.weight || ''}
                                                            onChange={(e) => handleProgressionChange(exercise.name, 'weight', e.target.value)}
                                                            className="border rounded py-1 px-2"
                                                        />
                                                        <button
                                                            type="submit"
                                                            className="px-4 py-1 bg-blue-600 text-white rounded"
                                                        >
                                                            Save
                                                        </button>
                                                    </form>
                                                </div>
                                                {progressions[exercise.name] && (
                                                    <div className="mt-2 text-gray-600">
                                                        <p>Last Progression - Sets: {progressions[exercise.name].sets}, Reps: {progressions[exercise.name].reps}, Weight: {progressions[exercise.name].weight}</p>
                                                    </div>
                                                )}
                                            </li>
                                        ))}
                                    </ul>
                                </div>
                            ))}
                        </div>
                    ) : (
                        <p>Loading training plan...</p>
                    )}
                </div>
            </div>
        </div>
    );
}
