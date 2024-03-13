import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom'; // Ensure useParams is imported
import Appbar from "./Appbar";

export default function TraineeList() {
    const [trainees, setTrainees] = useState([]);
    const { trainerId } = useParams(); // Retrieve the trainerId from the URL
    const { id } = useParams(); // Retrieve the trainerId from the URL

    useEffect(() => {
        console.log(trainerId)
        console.log(id)
        // Fetch trainees for the trainer using the trainerId from the URL
        fetch(`/api/trainers/${trainerId}/trainees`)
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.json();
            })
            .then(data => {
                setTrainees(data);
            })
            .catch(error => {
                console.error("There was an error fetching the trainees: ", error);
            });
    }, [trainerId]); // Dependency on trainerId to rerun the effect when the trainerId changes

    return (
        <div className='flex'>
            <Appbar/>
            <div className="overflow-x-auto w-full">
                <div className="overflow-x-auto relative shadow-md sm:rounded-lg m-5">
                    <table className="w-full text-sm text-left text-gray-500 dark:text-gray-400">
                        <thead className="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
                        <tr>
                            <th scope="col" className="py-3 px-6">
                                First Name
                            </th>
                            <th scope="col" className="py-3 px-6">
                                Last Name
                            </th>
                            <th scope="col" className="py-3 px-6">
                                Email
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                        {trainees.map((trainee, index) => (
                            <tr key={index} className="bg-white border-b dark:bg-gray-800 dark:border-gray-700">
                                <td className="py-4 px-6">
                                    {trainee.name}
                                </td>
                                <td className="py-4 px-6">
                                    {trainee.lastName}
                                </td>
                                <td className="py-4 px-6">
                                    {trainee.email}
                                </td>
                            </tr>
                        ))}
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    );
}
