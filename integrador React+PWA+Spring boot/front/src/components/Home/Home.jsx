import React from 'react'
//import { Image } from 'react-native';

function Home() {
  return (
    <div class="container">
    <h2>Bienvenido</h2>
    <p> Sistema de Gestion para Biblioteca Publica. 
        Controle y administre de forma optica y facil el flujo de prestamos y devoluciones de Libros.
        Esta herramienta le permitira llevar un control completo y detallado de su Biblioteca, 
        tendra acceso a herramientas especiales para tareas especificas, como lo son: </p>
    {//<Image src="assets/img/libro.jpg"/>}
    <ul>
        <li>Préstamos</li>
        <li>Devoluciones</li>
        <li>Registro de Usuarios y Libros Nuevos</li>
        <li>Edicion de Usuarios y Libros existentes</li>
        <li>Eliminar todo tipo de Registros</li>
        <li>Seccion de Reportes de acciones en el sistema</li>
    </ul>
</div>
  )
}

export default Home