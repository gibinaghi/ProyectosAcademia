import React, { useState }  from 'react'
import UserService from '../../service/UserService';

function createUser(userCreate) {
  const res = UserService.createUser(userCreate)
  if(res.response.status === 201){
    window.location.reload();
  }
}

function UserCreate() {
  const [userCreate, setUserCreate] = useState({
    name: '',
    last_name: '',
    dni: '',
    address: '',
    phone: '',
  })

  const handleChange = (e) => {
    setUserCreate({
      ...userCreate,
      [e.target.name]: e.target.value
    })
  }

  return (
    <div class="container">
    <form>
      <h2 class="title">Crear usuario</h2>
      <div class="row">
          <div class="col-6">
              
                  <div class="form-group">
                    <label>Nombre</label>
                    <input 
                      type="text" 
                      class="form-control" 
                      placeholder="Ingrese el nombre"
                      formControlName="name"
                      name="name"
                      onChange={handleChange}
                    />
                  </div>
                  <div class="form-group">
                    <label>Apellido</label>
                    <input 
                      type="text" 
                      class="form-control" 
                      placeholder="Ingrese el apellido" 
                      formControlName="last_name"
                      name="last_name"
                      onChange={handleChange}
                    />
                  </div>
                  <div class="form-group">
                      <label>DNI</label>
                      <input 
                        type="text" 
                        class="form-control" 
                        placeholder="Ingrese el DNI en formato 11.111.111" 
                        formControlName="dni"
                        name="dni"
                        onChange={handleChange}
                      />
                    </div>
                
          </div>
          <div class="col-6 foto">
                      <div class="form-group">
                        <label>Domicilio</label>
                        <input 
                          type="text" 
                          class="form-control" 
                          placeholder="Ingrese el domicilio" 
                          formControlName="address"
                          name="address"
                          onChange={handleChange}
                        />
                      </div>
                      <div class="form-group">
                        <label>Teléfono</label>
                        <input 
                          type="text" 
                          class="form-control" 
                          placeholder="Ingrese un número telefónico" 
                          formControlName="phone"
                          name="phone"
                          onChange={handleChange}
                        />
                      </div>
                      <button 
                        type="submit" 
                        class="btn btn-primary action" 
                        onClick={() => createUser(userCreate)}
                        >
                        Crear usuario
                      </button>
              </div>
      </div>  
    </form>
  </div>
  )
}

export default UserCreate