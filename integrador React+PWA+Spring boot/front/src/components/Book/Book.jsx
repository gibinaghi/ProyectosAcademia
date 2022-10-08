import React from 'react'
import '../../assets/styles/StyleGeneral.css';
import { Link } from "react-router-dom";

function Book() {
  return (
    <div class="container">
    <h2 class="title">Libros</h2>

    <div class="input-group mb-3 texto-search">
      <input
        type="text"
        class="form-control"
        placeholder="Ingrese el título del libro a buscar"
        formControlName="nombreUsuario"
      />
      <div class="input-group-append">
        <button class="btn btn-primary action search" type="button">
          Buscar
        </button>
      </div>
    </div>

    <table class="table table-bordered">
      <thead class="thead-dark">
        <tr>
        <th scope="col">Cod</th>
            <th scope="col">Título</th>
            <th scope="col">Autor</th>
            <th scope="col">Categoria</th>
            <th scope="col">Edición</th>
            <th scope="col">Idioma</th>
            <th scope="col">Stock</th>
            <th scope="col">Disponible</th>
            <th scope="col">Operaciones</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>Nombre</td>
          <td>Nombre</td>
          <td>Nombre</td>
          <td>Nombre</td>
          <td>Nombre</td>
          <td>Nombre</td>
          <td>Nombre</td>
          <td>Nombre</td>
          <td>
            <button type="button" class="btn btn-primary action">
              <Link to="/update-book" class="colorBtnText">Editar</Link> 
             </button>
             <button type="button" class="btn btn-primary action">
              <Link to="/books" class="colorBtnText">Borrar</Link>
             </button>
           </td>
        </tr>
      </tbody>
    </table>

    <button
      type="button"
      class="btn btn-primary action"
    >
      <Link to="/create-book" class="colorBtnText">Nuevo</Link> 
    </button>
</div>
  )
}

export default Book