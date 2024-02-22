import Appbar from "./Appbar";

export default function Exercises() {
    const exercises = [
        {
            id: 1,
            name: 'Push-up',
            description: 'A conditioning exercise performed in a prone position by raising and lowering the body with the straightening and bending of the arms.',
            category: 'Strength'
        },
        {
            id: 2,
            name: 'Pull-up',
            description: 'An upper-body strength exercise. The pull-up is performed with a palms facing forward position.',
            category: 'Strength'
        },
        {
            id: 3,
            name: 'Squat',
            description: 'A compound, full body exercise that trains primarily the muscles of the thighs, hips and buttocks.',
            category: 'Flexibility'
        },
        // Add more exercises as needed
    ];
    return (
        <div className='flex'>
            <Appbar/>
            <div className="overflow-x-auto w-full">
                <div className="p-5">
                    <h1 className="text-xl font-semibold mb-4">Exercises</h1>
                    <div className="overflow-x-auto relative">
                        <table className="w-full text-sm text-left text-gray-500 dark:text-gray-400">
                            <thead
                                className="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
                            <tr>
                                <th scope="col" className="py-3 px-6">Exercise Name</th>
                                <th scope="col" className="py-3 px-6">Description</th>
                                <th scope="col" className="py-3 px-6">Category</th>
                            </tr>
                            </thead>
                            <tbody>
                            {exercises.map((exercise) => (
                                <tr key={exercise.id}
                                    className="bg-white border-b dark:bg-gray-800 dark:border-gray-700 hover:bg-gray-50 dark:hover:bg-gray-600">
                                    <td className="py-4 px-6">{exercise.name}</td>
                                    <td className="py-4 px-6">{exercise.description}</td>
                                    <td className="py-4 px-6">{exercise.category}</td>
                                </tr>
                            ))}
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    );
}