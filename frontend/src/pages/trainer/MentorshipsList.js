import React, { useEffect, useState } from 'react';
import Appbar from "./Appbar";

export default function MentorshipsList() {
    const [mentorships, setMentorships] = useState([]);
    const [showModal, setShowModal] = useState(false);
    const [newMentorship, setNewMentorship] = useState({
        startDate: '',
        endDate: '',
        price: 0,
        trainee: '',
    });
    const [trainees, setTrainees] = useState([]); // Assuming you have trainees to select from

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

        // Fetch trainees data
        fetch(`/api/trainers/1/trainees`) // Adjust this endpoint as necessary
            .then(response => response.json())
            .then(data => setTrainees(data))
            .catch(error => console.error("There was an error fetching the trainees: ", error));
    }, []);

    const handleAddNewMentorship = () => {
        setShowModal(true);
    };

    const handleSubmit = async (event) => {
        event.preventDefault();

        const mentorshipData = {
            traineeId: 1,
            trainerId: 1,
            fromDate: newMentorship.startDate,
            toDate: newMentorship.endDate,
            price: 300,
        };

        try {
            const response = await fetch('/mentorships', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(mentorshipData)
            });

            if (!response.ok) {
                throw new Error(`Error: ${response.status}`);
            }

            const result = await response.json();
            console.log('Success:', result);

            setShowModal(false);
            setMentorships([...mentorships, result]);
            setNewMentorship({
                startDate: '',
                endDate: '',
                price: 0,
                trainee: ''
            });
        } catch (error) {
            console.error('Error during mentorship creation:', error);
        }
    };

    const handleChange = (event) => {
        setNewMentorship({ ...newMentorship, [event.target.name]: event.target.value });
    };

    return (
        <div className="flex h-screen">
            <Appbar />
            <div className="overflow-x-auto w-full">
                <div className="shadow-md sm:rounded-lg m-5 flex-grow">
                    <div className="flex justify-between items-center p-5">
                        <h2 className="text-lg font-medium">Mentorships</h2>
                        <button
                            onClick={handleAddNewMentorship}
                            className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded"
                        >
                            Add New Mentorship
                        </button>
                    </div>
                    <table className="w-full text-sm text-left text-gray-500 dark:text-gray-400">
                        <thead className="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
                        <tr>
                            <th scope="col" className="py-3 px-6">Start Date</th>
                            <th scope="col" className="py-3 px-6">End Date</th>
                            <th scope="col" className="py-3 px-6">Price</th>
                            <th scope="col" className="py-3 px-6">Trainee</th>
                        </tr>
                        </thead>
                        <tbody>
                        {mentorships.map((mentorship) => (
                            <tr key={mentorship.id} className="bg-white border-b dark:bg-gray-800 dark:border-gray-700">
                                <td className="py-4 px-6">{mentorship.fromDate}</td>
                                <td className="py-4 px-6">{mentorship.toDate}</td>
                                <td className="py-4 px-6">{mentorship.price}</td>
                                <td className="py-4 px-6">Dummy</td> {/* Adjust according to your data structure */}
                            </tr>
                        ))}
                        </tbody>
                    </table>
                </div>
            </div>
            {showModal ? (
                <div className="fixed inset-0 bg-gray-600 bg-opacity-50 overflow-y-auto h-full w-full">
                    <div className="relative top-20 mx-auto p-5 border w-96 shadow-lg rounded-md bg-white">
                        <div className="mt-3 text-center">
                            <h3 className="text-lg leading-6 font-medium text-gray-900">Add New Mentorship</h3>
                            <form className="mt-2" onSubmit={handleSubmit}>
                                <input
                                    className="mt-2 p-2 w-full border rounded-md"
                                    name="startDate"
                                    type="date"
                                    value={newMentorship.startDate}
                                    onChange={handleChange}
                                    required
                                />
                                <input
                                    className="mt-2 p-2 w-full border rounded-md"
                                    name="endDate"
                                    type="date"
                                    value={newMentorship.endDate}
                                    onChange={handleChange}
                                    required
                                />
                                <input
                                    className="mt-2 p-2 w-full border rounded-md"
                                    name="price"
                                    type="number"
                                    value={newMentorship.price}
                                    onChange={handleChange}
                                    required
                                />
                                <select
                                    className="mt-2 p-2 w-full border rounded-md"
                                    name="trainee"
                                    value={newMentorship.trainee}
                                    onChange={handleChange}
                                    required
                                >
                                    <option value="">Select Trainee</option>
                                    {trainees.map((trainee) => (
                                        <option key={trainee.id} value={trainee.id}>
                                            {trainee.name}
                                        </option>
                                    ))}
                                </select>
                                <div className="items-center px-4 py-3">
                                    <button
                                        className="px-4 py-2 bg-blue-500 text-white text-base font-medium rounded-md w-full shadow-sm hover:bg-blue-700 focus:outline-none focus:ring-2 focus:ring-blue-500"
                                        type="submit"
                                    >
                                        Add Mentorship
                                    </button>
                                </div>
                            </form>
                            <div className="items-center px-4 py-3">
                                <button
                                    className="px-4 py-2 bg-white text-red-500 text-base font-medium rounded-md w-full shadow-sm hover:bg-gray-100 focus:outline-none focus:ring-2 focus:ring-red-500"
                                    onClick={() => setShowModal(false)}
                                >
                                    Cancel
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            ) : null}
        </div>
    );
}
