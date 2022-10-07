import React from 'react'
import '../../assets/styles/StyleGeneral.css';

function Book() {
  return (
    <div class="container">
    <h2 class="title">Libros</h2>

    <div class="input-group mb-3">
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
        <th scope="col">Id</th>
            <th scope="col">Titulo</th>
            <th scope="col">Fecha</th>
            <th scope="col">Autor</th>
            <th scope="col">Categoria</th>
            <th scope="col">Edición</th>
            <th scope="col">Idioma</th>
            <th scope="col">Descripción</th>
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
          <td>Nombre</td>
          <td>Nombre</td>
          <td>
             <button type="button" class="btn btn-primary action">Editar</button>
             <button type="button" class="btn btn-primary action">Borrar</button>
           </td>
        </tr>
      </tbody>
    </table>

    <button
      type="button"
      class="btn btn-primary action"
    >
      Nuevo
    </button>
</div>
  )
}

export default Book