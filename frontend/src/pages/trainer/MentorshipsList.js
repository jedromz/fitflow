import React, { useEffect, useState } from 'react';
import Appbar from "./Appbar";

export default function MentorshipsList() {
    const [mentorships, setMentorships] = useState([]);

    useEffect(() => {
        const trainerId = 1;
        fetch(`/api/trainers/${trainerId}/mentorships`)
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.json();
            })
            .then(data => {
                setMentorships(data);
            })
            .catch(error => {
                console.error("There was an error fetching the mentorships: ", error);
            });
    }, []);

    return (
        <div className="flex h-screen">
            <Appbar />
            <div className="overflow-x-auto w-full">
                <div className="shadow-md sm:rounded-lg m-5 flex-grow">
                    <table className="w-full text-sm text-left text-gray-500 dark:text-gray-400">
                        <thead className="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
                        <tr>
                            <th scope="col" className="py-3 px-6">Start Date</th>
                            <th scope="col" className="py-3 px-6">End Date</th>
                            <th scope="col" className="py-3 px-6">Trainer</th>
                            <th scope="col" className="py-3 px-6">Trainee</th>
                        </tr>
                        </thead>
                        <tbody>
                        {mentorships.map((mentorship) => (
                            <tr key={mentorship.id} className="bg-white border-b dark:bg-gray-800 dark:border-gray-700">
                                <td className="py-4 px-6">{mentorship.fromDate}</td>
                                <td className="py-4 px-6">{mentorship.toDate}</td>
                                <td className="py-4 px-6">{mentorship.trainer.name}</td>
                                <td className="py-4 px-6">{mentorship.trainee.name}</td>
                            </tr>
                        ))}
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    );
}
