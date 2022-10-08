import React from 'react'
import { Link } from "react-router-dom";

function BookUpdate() {
  return (
    <div class="container">
      <h2 class="title">Editar libro</h2>
      <form>
      <div class="row">
          <div class="col-6">
                  <div class="form-group">
                    <label>Libro id</label>
                    <input type="text" class="form-control" placeholder="Ingrese el Id de libro" formControlName="id"/>
                  </div>
                  <div class="form-group">
                    <label>Titulo</label>
                    <input type="text" class="form-control" placeholder="Ingrese el título del libro" formControlName="title"/>
                  </div>
                  <div class="form-group">
                      <label>Fecha de publicación</label>
                      <input type="text" class="form-control" placeholder="Ingrese la fecha de publicación" formControlName="date"/>
                  </div>
                  <div class="form-group">
                      <label>Autor</label>
                      <input type="text" class="form-control" placeholder="Ingrese el nombre del autor" formControlName="author"/>
                  </div>
                  <div class="form-group">
                      <label>Categoría</label>
                      <input type="text" class="form-control" placeholder="Ingrese la categoría del libro" formControlName="category"/>
                  </div>  
          </div>
          <div class="col-6">
                  
                      <div class="form-group">
                          <label>Edición</label>
                          <input type="text" class="form-control" placeholder="Ingrese la edición" formControlName="edit"/>
                      </div>
                      <div class="form-group">
                        <label>Idioma</label>
                        <input type="text" class="form-control" placeholder="Ingrese el idioma del libro" formControlName="lang"/>
                      </div>
                      <div class="form-group">
                        <label>Descripción</label>
                        <input type="text" class="form-control" placeholder="Ingrese la descripción de libro" formControlName="description"/>
                      </div>
                      <div class="form-group">
                          <label>Stock</label>
                          <input type="text" class="form-control" placeholder="Cantidad total" formControlName="stock"/>
                      </div>
                      <div class="form-group">
                          <label>Disponibles</label>
                          <input type="text" class="form-control" placeholder="Cantidad a prestar" formControlName="available"/>
                      </div>
                      <button type="submit" class="btn btn-primary action">
                        <Link to="/books" class="colorBtnText">Editar</Link>
                      </button>
                    
          </div>
        
      </div> 
    </form> 
</div>
  )
}

export default BookUpdate