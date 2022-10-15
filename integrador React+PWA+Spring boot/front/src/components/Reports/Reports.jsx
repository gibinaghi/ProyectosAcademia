import React from 'react'
import '../../assets/styles/StyleGeneral.css';
import { Link } from "react-router-dom";

function Reports() {
  return (
    <div class="container">
        <h2 class="title">Reportes</h2>

        <table class="table table-bordered">
            <thead class="thead-dark">
            <tr>
                <th scope="col">Cod usuario</th>
                <th scope="col">Cod libro</th>
                <th scope="col">Fecha de prestamo</th>
                <th scope="col">Fecha de devolución</th>
                <th scope="col">Operaciones</th>
            </tr>
            </thead>
            <tbody >
            <tr>
                <th scope="row">aca datos1</th>
                <td>aca datos2</td>
                <td>aca datos3</td>
                <td>aca datos4</td>
                <td>
                  <button type="button" class="btn btn-primary action">
                    <Link to="/delete-lending" class="colorBtnText">Devolver</Link> 
                  </button>
                </td>
            </tr>
            </tbody>
        </table>

        <button type="button" class="btn btn-primary action">Actualizar</button>
    </div> 
  )
}

export default Reports