import React from 'react'
import '../../assets/styles/StyleGeneral.css';

function Reports() {
  return (
    <div class="container">
        <h2 class="title">Reportes</h2>

        <table class="table table-bordered">
            <thead class="thead-dark">
            <tr>
                <th scope="col">User Id</th>
                <th scope="col">Book Id</th>
                <th scope="col">Fecha de salida</th>
                <th scope="col">Fecha de entrega</th>
            </tr>
            </thead>
            <tbody >
            <tr>
                <th scope="row">aca datos1</th>
                <td>aca datos2</td>
                <td>aca datos3</td>
                <td>aca datos4</td>
            </tr>
            </tbody>
        </table>

        <button type="button" class="btn btn-primary action">Actualizar</button>
    </div> 
  )
}

export default Reports