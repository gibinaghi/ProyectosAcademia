import React from 'react'
import { Image, TextInput } from 'react-native';

function Lending() {
  return (
    <div class="container">
    <h2>Nuevo préstamo</h2>
    <div class="row">
      <div class="col-8">
        <form>
            <div class="form-group">
              <label>Folio usuario</label>
              <TextInput  type="text" class="form-control" placeholder="Ingrese el folio del usuario" formControlName="idUsuario"/>
            </div>
            <div class="form-group">
              <label>Libro Id</label>
              <TextInput  type="text"  class="form-control" placeholder="Ingrese el Id del libro a prestar" formControlName="idLibro"/>
            </div>
            <button type="submit" class="btn btn-primary action" >Prestar</button>
          </form>
      </div>
        <div class="col-4 foto">
            <Image src="assets/img/prestamo.gif"/>
        </div> 
    </div>  
</div>
  )
}

export default Lending