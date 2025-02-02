import React, { useState } from 'react';
import { Link, Routes, Route } from 'react-router-dom';

import './App.css';
import Button from '@mui/material/Button';
import Box from '@mui/material/Box';
import Drawer from '@mui/material/Drawer';
import AppBar from '@mui/material/AppBar';
import CssBaseline from '@mui/material/CssBaseline';
import Toolbar from '@mui/material/Toolbar';
import List from '@mui/material/List';
import Typography from '@mui/material/Typography';
import ListItem from '@mui/material/ListItem';
import ListItemButton from '@mui/material/ListItemButton';
import ListItemIcon from '@mui/material/ListItemIcon';
import ListItemText from '@mui/material/ListItemText';
import AccountCircle from '@mui/icons-material/AccountCircle';
import People from '@mui/icons-material/People'
import Category from '@mui/icons-material/Category';
import ListAlt from '@mui/icons-material/ListAlt';
import Diversity3 from '@mui/icons-material/Diversity3';
import Poll from '@mui/icons-material/Poll';
import Logout from '@mui/icons-material/Logout';


import Users from './components/users/users';
import Dashboard from './components/dashboard/dashboard';


const drawerWidth = 240;

export default function App() {
    const[sidebarList, setSidebarList] = useState([
        {label: 'Profile', icon:<AccountCircle/>, path:'/'},
        {label: 'Dashboard', icon: <Poll/>, path:'/dashboard' },
        {label: 'Users', icon:<People/>, path:'/users'},
        {label: 'Products', icon: <Category/>, path:'/'},
        {label: 'Orders', icon: <ListAlt/>, path:'/'},
        {label: 'Agents', icon:<Diversity3/>, path:'/'},
        {label: 'Logout', icon: <Logout/>}
    ])
  return (
    <Box sx={{ display: 'flex' }}>
      <CssBaseline />
      <AppBar position="fixed" sx={{ zIndex: (theme) => theme.zIndex.drawer + 1 }}>
        <Toolbar>
          <Typography variant="h6" noWrap component="div">
            Sai Automobiles
          </Typography>          
        </Toolbar>
      </AppBar>
      <Drawer
        variant="permanent"
        sx={{
          width: drawerWidth,
          flexShrink: 0,
          [`& .MuiDrawer-paper`]: { width: drawerWidth, boxSizing: 'border-box' },
        }}
      >
        <Toolbar />
        <Box sx={{ overflow: 'auto' }}>
          <List>
            {sidebarList.map((text, index) => (
              <ListItem key={index} disablePadding>
                <ListItemButton button component={Link} to={text.path}> 
                    <ListItemIcon>
                          {text.icon}
                      </ListItemIcon>
                    <ListItemText primary={text.label} />                   
                </ListItemButton>
              </ListItem>
            ))}
          </List>
        </Box>
      </Drawer>

        <div style={{ marginTop: '64px', padding: '20px' }}>
        <Routes>
                <Route path='/' element={<Dashboard/>}/>
                <Route path='/users' element={<Users/>}/>
                <Route path='/dashboard' element={<Dashboard/>}/>
              </Routes>
        </div>
      

    </Box>
  );
}
