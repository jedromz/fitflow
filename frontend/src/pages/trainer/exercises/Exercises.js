import React, { useState, useEffect } from 'react';
import NumberTile from '../components/NumberTile'
import IconTile from '../components/IconTile'
import Appbar  from '../components/Appbar'


export default function Exercises() {
    const [exercises, setExercises] = useState([]);

    useEffect(() => {
        // Replace 'http://example.com/api/exercises' with your actual API endpoint
        fetch('/exercises')
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.json();
            })
            .then(data => {
                setExercises(data);
            })
            .catch(error => {
                console.error("There was an error fetching the exercises: ", error);
            });
    }, []); // The empty array ensures this effect runs once after initial render

    return (
        <div className='flex'>
            <Appbar/>
            <div className="overflow-x-auto w-full">
                <div className="p-5">
                    <h1 className="text-xl font-semibold mb-4">Exercises</h1>
                    <div className="overflow-x-auto relative">
                        <table className="w-full text-sm text-left text-gray-500 dark:text-gray-400">
                            <thead className="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
                            <tr>
                                <th scope="col" className="py-3 px-6">Exercise Name</th>
                                <th scope="col" className="py-3 px-6">Description</th>
                                <th scope="col" className="py-3 px-6">Category</th>
                            </tr>
                            </thead>
                            <tbody>
                            {exercises.map((exercise) => (
                                <tr key={exercise.id} className="bg-white border-b dark:bg-gray-800 dark:border-gray-700 hover:bg-gray-50 dark:hover:bg-gray-600">
                                    <td className="py-4 px-6">{exercise.name}</td>
                                    <td className="py-4 px-6">{exercise.description}</td>
                                    <td className="py-4 px-6">{exercise.category}</td>
                                </tr>
                            ))}
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    );
}
