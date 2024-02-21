import React from 'react';
import { Card, CardContent, CardHeader, CardMedia, Typography } from '@mui/material';

// Define the component with props
function DashboardCard({ title, subheader, imageUrl, imageAlt, description }) {
    return (
        <Card sx={{ maxWidth: 345 }}>
            <CardHeader
                title={title}
                subheader={subheader}
            />
            <CardMedia
                component="img"
                height="194"
                image={imageUrl}
                alt={imageAlt}
            />
            <CardContent>
                <Typography variant="body2" color="text.secondary">
                    {description}
                </Typography>
            </CardContent>
        </Card>
    );
}

export default DashboardCard;
