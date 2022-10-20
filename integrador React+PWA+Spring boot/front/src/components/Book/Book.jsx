import React, { useEffect, useState } from 'react'
import '../../assets/styles/StyleGeneral.css';
import { Link } from "react-router-dom";
import BookService from '../../service/BookService';
import setTime from '../util/reloadPage';

async function deleteBook(id) {
  const response = window.confirm('¿Seguro de que quiere eliminar el libro?');
  if (response) {
      const res = await  BookService.deleteBook(id)
      if(res.response.status === 204) {
        window.alert('Usuario eliminado correctamente')
      } else {
        window.alert('No se pudo eliminar el usuario')
      }
      setTime(5000);
  }
}

async function searchBook(word) {
  const res = await BookService.searchBook(word)
  console.log(res)
  if(res.response.status === 200) {
    window.alert('Se ha encontrado')
  } else {
    window.alert('No  se ha encontrado')
  }
  setTime(5000);
}

function Book() {
  const [listBook, setListBook] = useState([]);
  const [word, setWord] = useState('');

  useEffect(() => {
    BookService.getAllBooks()
    .then((response) => {
      setListBook(response.data);
    })
    .catch((error) => {
      console.log(error);
    });
  }, [setListBook])

  const handleChange = (e) => {
    setWord(e.target.value)
  }
  
  return (
    <div class="container">
    <h2 class="title">Libros</h2>

    <div class="input-group mb-3 texto-search">
      <input
        type="text"
        class="form-control"
        placeholder="Ingrese el título del libro a buscar"
        formControlName="nombreUsuario"
        name="word"
        onChange={handleChange}
      />
      <div class="input-group-append">
        <button class="btn btn-primary action search" type="button" onClick={() => searchBook(word)}>
          Buscar
        </button>
      </div>
    </div>

    <table class="table table-bordered">
      <thead class="thead-dark">
        <tr>
        <th scope="col">Cod libro</th>
            <th scope="col">Título</th>
            <th scope="col">Autor</th>
            <th scope="col">Categoria</th>
            <th scope="col">Edición</th>
            <th scope="col">Idioma</th>
            <th scope="col">Stock</th>
            <th scope="col">Operaciones</th>
        </tr>
      </thead>
      <tbody>
      {listBook.map((item) => (
        <tr>
          <td>{item.id}</td>
          <td>{item.title}</td>
          <td>{item.author}</td>
          <td>{item.category}</td>
          <td>{item.edition}</td>
          <td>{item.idiom}</td>
          <td>{item.stock}</td>
          <td>
            <button type="button" class="btn btn-primary action">
              <Link to="/update-book" class="colorBtnText">Editar</Link> 
             </button>
             <button type="button" class="btn btn-primary action">
              <Link to="/books" class="colorBtnText" key={item.id} onClick={() => deleteBook(item.id)}>Borrar</Link>
             </button>
           </td>
        </tr>
        ))}
      </tbody>
    </table>

    <button
      type="button"
      class="btn btn-primary action"
    >
      <Link to="/create-book" class="colorBtnText">Nuevo</Link> 
    </button>
</div>
  )
}

export default Book