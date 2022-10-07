/* eslint-disable jsx-a11y/alt-text */
import React from 'react'
import libroImg from '../../assets/img/principal.jpg';
import '../../assets/styles/Home.css';
import '../../assets/styles/StyleGeneral.css';

function Home() {
  return (
    <section class="container">
    <h2 class="title">Bienvenido</h2>
    <p class="parrafo"> Sistema de Gestion para Biblioteca Publica. 
        Controle y administre de forma optica y facil el flujo de prestamos y devoluciones de Libros.
        Esta herramienta le permitira llevar un control completo y detallado de su Biblioteca, 
        tendra acceso a herramientas especiales para tareas especificas, como lo son: </p>
    <img class="homeimg" src={libroImg}/>
    <ul class="listaHome">
        <li>Préstamos</li>
        <li>Devoluciones</li>
        <li>Registro de Usuarios y Libros Nuevos</li>
        <li>Edicion de Usuarios y Libros existentes</li>
        <li>Eliminar todo tipo de Registros</li>
        <li>Seccion de Reportes de acciones en el sistema</li>
    </ul>
</section>
  )
}

export default Home