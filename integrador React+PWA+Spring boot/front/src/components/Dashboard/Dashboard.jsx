/* eslint-disable jsx-a11y/anchor-is-valid */
import React from 'react'

function Dashboard() {
  return (
    <header>
    <p> iLibs</p>
    <nav>
        <ul class="list-group menu-collapsed">
            <li><a class="list-group-item list-group-item-action active" aria-current="true"> Principal </a></li>
            <li><a class="list-group-item list-group-item-action active" aria-current="true"> Prestamos </a></li>
            <li><a class="list-group-item list-group-item-action active" aria-current="true"> Devoluciones </a></li>
            <li><a class="list-group-item list-group-item-action active" aria-current="true"> Usuarios </a></li>
            <li><a class="list-group-item list-group-item-action active" aria-current="true"> Libros </a></li>
            <li><a class="list-group-item list-group-item-action active" aria-current="true"> Reportes </a></li>
        </ul>
    </nav>
</header>
  )
}

export default Dashboard