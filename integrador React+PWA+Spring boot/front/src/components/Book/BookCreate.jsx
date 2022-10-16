import React, { useState } from 'react'
import BookService from '../../service/BookService';

function createBook(bookCreate) {
  const res = BookService.createBook(bookCreate)
  if(res.response.status === 201) {
    window.location.reload();
  }
}

function BookCreate() {
  const [bookCreate, setBookCreate] = useState({
    title: '',
    author: '',
    category: '',
    edition: '',
    idiom: '',
    stock: 0,
  })

  const handleChange = (e) => {
    setBookCreate({
      ...bookCreate,
      [e.target.name]: e.target.value
    })
  }

  return (
    <div class="container">
      <h2 class="title">Crear libro</h2>
      <form>
      <div class="row">
          <div class="col-6">
                  <div class="form-group">
                    <label>Titulo</label>
                    <input 
                      type="text" 
                      class="form-control" 
                      placeholder="Ingrese el título del libro" 
                      formControlName="title"
                      name='title'
                      onChange={handleChange}
                    />
                  </div>
                  <div class="form-group">
                      <label>Autor</label>
                      <input 
                        type="text" 
                        class="form-control" 
                        placeholder="Ingrese el nombre del autor" 
                        formControlName="author"
                        name='author'
                        onChange={handleChange}
                      />
                  </div>
                  <div class="form-group">
                      <label>Categoría</label>
                      <input 
                        type="text" 
                        class="form-control" 
                        placeholder="Ingrese la categoría del libro" 
                        formControlName="category"
                        name='category'
                        onChange={handleChange}
                      />
                  </div>  
                  <div class="form-group">
                          <label>Edición</label>
                          <input 
                            type="text" 
                            class="form-control" 
                            placeholder="Ingrese la edición" 
                            formControlName="edition"
                            name='edition'
                            onChange={handleChange}
                          />
                      </div>
          </div>
          <div class="col-6">
                      <div class="form-group">
                        <label>Idioma</label>
                        <input 
                          type="text" 
                          class="form-control" 
                          placeholder="Ingrese el idioma del libro" 
                          formControlName="idiom"
                          name='idiom'
                          onChange={handleChange}
                        />
                      </div>
                      <div class="form-group">
                          <label>Stock</label>
                          <input 
                            type="text" 
                            class="form-control" 
                            placeholder="Cantidad total" 
                            formControlName="stock"
                            name='stock'
                            onChange={handleChange}
                          />
                      </div>
                      <button 
                        type="submit" 
                        class="btn btn-primary action" 
                        onClick={() => createBook(bookCreate)}
                        >Crear libro
                      </button>         
          </div> 
      </div> 
    </form> 
</div>
  )
}

export default BookCreate