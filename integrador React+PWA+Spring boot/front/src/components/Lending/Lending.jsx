/* eslint-disable jsx-a11y/alt-text */
import React from 'react'
import libroImg from '../../assets/img/prestamo.png';
import '../../assets/styles/Lending.css';
import '../../assets/styles/StyleGeneral.css';

function Lending() {
  return (
    <div class="container">
    <h2 class="title" >Nuevo préstamo</h2>
    <div class="row">
      <div class="col-8">
        <form>
            <div class="form-group">
              <label>Folio usuario</label>
              <input type="text" class="form-control" placeholder="Ingrese el folio del usuario" formControlName="idUsuario"/>
            </div>
            <div class="form-group">
              <label>Libro Id</label>
              <input type="text"  class="form-control" placeholder="Ingrese el Id del libro a prestar" formControlName="idLibro"/>
            </div>
            <button type="submit" class="btn btn-primary action" >Prestar</button>
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