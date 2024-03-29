import * as React from 'react';
import Avatar from '@mui/material/Avatar';
import Button from '@mui/material/Button';
import CssBaseline from '@mui/material/CssBaseline';
import TextField from '@mui/material/TextField';
import FormControlLabel from '@mui/material/FormControlLabel';
import Checkbox from '@mui/material/Checkbox';
import Link from '@mui/material/Link';
import Grid from '@mui/material/Grid';
import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import {useDispatch} from 'react-redux';
import {useNavigate} from 'react-router-dom';
import Swal from 'sweetalert2';
import {login} from '../redux/actions/getCharacters';
import InputIcon from '@mui/icons-material/Input';

function Copyright(props) {
    return (
        <Typography variant="body2" color="text.secondary" align="center" {...props}>
        {'Copyright © '}
        <Link color="inherit" href="https://github.com/gibinaghi">
            GitHub
        </Link>{' '}
        {new Date().getFullYear()}
        {'.'}
        </Typography>
    );
}

const theme = createTheme();
const style = {
    backgroundColor: '#004d40',
    color: '#e0f2f1',
}

export default function Login() {
    const dispatch = useDispatch() 
    const navigate = useNavigate()

    const handleSubmit = (event) => {
    const dataEmail = 'gimenabinaghi@gmail.com';
    const dataPassword = '12345'
    const data = new FormData(event.currentTarget);
    const email = data.get('email');
    const password = data.get('password');

    if(email === dataEmail && password === dataPassword){
        dispatch(login())
        navigate('/home')
    }else{
        Swal.fire({
            icon:'error',
            title:'Error...!!',
            text:'email o password incorrectos',
            imageUrl: "https://arc-anglerfish-arc2-prod-copesa.s3.amazonaws.com/public/EEUWJOBQF5ASVDETG7KSGCPDHY.jpg",
            imageWidth: 400,
            imageHeight: 200,
            imageAlt: "Custom image",
    })  
    }
};


    return (
        <ThemeProvider theme={theme}>
        <Container component="main" maxWidth="xs">
            <CssBaseline />
            <Box
            sx={{
                marginTop: 8,
                display: 'flex',
                flexDirection: 'column',
                alignItems: 'center',
            }}
            >
            <Avatar sx={{ m: 1, bgcolor: '#004d40' }}>
                <InputIcon />
            </Avatar>
            <Typography component="h1" variant="h5">
                Ingresar
            </Typography>
            <Box component="form" onSubmit={handleSubmit} noValidate sx={{ mt: 1 }}>
                <TextField
                margin="normal"
                required
                fullWidth
                id="email"
                label="Email"
                name="email"
                autoComplete="email"
                autoFocus
                />
                <TextField
                margin="normal"
                required
                fullWidth
                name="password"
                label="Contraseña"
                type="password"
                id="password"
                autoComplete="current-password"
                />
                <FormControlLabel
                control={<Checkbox value="remember" color="primary" />}
                label="Recordar"
                />
                <Button
                    type="submit"
                    fullWidth
                    variant="contained"
                    sx={{ mt: 3, mb: 2 }}
                    style={style}
                >
                Ingresar
                </Button>
                <Grid container>
                <Grid item xs>
                    <Link href="#" variant="body2">
                    ¿Olvidaste la contraseña?
                    </Link>
                </Grid>
                <Grid item>
                    <Link href="/registrarse" variant="body2">
                    {"¿No tienes una cuenta? Registrate"}
                    </Link>
                </Grid>
                </Grid>
            </Box>
            </Box>
            <Copyright sx={{ mt: 8, mb: 4 }} />
        </Container>
        </ThemeProvider>
    );
}