import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';

export default function TraineeReports() {
    const [reports, setReports] = useState([]);
    const [selectedReport, setSelectedReport] = useState(null);
    const [isModalOpen, setIsModalOpen] = useState(false);
    const { traineeId } = useParams();
    const [photoUrls, setPhotoUrls] = useState({});

    useEffect(() => {
        fetch(`/trainees/${traineeId}/reports`)
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.json();
            })
            .then(data => {
                setReports(data);
                return data;
            })
            .then(reports => {
                // Fetch URLs for photos
                const photoPromises = reports.map(report =>
                    report.photos[0] && fetch(`/objects/${report.photos[0]}`)
                        .then(response => response.text()) // Change to response.text() to handle non-JSON response
                        .then(url => ({ [report.photos[0]]: url }))
                );
                return Promise.all(photoPromises);
            })
            .then(photoData => {
                const urls = photoData.reduce((acc, curr) => ({ ...acc, ...curr }), {});
                setPhotoUrls(urls);
            })
            .catch(error => {
                console.error('There was a problem fetching the reports or photo URLs:', error);
            });
    }, [traineeId]);

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
                            <th scope="col" className="py-3 px-6">Photo</th>
                        </tr>
                    </thead>
                    <tbody>
                        {reports.map((report) => (
                            <tr key={report.id} className="bg-white border-b dark:bg-gray-800 dark:border-gray-700 hover:bg-gray-50 cursor-pointer" onClick={() => handleReportClick(report.id)}>
                                <td className="py-4 px-6">{report.date}</td>
                                <td className="py-4 px-6">{report.title}</td>
                                <td className="py-4 px-6">{report.content}</td>
                                <td className="py-4 px-6">
                                    {report.photos && report.photos.length > 0 && photoUrls[report.photos[0]] ? (
                                        <img src={photoUrls[report.photos[0]]} alt="Report Thumbnail" className="w-10 h-10 object-cover" />
                                    ) : (
                                        <span>No Photo</span>
                                    )}
                                </td>
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
                                {selectedReport.photos && selectedReport.photos.length > 0 && photoUrls[selectedReport.photos[0]] && (
                                    <div className="mt-4">
                                        <img src={photoUrls[selectedReport.photos[0]]} alt="Report Photo" className="mb-2 max-w-full h-auto" />
                                    </div>
                                )}
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
