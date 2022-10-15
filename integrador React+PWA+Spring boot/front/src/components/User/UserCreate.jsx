import React from 'react'
import { Link } from "react-router-dom";

function UserCreate() {
  return (
    <div class="container">
    <form>
      <h2 class="title">Crear usuario</h2>
      <div class="row">
          <div class="col-6">
              
                  <div class="form-group">
                    <label>Nombre</label>
                    <input type="text" class="form-control" placeholder="Ingrese el nombre"formControlName="name"/>
                  </div>
                  <div class="form-group">
                    <label>Apellido</label>
                    <input type="text" class="form-control" placeholder="Ingrese el apellido" formControlName="last_name"/>
                  </div>
                  <div class="form-group">
                      <label>DNI</label>
                      <input type="text" class="form-control" placeholder="Ingrese el DNI en formato 11.111.111" formControlName="dni"/>
                    </div>
                
          </div>
          <div class="col-6 foto">
                      <div class="form-group">
                        <label>Domicilio</label>
                        <input type="text" class="form-control" placeholder="Ingrese el domicilio" formControlName="domicilio"/>
                      </div>
                      <div class="form-group">
                        <label>Teléfono</label>
                        <input type="text" class="form-control" placeholder="Ingrese un número telefónico" formControlName="tel"/>
                      </div>
                      <button type="submit" class="btn btn-primary action">
                      <Link to="/users" class="colorBtnText">Crear usuario</Link>
                      </button>
              </div>
      </div>  
    </form>
  </div>
  )
}

export default UserCreate