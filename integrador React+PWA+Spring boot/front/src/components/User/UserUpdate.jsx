import React from 'react'
import { Link } from "react-router-dom";

function UserUpdate() {
  return (
    <div class="container">
    <form>
      <h2 class="title">Editar usuario</h2>
      <div class="row">
          <div class="col-6">
              
                  <div class="form-group">
                    <label>Nombre</label>
                    <input type="text" class="form-control" placeholder="Ingrese el nombre"/>
                  </div>
                  <div class="form-group">
                    <label>Apellido</label>
                    <input type="text" class="form-control" placeholder="Ingrese el apellido" />
                  </div>
                  <div class="form-group">
                      <label>DNI</label>
                      <input type="text" class="form-control" placeholder="Ingrese el DNI"/>
                    </div>
                
          </div>
          <div class="col-6 foto">
                      <div class="form-group">
                        <label>Domicilio</label>
                        <input type="text" class="form-control" placeholder="Ingrese el domicilio"/>
                      </div>
                      <div class="form-group">
                        <label>Teléfono</label>
                        <input type="text" class="form-control" placeholder="Ingrese un número telefónico"/>
                      </div>
                      <button type="button" class="btn btn-primary action">
                        <Link to="/users" class="colorBtnText">Editar</Link>
                      </button>
              </div>
      </div>  
    </form>
  </div>
  )
}

export default UserUpdate