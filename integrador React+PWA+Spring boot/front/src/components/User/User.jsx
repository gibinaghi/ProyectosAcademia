import React, { useEffect, useState } from 'react'
import '../../assets/styles/StyleGeneral.css';
import { Link } from "react-router-dom";
import UserService from '../../service/UserService';
import setTime from '../util/reloadPage';

function deleteUser(id) {
  const response = window.confirm('¿Seguro de que quiere eliminar el usuario?');
  if (response) {
      const res = UserService.deleteUser(id)
      if(res.response.status === 200) {
        window.alert('Usuario eliminado correctamente')
      } else if (res.response.status === 400) {
        window.alert('No se pudo eliminar el usuario')
      }
      setTime(5000);
  }
}

function searchUser(word) {
    UserService.searchUser(word)
}

function User() {
  const [listUser, setListUser] = useState([]);
  const [word, setWord] = useState('');

  useEffect(() => {
    UserService.getAllUsers()
    .then((response) => {
      setListUser(response.data);
    })
    .catch((error) => {
      console.log(error);
    });
  }, [setListUser])
  

  const handleChange = (e) => {
    setWord(e.target.value)
  }


  return (
    <div class="container">
    <h2 class="title">Usuarios</h2>

    <div class="input-group mb-3 texto-search">
      <input
        type="text"
        class="form-control"
        placeholder="Ingrese en nombre del usuario a buscar"
        formControlName="nombreUsuario"
        name="word"
        onChange={handleChange}
      />
      <div class="input-group-append">
        <button class="btn btn-primary action search" type="button" onClick={() => searchUser(word)}>
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
              <Link to="/users" class="colorBtnText" key={item.id} onClick={() => deleteUser(item.id)}>Borrar</Link>
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