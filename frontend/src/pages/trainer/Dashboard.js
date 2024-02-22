import React from 'react';
import NumberTile from './NumberTile';
import IconTile from './IconTile';

export default function Dashboard() {
    return (
        <div className="grid grid-cols-3 gap-20 ml-5">
            <NumberTile number="1" label="Trainees" to="/page1" />
            <IconTile icon="🏠" label="Home" to="/home" />
            <IconTile icon="👤" label="Profile" to="/profile" />
            <IconTile icon="✉️" label="Messages" to="/messages" />
            <IconTile icon="⚙️" label="Settings" to="/settings" />
            <IconTile icon="ℹ️" label="About" to="/about" />
        </div>
    );
}
