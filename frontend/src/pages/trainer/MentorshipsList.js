import React from 'react';
import Appbar from "./Appbar";

// Sample Mentorship Data
const mentorships = [
    {
        id: 1,
        fromDate: '2023-01-01',
        toDate: '2023-06-01',
        trainer: { id: 1, name: 'Jane Doe' },
        trainee: { id: 2, name: 'John Smith' }
    },
    {
        id: 2,
        fromDate: '2023-02-15',
        toDate: '2023-08-15',
        trainer: { id: 2, name: 'Emily Jones' },
        trainee: { id: 3, name: 'William Johnson' }
    },
    // Add more mentorships as needed
];

export default function MentorshipsList() {
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
