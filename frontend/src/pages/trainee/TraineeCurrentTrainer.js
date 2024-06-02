import React, { useEffect, useState } from 'react';
import Appbar from '../trainer/components/Appbar';

const TraineeCurrentTrainer = () => {
  const [trainer, setTrainer] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchTrainer = async () => {
      try {
        const response = await fetch('/api/trainees/1/trainers/current');
        if (!response.ok) {
          throw new Error(`HTTP error! status: ${response.status}`);
        }
        const data = await response.json();
        setTrainer(data);
        setLoading(false);
      } catch (err) {
        setError(err);
        setLoading(false);
      }
    };

    fetchTrainer();
  }, []);

  if (loading) return <div className="flex h-screen items-center justify-center">Loading...</div>;
  if (error) return <div className="flex h-screen items-center justify-center">Error: {error.message}</div>;

  return (
    <div className="flex h-screen">
      <Appbar />
      <div className="overflow-x-auto w-full">
        <div className="m-5">
          <h1 className="text-xl font-semibold mb-4">Current Trainer</h1>
          {trainer && (
            <div className="bg-white shadow-md rounded-lg p-6">
              <h2 className="text-2xl font-bold mb-2">{trainer.name}</h2>
              <p className="text-gray-700"><strong>Email:</strong> {trainer.email}</p>
              <p className="text-gray-700"><strong>Phone:</strong> {trainer.phone}</p>
            </div>
          )}
        </div>
      </div>
    </div>
  );
};

export default TraineeCurrentTrainer;
