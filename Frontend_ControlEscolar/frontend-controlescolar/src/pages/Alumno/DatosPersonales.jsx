import React from "react";

function DatosPersonales(){

    return (
        <div class="contenedor-datos-personales">
            <h1>Datos Personales</h1>
                <ul>
                    <label for="">Nombre</label>
                    <label for="">Apellidos</label>
                    <label for="">Genero</label>
                    <label for="">Edad</label>
                    <label for="">Fecha de nacimiento</label>
                    <label for="">CURP</label>
                    <label for="">RFC</label>
                    <label for="">Usuario</label>
                    <label for="">Número de cuenta</label>
                </ul>
            <h2>Contactos</h2>
                <ul>
                    <label for="">Telefono</label>
                    <label for="">Correo Personal</label>
                    <label for="">Correo Institucional</label>
                </ul>                  
        </div>
    );
}

export default DatosPersonales;