import React from 'react';
import IconTile from '../trainer/components/IconTile';
import NumberTile from '../trainer/components/NumberTile';
import Appbar from '../trainer/components/Appbar';
import { useParams } from 'react-router-dom';
import TraineeAppbar from './TraineeAppbar';
export default function TraineeDashboard() {
    const { traineeId } = useParams();
    return (
        <div className='flex h-screen'>
            <TraineeAppbar />
            <div className="overflow-x-auto w-full">
                <div className="grid grid-cols-3 gap-20 ml-5">
                    <IconTile icon="🏋️" label="Training Plan" to={`/trainee/${traineeId}/workoutplans`}/>
                    <IconTile icon="🏋️" label="Current Training Plan" to={`/trainee/${traineeId}/workoutplans/current`}/>
                    <IconTile icon="✉️" label="Reports" to={`/trainee/${traineeId}/reports`}/>
                    <IconTile icon="📏" label="Measurements" to={`/trainee/${traineeId}/measurements`}/>
                    <IconTile icon="📷" label="Photos" to={`/trainee/${traineeId}/photos`}/>
                    <IconTile icon="👨‍🏫" label="Trainer" to={`/trainee/${traineeId}/trainer`}/>
                </div>
            </div>
        </div>
    );
}
