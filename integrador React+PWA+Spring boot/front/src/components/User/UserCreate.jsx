import React, { useState }  from 'react'
import UserService from '../../service/UserService';
import setTime from '../util/reloadPage';

async function createUser(userCreate) {
  const res = await UserService.createUser(userCreate)
  if(res.response.status === 201){
    window.alert('Usuario creado correctamente')
    setTime(5000);
  } else {
    window.alert('No se pudo crear el usuario')
    setTime(5000);
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
                          name="name"
                          onChange={handleChange}
                          required
                        />
                      </div>
                      <div class="form-group">
                        <label>Apellido</label>
                        <input 
                          type="text" 
                          class="form-control" 
                          placeholder="Ingrese el apellido" 
                          name="last_name"
                          onChange={handleChange}
                          required
                        />
                      </div>
                      <div class="form-group">
                          <label>DNI</label>
                          <input 
                            type="text" 
                            class="form-control" 
                            placeholder="Ingrese el DNI en formato 11.111.111" 
                            name="dni"
                            onChange={handleChange}
                            required
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
                              name="phone"
                              onChange={handleChange}
                            />
                          </div>
                          <button 
                            type="button" 
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