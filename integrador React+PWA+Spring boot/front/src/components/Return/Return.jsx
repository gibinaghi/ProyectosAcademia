/* eslint-disable jsx-a11y/alt-text */
import React from 'react'
import { TextInput } from 'react-native';
import '../../assets/styles/Retun.css';
import libroImg from '../../assets/img/libro.png';

function Return() {
  return (
    <div class="container">
      <h2>Devolución de libro</h2>
      <div class="row">
          <div class="col-8">
              <form>
                  <div class="form-group">
                    <label>Folio usuario</label>
                    <TextInput type="text" class="form-control" placeholder="Ingrese el folio del usuario" formControlName="user_id"/>
                  </div>
                  <div class="form-group">
                    <label>Libro Id</label>
                    <TextInput type="text" class="form-control" placeholder="Ingrese el Id del libro a prestar" formControlName="book_id"/>
                  </div>
                  <button type="submit" class="btn btn-primary action" >Devolver</button>
                </form>
                
          </div>
          <div class="col-4 foto">
              <img src={libroImg}/>
          </div>
      </div>  
  </div>
  )
}

export default Return