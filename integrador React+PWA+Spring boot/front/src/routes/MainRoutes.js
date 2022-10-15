import React from 'react'
import { Route, Routes } from "react-router-dom";
import Dashboard from '../components/Dashboard/Dashboard';
import Home from '../components/Home/Home';
import PreHeader from '../components/PreHeader/PreHeader';
import Headboard from '../components/HeadBoard/HeadBoard';
import Book from '../components/Book/Book';
import BookCreate from '../components/Book/BookCreate';
import BookUpdate from '../components/Book/BookUpdate';
import User from '../components/User/User';
import UserCreate from '../components/User/UserCreate';
import UserUpdate from '../components/User/UserUpdate';
import Lending from '../components/Lending/Lending';
import Reports from '../components/Reports/Reports';
import Footer from '../components/Footer/Footer';

function MainRoutes() {
  return (
    <div>
        <Dashboard />
        <PreHeader />
        <Headboard />
        <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/users" element={<User />} />
            <Route path="/create-user" element={<UserCreate />} />
            <Route path="/update-user" element={<UserUpdate />} />
            <Route path="/books" element={<Book />} />
            <Route path="/create-book" element={<BookCreate />} />
            <Route path="/update-book" element={<BookUpdate />} />
            <Route path="/lendings" element={<Lending />} />
            <Route path="/reports" element={<Reports />} />
        </Routes>
        <Footer />
    </div>
  )
}

export default MainRoutes