/* eslint-disable jsx-a11y/alt-text */
import React, { useState } from 'react'
import libroImg from '../../assets/img/prestamo.png';
import '../../assets/styles/Lending.css';
import '../../assets/styles/StyleGeneral.css';
import LendingService from '../../service/LendingService';

function createLending(userId, bookId) {
  const res = LendingService.createLending(userId, bookId);
  console.log(res);
}

function Lending() {

  const [userCreate, setUserCreate] = useState({
    userId: 0,
    bookId: 0,
  })

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
              type="submit" 
              class="btn btn-primary action"
              onClick={() => createLending(userCreate.userId, userCreate.bookId)}
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