import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';

export default function TraineesMeasurements() {
    const [measurements, setMeasurements] = useState([]);
    const [selectedMeasurement, setSelectedMeasurement] = useState(null);
    const [isModalOpen, setIsModalOpen] = useState(false);
    const { traineeId } = useParams();

    useEffect(() => {
        fetch(`/trainees/${traineeId}/measurements`)
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.json();
            })
            .then(data => {
                setMeasurements(data); // Assuming the data is an array of measurements
            })
            .catch(error => {
                console.error('There was a problem fetching the measurements:', error);
            });
    }, [traineeId]);

    const handleMeasurementClick = (measurementId) => {
        setSelectedMeasurement(measurements.find(measurement => measurement.id === measurementId));
        setIsModalOpen(true);
    };

    const closeModal = () => {
        setIsModalOpen(false);
    };

    return (
        <div>
            <h1 className="text-xl font-semibold mb-4">Trainee Measurements</h1>
            <div className="overflow-x-auto relative shadow-md sm:rounded-lg">
                <table className="w-full text-sm text-left text-gray-500 dark:text-gray-400">
                    <thead className="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
                    <tr>
                        <th scope="col" className="py-3 px-6">Date</th>
                        <th scope="col" className="py-3 px-6">Body Part</th>
                        <th scope="col" className="py-3 px-6">Measurement</th>
                    </tr>
                    </thead>
                    <tbody>
                    {measurements.map((measurement) => (
                        <tr key={measurement.id} className="bg-white border-b dark:bg-gray-800 dark:border-gray-700 hover:bg-gray-50 cursor-pointer" onClick={() => handleMeasurementClick(measurement.id)}>
                            <td className="py-4 px-6">{measurement.date}</td>
                            <td className="py-4 px-6">{measurement.bodyPart}</td>
                            <td className="py-4 px-6">{measurement.measurement.measurementValue} {measurement.measurement.unit}</td>
                        </tr>
                    ))}
                    </tbody>
                </table>
            </div>

            {isModalOpen && selectedMeasurement && (
                <div className="fixed inset-0 bg-gray-600 bg-opacity-50 overflow-y-auto h-full w-full" onClick={closeModal}>
                    <div className="relative top-20 mx-auto p-5 border w-96 shadow-lg rounded-md bg-white" onClick={e => e.stopPropagation()}>
                        <div className="mt-3 text-center">
                            <h3 className="text-lg leading-6 font-medium text-gray-900">Measurement Details</h3>
                            <div className="mt-2">
                                <p className="text-sm text-gray-500">Date: {selectedMeasurement.date}</p>
                                <p className="text-sm text-gray-500">Body Part: {selectedMeasurement.bodyPart}</p>
                                <p className="text-sm text-gray-500">Measurement: {selectedMeasurement.measurement.measurementValue} {selectedMeasurement.measurement.unit}</p>
                            </div>
                            <div className="items-center px-4 py-3">
                                <button onClick={closeModal} className="px-4 py-2 bg-gray-800 text-white text-base font-medium rounded-md w-full shadow-sm hover:bg-gray-700 focus:outline-none focus:ring-2 focus:ring-gray-500">
                                    Close
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            )}
        </div>
    );
}
