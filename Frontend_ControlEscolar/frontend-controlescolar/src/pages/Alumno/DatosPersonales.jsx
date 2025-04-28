import React from "react";

function DatosPersonales(){

    return (
        <div class="contenedor-datos-personales">
            <form action="">
                <h1>Datos Personales</h1>
                <label>Nombre</label>
                <input className="input-datos-personales" disabled></input>
                <label>Apellidos</label>
                <input className="input-datos-personales" disabled></input>
                <label>Nombre</label>
                <input className="input-datos-personales" disabled></input>
                <label>Genero</label>
                <input className="input-datos-personales" disabled></input>
                <label>Edad</label>
                <input className="input-datos-personales" disabled></input>
                <label>Fecha de nacimiento</label>
                <input className="input-datos-personales" disabled></input>
                <label>CURP</label>
                <input className="input-datos-personales" disabled></input>
                <label>RFC</label>
                <input className="input-datos-personales" disabled></input>
                <h1>Contacto</h1>
                <label>Celular</label>
                <input className="input-datos-personales" disabled></input>
                <label>Correo Personal</label>
                <input className="input-datos-personales" disabled></input>
                <label>Correo Institucional</label>
                <input className="input-datos-personales" disabled></input>
            </form>              
        </div>
    );
}

export default DatosPersonales;