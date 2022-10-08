/* eslint-disable jsx-a11y/anchor-is-valid */
import React from 'react'
import '../../assets/styles/Dashboard.css';

function Dashboard() {
  return (
    <header>
    <p class="titulo"> iLibs</p>
    <nav class="nav">
        <ul class="list-group menu-collapsed ul">
            <li class="list"><a href='/' class="list-group-item  menu" aria-current="true"> Principal </a></li>
            <li class="list"><a href='/lendings' class="list-group-item  menu" aria-current="true"> Prestamos </a></li>
            <li class="list"><a href='/retuns' class="list-group-item  menu" aria-current="true"> Devoluciones </a></li>
            <li class="list"><a href='/users' class="list-group-item  menu" aria-current="true"> Usuarios </a></li>
            <li class="list"><a href='/books' class="list-group-item  menu" aria-current="true"> Libros </a></li>
            <li class="list"><a href='/reports' class="list-group-item  menu" aria-current="true"> Reportes </a></li>
        </ul>
    </nav>
</header>
  )
}

export default Dashboard