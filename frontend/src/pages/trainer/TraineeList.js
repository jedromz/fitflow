import React from 'react';
import Appbar from "./Appbar";

export default function TraineeList() {
    const trainees = [
        {
            firstName: 'John',
            lastName: 'Doe',
            email: 'john.doe@example.com',
            role: 'Trainee'
        },
        {
            firstName: 'Ann',
            lastName: 'Doe',
            email: 'ann.doe@example.com',
            role: 'Trainee'
        },
        {
            firstName: 'Ann',
            lastName: 'Doe',
            email: 'ann.doe@example.com',
            role: 'Trainee'
        },
        {
            firstName: 'Ann',
            lastName: 'Doe',
            email: 'ann.doe@example.com',
            role: 'Trainee'
        },
        {
            firstName: 'Ann',
            lastName: 'Doe',
            email: 'ann.doe@example.com',
            role: 'Trainee'
        },
        {
            firstName: 'Ann',
            lastName: 'Doe',
            email: 'ann.doe@example.com',
            role: 'Trainee'
        },
        {
            firstName: 'Ann',
            lastName: 'Doe',
            email: 'ann.doe@example.com',
            role: 'Trainee'
        },
        {
            firstName: 'Ann',
            lastName: 'Doe',
            email: 'ann.doe@example.com',
            role: 'Trainee'
        },
        {
            firstName: 'Ann',
            lastName: 'Doe',
            email: 'ann.doe@example.com',
            role: 'Trainee'
        },
        {
            firstName: 'Ann',
            lastName: 'Doe',
            email: 'ann.doe@example.com',
            role: 'Trainee'
        },
        {
            firstName: 'Ann',
            lastName: 'Doe',
            email: 'ann.doe@example.com',
            role: 'Trainee'
        },

    ];

    return (
        <div className='flex'>
            <Appbar/>
            <div className="overflow-x-auto w-full">
                <div className="overflow-x-auto relative shadow-md sm:rounded-lg m-5">
                    <table className="w-full text-sm text-left text-gray-500 dark:text-gray-400">
                        <thead
                            className="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
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
                            <th scope="col" className="py-3 px-6">
                                Role
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                        {trainees.map((trainee, index) => (
                            <tr key={index} className="bg-white border-b dark:bg-gray-800 dark:border-gray-700">
                                <td className="py-4 px-6">
                                    {trainee.firstName}
                                </td>
                                <td className="py-4 px-6">
                                    {trainee.lastName}
                                </td>
                                <td className="py-4 px-6">
                                    {trainee.email}
                                </td>
                                <td className="py-4 px-6">
                                    {trainee.role}
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
