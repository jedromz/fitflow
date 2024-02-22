import React from 'react';
import { Link } from 'react-router-dom';
import { HomeIcon, LibraryIcon, InformationCircleIcon } from '@heroicons/react/outline';

export default function Appbar() {
    return (
        // Adjusted the styling here to make the appbar vertical and aligned to the left
        <div className="bg-gray-800 text-white w-20 h-screen p-4 flex flex-col justify-between items-center">
            {/* No changes needed inside here, just the container's styling */}
            <div className="flex flex-col gap-4">
                <div className="flex flex-col items-center">
                    <span className="text-2xl font-extrabold pb-5">Fitflow</span>
                    <Link to="/" className="hover:text-gray-300">
                        <HomeIcon className="h-6 w-6" />
                    </Link>
                    <span className="text-xs">Home</span>
                </div>
                <div className="flex flex-col items-center">
                    <Link to="/library" className="hover:text-gray-300">
                        <LibraryIcon className="h-6 w-6" />
                    </Link>
                    <span className="text-xs">Library</span>
                </div>
                <div className="flex flex-col items-center">
                    <Link to="/about" className="hover:text-gray-300">
                        <InformationCircleIcon className="h-6 w-6" />
                    </Link>
                    <span className="text-xs">About</span>
                </div>
            </div>
            {/* You can add more elements here if needed */}
        </div>
    );
}
