import React, {useEffect, useState} from 'react';
import {useParams} from 'react-router-dom';
import NumberTile from '../components/NumberTile'
import IconTile from '../components/IconTile'
import Appbar  from '../components/Appbar'
export default function WorkoutsList() {
    const [workouts, setWorkouts] = useState([]);
    const {trainerId} = useParams();
    useEffect(() => {
        fetch(`/trainers/${trainerId}/workoutplans`)
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.json();
            })
            .then(data => {
                setWorkouts(data);
            })
            .catch(error => {
                console.error("There was an error fetching the workouts: ", error);
            });
    }, [trainerId]);

    return (
        <div className="flex h-screen">
            <Appbar/>
            <div className="overflow-x-auto w-full">
                <div className="shadow-md sm:rounded-lg m-5 flex-grow">
                    <table className="w-full text-sm text-left text-gray-500 dark:text-gray-400">
                        <thead
                            className="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
                        <tr>
                            <th scope="col" className="py-3 px-6">Name</th>
                            <th scope="col" className="py-3 px-6">Description</th>
                            <th scope="col" className="py-3 px-6">Start Date</th>
                            <th scope="col" className="py-3 px-6">End Date</th>
                        </tr>
                        </thead>
                        <tbody>
                        {workouts.map((workout) => (
                            <tr key={workout.id} className="bg-white border-b dark:bg-gray-800 dark:border-gray-700">
                                <td className="py-4 px-6">{workout.name}</td>
                                <td className="py-4 px-6">{workout.description}</td>
                                <td className="py-4 px-6">{workout.fromDate}</td>
                                <td className="py-4 px-6">{workout.toDate}</td>
                            </tr>
                        ))}
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    );
}
