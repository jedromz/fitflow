import React from 'react';
import NumberTile from './NumberTile';
import IconTile from './IconTile';
import Appbar from './Appbar';

export default function Dashboard(id) {
    return (
        <div className='flex h-screen'>
            <Appbar/>
            <div className="overflow-x-auto w-full">
                <div className="grid grid-cols-3 gap-20 ml-5">
                    <NumberTile number="1" label="Mentorships" to="/trainer/123/mentorships"/>
                    <IconTile icon="🏋️" label="Workouts" to="/trainer/123/workouts"/>
                    <IconTile icon="👤" label="Trainees" to="/trainer/123/trainees"/>
                    <IconTile icon="✉️" label="Reports" to="/trainer/123/reports"/>
                    <IconTile icon="🔨" label="Plan Builder" to="/trainer/123/builder"/>
                    <IconTile icon="💪" label="Exercises" to="/exercises"/>
                </div>
            </div>
        </div>
    );
}
