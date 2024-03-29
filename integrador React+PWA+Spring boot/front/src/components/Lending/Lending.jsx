/* eslint-disable jsx-a11y/alt-text */
import React, { useState } from 'react'
import libroImg from '../../assets/img/prestamo.png';
import '../../assets/styles/Lending.css';
import '../../assets/styles/StyleGeneral.css';
import LendingService from '../../service/LendingService';
import setTime from '../util/reloadPage';

async function creationLending(userId, bookId) {
  const res = await LendingService.createLendingNew(userId, bookId)
  if(res.response.status === 201){
    window.confirm('Usuario creado correctamente')
    setTime(5000);
  } else {
    window.confirm('No se pudo crear el usuario')
    setTime(5000);
  }

}

function Lending() {

  const [userCreate, setUserCreate] = useState({
    userId: '',
    bookId: ''
  });

  const handleChange = (e) => {
    setUserCreate({
      ...userCreate,
      [e.target.name]: e.target.value
    })
  }


  return (
    <div class="container">
    <h2 class="title" >Nuevo préstamo</h2>
    <div class="row">
      <div class="col-8">
        <form>
            <div class="form-group">
              <label>Código del usuario</label>
              <input 
                type="text" 
                class="form-control" 
                placeholder="Ingrese el código del usuario" 
                formControlName="idUsuario"
                name='userId'
                onChange={handleChange}
                />
            </div>
            <div class="form-group">
              <label>Código de libro</label>
              <input 
                type="text"  
                class="form-control" 
                placeholder="Ingrese el código del libro a prestar" 
                formControlName="idLibro"
                name='bookId'
                onChange={handleChange}
              />
            </div>
            <button 
              type="button" 
              class="btn btn-primary action"
              onClick={() => creationLending(userCreate.userId, userCreate.bookId)}
            >Prestar
            </button>
          </form>
      </div>
        <div class="col-4 foto">
            <img class="imglending" src={libroImg}/>
        </div> 
    </div>  
</div>
  )
}

export default Lending