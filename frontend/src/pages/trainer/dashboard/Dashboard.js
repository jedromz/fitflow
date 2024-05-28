import React from 'react';
import NumberTile from '../components/NumberTile'
import IconTile from '../components/IconTile'
import Appbar  from '../components/Appbar'

export default function Dashboard({ id }) {
    return (
        <div className='flex h-screen'>
            <Appbar/>
            <div className="overflow-x-auto w-full">
                <div className="grid grid-cols-3 gap-20 ml-5">
                    <NumberTile number="1" label="Mentorships" to={`/trainer/${id}/mentorships`}/>
                    <IconTile icon="🏋️" label="Workouts" to={`/trainer/${id}/workouts`}/>
                    <IconTile icon="👤" label="Trainees" to={`/trainer/${id}/trainees`}/>
                    <IconTile icon="✉️" label="Reports" to={`/trainer/${id}/reports`}/>
                    <IconTile icon="🔨" label="Plan Builder" to={`/trainer/${id}/builder`}/>
                    <IconTile icon="💪" label="Exercises" to="/exercises"/>
                </div>
            </div>
        </div>
    );
}
