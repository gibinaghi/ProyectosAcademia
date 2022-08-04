import * as React from 'react';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Typography from '@mui/material/Typography';
import BasicModal from './Modal';


const GrillaPersonajes = ({id, name, image, species, status, gender}) => {
    
    const color = {
        color: '#004d40',
    };
    const style = {
        maxWidth: 345,
        width: '100%',
        height: '100%',
        margin: '0 auto',
        boxShadow: 50,
        borderRadius: '10px',
        p: '10px',
    };


    return (
        <Card style={style}>
        <CardMedia 
            component="img"
            height="140"
            image={image}
            alt={name}
        />
        <CardContent>
            <Typography gutterBottom variant="h5" component="div" sx={color}>
                <h3> Personaje: {name} </h3>
            </Typography>
            <BasicModal 
                id={id}
                name={name}
                species={species}
                status={status}
                gender={gender}
            />
        </CardContent>
        </Card>     
);
}

export default GrillaPersonajes;
