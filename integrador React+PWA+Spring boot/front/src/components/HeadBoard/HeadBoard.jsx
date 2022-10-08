import React from 'react'
import '../../assets/styles/Headboard.css';
import moment from 'moment'

function HeadBoard() {
  return (
    <section class="titleHeadboard">
        <p class="pHeadboard">Administracion/Control/Biblioteca</p>
        <h3 class="h3Headboard"> Hoy es {moment().format('DD/MM/YYYY')}. Son las {moment().format('HH:mm')}hs</h3>
    </section>
  )
}

export default HeadBoard