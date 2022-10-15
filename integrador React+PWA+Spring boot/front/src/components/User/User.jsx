import React, { useEffect, useState } from 'react'
import '../../assets/styles/StyleGeneral.css';
import { Link } from "react-router-dom";
import UserService from '../../service/UserService';

function User() {
  const [listUser, setListUser] = useState([]);

  useEffect(() => {
    UserService.getAllUsers()
    .then((response) => {
      setListUser(response.data);
    })
    .catch((error) => {
      console.log(error);
    });
  }, [setListUser])

  return (
    <div class="container">
    <h2 class="title">Usuarios</h2>

    <div class="input-group mb-3 texto-search">
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
          <th scope="col">Cod usuario</th>
          <th scope="col">Nombre</th>
          <th scope="col">Apellido</th>
          <th scope="col">DNI</th>
          <th scope="col">Domicilio</th>
          <th scope="col">Teléfono</th>
          <th scope="col">Operaciones</th>
        </tr>
      </thead>
      <tbody>
      {listUser.map((item) => (
        <tr>
          <td>{item.id}</td>
          <td>{item.name}</td>
          <td>{item.last_name}</td>
          <td>{item.dni}</td>
          <td>{item.address}</td>
          <td>{item.phone}</td>
          <td>
             <button type="button" class="btn btn-primary action">
              <Link to="/update-user" class="colorBtnText">Editar</Link> 
             </button>
             <button type="button" class="btn btn-primary action">
              <Link to="/users" class="colorBtnText">Borrar</Link>
             </button>
           </td>
        </tr>
      ))}
      </tbody>
    </table>

    <button
      type="button"
      class="btn btn-primary action"
    >
      <Link to="/create-user" class="colorBtnText">Nuevo</Link> 
    </button>
</div>
  )
}

export default User