import React, { useEffect, useState } from 'react';
import Appbar from '../trainer/components/Appbar';

const TraineesPhotos = () => {
  const [photos, setPhotos] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchPhotos = async () => {
      try {
        const response = await fetch('/trainees/1/photos');
        if (!response.ok) {
          throw new Error(`HTTP error! status: ${response.status}`);
        }
        const data = await response.json();
        setPhotos(data);
        setLoading(false);
      } catch (err) {
        setError(err);
        setLoading(false);
      }
    };

    fetchPhotos();
  }, []);

  if (loading) return <div className="flex h-screen items-center justify-center">Loading...</div>;
  if (error) return <div className="flex h-screen items-center justify-center">Error: {error.message}</div>;

  return (
    <div className="flex h-screen">
      <Appbar />
      <div className="overflow-x-auto w-full">
        <div className="m-5">
          <h1 className="text-xl font-semibold mb-4">Trainee Photos</h1>
          <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-4">
            {photos.map((photo, index) => (
              <img
                key={index}
                src={photo}
                alt={`Trainee ${index + 1}`}
                className="w-full h-auto rounded-lg shadow-md object-cover"
              />
            ))}
          </div>
        </div>
      </div>
    </div>
  );
};

export default TraineesPhotos;
