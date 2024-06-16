import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import Appbar from '../components/Appbar';
import DefaultTable from '../../../components/DefaultTable';

export default function MentorshipsList() {
  const [mentorships, setMentorships] = useState([]);
  const [showModal, setShowModal] = useState(false);
  const [newMentorship, setNewMentorship] = useState({
    startDate: '',
    endDate: '',
    price: 0,
    traineeName: '',
    email: '',
    name: '',
    type: ''
  });
  const [trainees, setTrainees] = useState([]);
  const { trainerId } = useParams();

  useEffect(() => {
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
    fetch(`/api/trainers/${trainerId}/trainees`)
      .then(response => response.json())
      .then(data => setTrainees(data))
      .catch(error => console.error("There was an error fetching the trainees: ", error));
  }, [trainerId]);

  const handleAddNewMentorship = () => {
    setShowModal(true);
  };

  const handleSubmit = async (event) => {
    event.preventDefault();

    const mentorshipData = {
      traineeEmail: newMentorship.email,
      trainerId: trainerId,
      fromDate: newMentorship.startDate,
      toDate: newMentorship.endDate,
      price: newMentorship.price,
      type: newMentorship.type,
      traineeName: newMentorship.traineeName,
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
    } catch (error) {
      console.error('Error during mentorship creation:', error);
    }
  };

  const handleChange = (event) => {
    const { name, value } = event.target;
    setNewMentorship(prevState => ({ ...prevState, [name]: value }));
    console.log(newMentorship);
  };

  const handleSelectTrainee = (event) => {
    setNewMentorship(prevState => ({
      ...prevState,
      traineeId: event.target.value,
      traineeSource: 'existing_trainee'
    }));
    console.log(newMentorship);
  };

  const handleNewTraineeEntry = (event) => {
    const { name, value } = event.target;
    setNewMentorship(prevState => ({ ...prevState, [name]: value, traineeSource: 'new_trainee ' }));
    console.log(newMentorship);
  };

  const headers = ['Start Date', 'End Date', 'Price', 'Trainee'];
  const rows = mentorships.map(mentorship => [
    mentorship.fromDate,
    mentorship.toDate,
    mentorship.price,
    mentorship.trainee_Name
  ]);

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
          <DefaultTable headers={headers} rows={rows} />
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
                  name="email"
                  value={newMentorship.traineeId}
                  onChange={handleSelectTrainee}
                >
                  <option value="">Select Trainee</option>
                  {trainees.map((trainee) => (
                    <option key={trainee.id} value={trainee.email}>
                      {trainee.name}
                    </option>
                  ))}
                </select>
                <input
                  className="mt-2 p-2 w-full border rounded-md"
                  name="traineeName"
                  type="text"
                  value={newMentorship.traineeName}
                  onChange={handleNewTraineeEntry}
                  required
                />
                <input
                  className="mt-2 p-2 w-full border rounded-md"
                  name="email"
                  type="email"
                  value={newMentorship.email}
                  onChange={handleNewTraineeEntry}
                />
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