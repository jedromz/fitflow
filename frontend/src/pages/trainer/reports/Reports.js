import React, { useState, useEffect } from 'react';
import {useParams } from 'react-router-dom';
export default function Reports() {
    const [reports, setReports] = useState([]);
    const [selectedReport, setSelectedReport] = useState(null);
    const [isModalOpen, setIsModalOpen] = useState(false);
    const {trainerId} = useParams();

    useEffect(() => {
        // Replace 'your-endpoint-url' with the actual endpoint URL
        fetch(`/trainer/${trainerId}/reports`)
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.json();
            })
            .then(data => {
                setReports(data); // Assuming the data is an array of reports
            })
            .catch(error => {
                console.error('There was a problem fetching the reports:', error);
            });
    }, [trainerId]); // The empty array ensures this effect runs once after initial render

    const handleReportClick = (reportId) => {
        setSelectedReport(reports.find(report => report.id === reportId));
        setIsModalOpen(true);
    };

    const closeModal = () => {
        setIsModalOpen(false);
    };

    return (
        <div>
            <h1 className="text-xl font-semibold mb-4">Reports</h1>
            <div className="overflow-x-auto relative shadow-md sm:rounded-lg">
                <table className="w-full text-sm text-left text-gray-500 dark:text-gray-400">
                    <thead className="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
                    <tr>
                        <th scope="col" className="py-3 px-6">Date</th>
                        <th scope="col" className="py-3 px-6">Title</th>
                        <th scope="col" className="py-3 px-6">Content</th>
                    </tr>
                    </thead>
                    <tbody>
                    {reports.map((report) => (
                        <tr key={report.id} className="bg-white border-b dark:bg-gray-800 dark:border-gray-700 hover:bg-gray-50 cursor-pointer" onClick={() => handleReportClick(report.id)}>
                            <td className="py-4 px-6">{report.date}</td>
                            <td className="py-4 px-6">{report.title}</td>
                            <td className="py-4 px-6">{report.content}</td>
                        </tr>
                    ))}
                    </tbody>
                </table>
            </div>

            {isModalOpen && selectedReport && (
                <div className="fixed inset-0 bg-gray-600 bg-opacity-50 overflow-y-auto h-full w-full" onClick={closeModal}>
                    <div className="relative top-20 mx-auto p-5 border w-96 shadow-lg rounded-md bg-white" onClick={e => e.stopPropagation()}>
                        <div className="mt-3 text-center">
                            <h3 className="text-lg leading-6 font-medium text-gray-900">{selectedReport.title}</h3>
                            <div className="mt-2">
                                <p className="text-sm text-gray-500">{selectedReport.content}</p>
                            </div>
                            <div className="mt-4">
                                <textarea className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" rows="4" placeholder="Write a comment..."></textarea>
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
