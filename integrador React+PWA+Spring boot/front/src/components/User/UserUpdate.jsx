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
                    <input type="text" class="form-control" placeholder="Ingrese el nombre"formControlName="name"/>
                  </div>
                  <div class="form-group">
                    <label>Apellido Paterno</label>
                    <input type="text" class="form-control" placeholder="Ingrese el apellido paterno" formControlName="last_name_p"/>
                  </div>
                  <div class="form-group">
                      <label>Apellido Materno</label>
                      <input type="text" class="form-control" placeholder="Ingrese el apellido materno" formControlName="last_name_m"/>
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
                        <Link to="/users" class="colorBtnText">Editar</Link>
                      </button>
              </div>
      </div>  
    </form>
  </div>
  )
}

export default UserUpdate