import React from 'react';
import IconTile from '../trainer/components/IconTile';
import NumberTile from '../trainer/components/NumberTile';
import Appbar from '../trainer/components/Appbar';

export default function TraineeDashboard({ id }) {
    return (
        <div className='flex h-screen'>
            <Appbar/>
            <div className="overflow-x-auto w-full">
                <div className="grid grid-cols-3 gap-20 ml-5">
                    <IconTile icon="🏋️" label="Training Plan" to={`/trainee/${id}/workoutplans`}/>
                    <IconTile icon="✉️" label="Reports" to={`/trainee/${id}/reports`}/>
                    <IconTile icon="📏" label="Measurements" to={`/trainee/${id}/measurements`}/>
                    <IconTile icon="📷" label="Photos" to={`/trainee/${id}/photos`}/>
                    <IconTile icon="👨‍🏫" label="Trainer" to={`/trainee/${id}/trainer`}/>
                </div>
            </div>
        </div>
    );
}
