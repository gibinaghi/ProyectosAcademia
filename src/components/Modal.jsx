import * as React from 'react';
import Box from '@mui/material/Box';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';
import Modal from '@mui/material/Modal';

const style = {
    position: 'absolute',
    top: '50%',
    left: '50%',
    transform: 'translate(-50%, -50%)',
    width: 400,
    boxShadow: 30,
    p: 4,
    textAlign: 'center',
    borderRadius: '7px',
    backgroundColor: '#004d40',
    color: '#e0f2f1'
};
const color = {
    backgroundColor: '#004d40',
    color: '#26A69A'
};

export default function BasicModal({id, species, name, status, gender}) {
    const [open, setOpen] = React.useState(false);
    const handleOpen = () => setOpen(true);
    const handleClose = () => setOpen(false);

    return (
        <div>
        <Button onClick={handleOpen} sx={color}>Open modal</Button>
        <Modal
            open={open}
            onClose={handleClose}
            aria-labelledby="modal-modal-title"
            aria-describedby="modal-modal-description"
        >
            <Box sx={style}>
            <Typography id="modal-modal-title" variant="h6" component="h2">
                Información de {name}
            </Typography>
            <Typography id="modal-modal-description" sx={{ mt: 2 }}>
                <p> Id: {id} </p>
                <p> Especies: {species} </p>
                <p> Estado: {status} </p>
                <p> Género: {gender} </p>
            </Typography>
            </Box>
        </Modal>
        </div>
    );
}