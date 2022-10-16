import React, { useEffect, useState }  from 'react'
import '../../assets/styles/StyleGeneral.css';
import LendingService from '../../service/LendingService';

function showReports() {
      LendingService.getAllLendings();
      window.location.replace('');
}

function deleteLending(id) {
  const response = window.confirm('¿Seguro de que quiere eliminar el préstamo?');
  if (response) {
      const res = LendingService.returnLending(id) 
      if(res.response.status === 200) {
        window.location.reload();
      }
  }
}

function downloadReport() {
  LendingService.downloadReport()
  .then((response) => {
    const url = window.URL.createObjectURL(new Blob([response.data]));
    const link = document.createElement('a');
    link.href = url;
    link.setAttribute('download', 'reporte.xlsx');
    document.body.appendChild(link);
    link.click();
  });
}


function Reports() {

  const [listLend, setListLend] = useState([]);

  useEffect(() => {
    LendingService.getAllLendings()
    .then((response) => {
      setListLend(response.data);
    })
    .catch((error) => {
      console.log(error);
    });
  }, [setListLend])

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
            {listLend.map((item) => (
            <tr>
                <th scope="row">{item.users.id}</th>
                <td>{item.books.id}</td>
                <td>{item.date_out}</td>
                <td>{item.date_return}</td>
                <td>
                  <button 
                    type="button" 
                    class="btn btn-primary action" 
                    key={item.id} 
                    onClick={() => deleteLending(item.id)}
                    >Devolver
                  </button>
                </td>
            </tr>
            ))}
            </tbody>
        </table>

        <button type="button" class="btn btn-primary action" onClick={() => showReports()}>Actualizar</button>
        <button type="button" class="btn btn-primary action" onClick={() => downloadReport()}>Descargar en excel</button>
    </div> 
  )
}

export default Reports