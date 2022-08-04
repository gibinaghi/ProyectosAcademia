import React from 'react'
import { useDispatch, useSelector } from 'react-redux';
import { useEffect } from 'react'
import { getCharacters } from '../redux/actions/getCharacters';
import GrillaPersonajes from './GrillaPersonajes';
import Grid from '@mui/material/Grid';
import Button from '@mui/material/Button';
import Container from '@mui/material/Container';
import ArrowBackIosNewIcon from '@mui/icons-material/ArrowBackIosNew';


function FetchConection() {
    const dispatch = useDispatch();
    const characters = useSelector((state) => state.characters);
    
    useEffect(() => {
        dispatch(getCharacters());
    }, [dispatch]);

    const color = {
        backgroundColor: '#004d40',
        color: '#e0f2f1',
        borderRadius: '5px',
        padding: '10px',
        margin: '15px',    
    }

    const style = {
        padding: '5px',
    }

    return (
        <Container style={style}>
            <Button disableElevation style={color} href="/home"> 
                <ArrowBackIosNewIcon />
                <p>Volver</p>
            </Button>
            <Grid container spacing={3}>
            {characters.map((c) => 
                <Grid item xs={12} sm={6} md={3}>
                <GrillaPersonajes 
                    id={c.id} 
                    name={c.name}
                    species={c.species}
                    status={c.status}
                    gender={c.gender}
                    image={c.image} 
                /> 
                </Grid>
            )} 
            </Grid>
        </Container> 
    )
}

export default FetchConection