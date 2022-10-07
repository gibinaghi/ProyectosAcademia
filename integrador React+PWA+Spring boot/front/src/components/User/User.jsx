import React from 'react'
import '../../assets/styles/StyleGeneral.css';

function User() {
  return (
    <div class="container">
    <h2 class="title">Usuarios</h2>

    <div class="input-group mb-3">
      <input
        type="text"
        class="form-control"
        placeholder="Ingrese en nombre del usuario a buscar"
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
          <th scope="col">Nombre</th>
          <th scope="col">Apellido M</th>
          <th scope="col">Apellido P</th>
          <th scope="col">Domicilio</th>
          <th scope="col">Teléfono</th>
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

export default User