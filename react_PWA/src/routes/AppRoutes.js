import React from 'react'
import {Routes} from 'react-router-dom'
import {Route} from 'react-router-dom'
import HomePage from '../components/HomePage'
import Registrarse from '../components/Registrarse'
import Login from '../components/Login'
import GrillaPersonajes from '../components/GrillaPersonajes'
import Navbar from '../components/Navbar'
import Footer from '../components/Footer'
import FetchConection from '../components/FetchConection'
import Home from '../components/Home'

const AppRoutes = () => {
    return (
        <>
            <Navbar />
            <Routes>
                <Route path="/" element={<HomePage />} />
                <Route path="/registrarse" element={<Registrarse />} />
                <Route path="/login" element={<Login />} />
                <Route path="/grillapersonajes" element={<GrillaPersonajes/>} />
                <Route path="/fetch" element={<FetchConection/>} />
                <Route path="/home" element={<Home/>} />
            </Routes>
            <Footer />
        </>
)
}

export default AppRoutes
