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
                    <NumberTile number="1" label="Mentorships" to="/page1"/>
                    <IconTile icon="🏠" label="Home" to="/home"/>
                    <IconTile icon="👤" label="Trainees" to="/trainer/123/trainees"/>
                    <IconTile icon="✉️" label="Reports" to="/messages"/>
                    <IconTile icon="⚙️" label="Workouts" to="/settings"/>
                    <IconTile icon="ℹ️" label="Exercises" to="/exercises"/>
                </div>
            </div>
        </div>
    );
}
