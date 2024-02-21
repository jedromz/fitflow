import React from 'react';
import { AppBar, Toolbar, Typography, Button, Drawer, List, ListItem, ListItemIcon, ListItemText } from '@mui/material';
import { Home, FitnessCenter, Fastfood } from '@mui/icons-material';
import DashboardCard from './DashboardCard'; // Make sure the path is correct
import 'tailwindcss/tailwind.css';

export default function Dashboard() {
    return (
        <div className="App flex flex-col">
            <AppBar position="static">
                <Toolbar>
                    <div className="ml-48 flex flex-grow">
                        <Typography variant="h6" className="flex-grow">
                            Personal Trainer Dashboard
                        </Typography>
                        <Button color="inherit">Login</Button>
                    </div>
                </Toolbar>
            </AppBar>
            <div className="flex flex-grow">
                <Drawer variant="permanent" anchor="left" className="w-64 flex-shrink-0">
                    <div className="p-4">
                        <Typography variant="h6">
                            Menu
                        </Typography>
                    </div>
                    <List>
                        {[{text: 'Home', icon: <Home/>}, {text: 'Workouts', icon: <FitnessCenter/>}, {
                            text: 'Nutrition',
                            icon: <Fastfood/>
                        }].map((item, index) => (
                            <ListItem button key={item.text}>
                                <ListItemIcon>{item.icon}</ListItemIcon>
                                <ListItemText primary={item.text}/>
                            </ListItem>
                        ))}
                    </List>
                </Drawer>
                <main className="flex-grow" style={{marginTop: 64}}>
                    <div className="p-4">
                        <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 gap-4">
                            <DashboardCard
                                title="Shrimp and Chorizo Paella"
                                subheader="September 14, 2016"
                                imageUrl="https://upload.wikimedia.org/wikipedia/commons/f/fb/Paella-mixta.jpg"
                                imageAlt="Paella dish"
                                description="This impressive paella is a perfect party dish and a fun meal to cook together with your guests. Add 1 cup of frozen peas along with the mussels, if you like."
                            />
                            <DashboardCard
                                title="Shrimp and Chorizo Paella"
                                subheader="September 14, 2016"
                                imageUrl="https://upload.wikimedia.org/wikipedia/commons/f/fb/Paella-mixta.jpg"
                                imageAlt="Paella dish"
                                description="This impressive paella is a perfect party dish and a fun meal to cook together with your guests. Add 1 cup of frozen peas along with the mussels, if you like."
                            />
                            <DashboardCard
                                title="Shrimp and Chorizo Paella"
                                subheader="September 14, 2016"
                                imageUrl="https://upload.wikimedia.org/wikipedia/commons/f/fb/Paella-mixta.jpg"
                                imageAlt="Paella dish"
                                description="This impressive paella is a perfect party dish and a fun meal to cook together with your guests. Add 1 cup of frozen peas along with the mussels, if you like."
                            />
                            <DashboardCard
                                title="Shrimp and Chorizo Paella"
                                subheader="September 14, 2016"
                                imageUrl="https://upload.wikimedia.org/wikipedia/commons/f/fb/Paella-mixta.jpg"
                                imageAlt="Paella dish"
                                description="This impressive paella is a perfect party dish and a fun meal to cook together with your guests. Add 1 cup of frozen peas along with the mussels, if you like."
                            />
                            <DashboardCard
                                title="Shrimp and Chorizo Paella"
                                subheader="September 14, 2016"
                                imageUrl="https://upload.wikimedia.org/wikipedia/commons/f/fb/Paella-mixta.jpg"
                                imageAlt="Paella dish"
                                description="This impressive paella is a perfect party dish and a fun meal to cook together with your guests. Add 1 cup of frozen peas along with the mussels, if you like."
                            />
                            <DashboardCard
                                title="Shrimp and Chorizo Paella"
                                subheader="September 14, 2016"
                                imageUrl="https://upload.wikimedia.org/wikipedia/commons/f/fb/Paella-mixta.jpg"
                                imageAlt="Paella dish"
                                description="This impressive paella is a perfect party dish and a fun meal to cook together with your guests. Add 1 cup of frozen peas along with the mussels, if you like."
                            />
                        </div>
                    </div>
                </main>
            </div>

        </div>
    );
}
