import React, { useEffect, useState } from "react";
import { Endpoints } from "../../api/ApiEndpoints";


function DatosPersonales(){

    const [persona, setPersona] = useState(null);
    const nid_persona = localStorage.getItem('idPersona')

    useEffect(() => {
        
        fetch(Endpoints.datosPersonales(nid_persona))
            .then((res) => res.json())
            .then((data) => {
                setPersona(data.data);
                /* console.log(data) */
            })
            .catch(err => console.log('Error al recuperar datos', err));
    }, [nid_persona]);
    
    return (
        
        <div className="contenedor-datos-personales">
            <form action="" method="POST">
                <h1 className="h1-DP">Datos Personales</h1>
                    <div className="contenedor-1">
                        <div className="contenedor-campo">
                            <label className="label-datos-personales">Nombre</label>
                            <input className="input-datos-personales" disabled type="text" value={persona?.cnombre || ''}></input>
                        </div>
                        <div className="contenedor-campo">
                            <label className="label-datos-personales">Apellidos</label>
                            <input className="input-datos-personales" disabled type="text" value={persona?.capellidos || ''}></input>
                        </div>
                        <div className="contenedor-campo">
                            <label className="label-datos-personales">Genero</label>
                            <input className="input-datos-personales" disabled type="text" value={persona?.bsexo ? "Masculino" : "Femenino" || ''}></input>
                        </div>
                        <div className="contenedor-campo">
                            <label className="label-datos-personales">Edad</label>
                            <input className="input-datos-personales" disabled type="number" value={persona?.nedad  || ''}></input>
                        </div>
                        <div className="contenedor-campo">
                            <label className="label-datos-personales">Fecha de nacimiento</label>
                            <input className="input-datos-personales" disabled type="date" value={persona?.dfecha_nacimiento || ''}></input>
                        </div>
                        <div className="contenedor-campo">
                            <label className="label-datos-personales">CURP</label>
                            <input className="input-datos-personales" disabled type="text" value={persona?.cCURP || ''}></input>
                        </div>
                        <div className="contenedor-campo">
                            <label className="label-datos-personales">RFC</label>
                            <input className="input-datos-personales" disabled type="text" value={persona?.cRFC || 'No cuenta con RFC'}></input>
                        </div>
                    </div>

                <h1 className="h1-DP">Contacto</h1>

                    <div className="contenedor-1">
                        <div className="contenedor-campo">
                            <label className="label-datos-personales">Celular</label>
                            <input className="input-datos-personales" disabled type="text" value={persona?.cnumero_celular || ''}></input>
                        </div>
                        <div className="contenedor-campo">
                            <label className="label-datos-personales">Correo Institucional</label>
                            <input className="input-datos-personales" disabled type="text" value={persona?.ccorreo_institucional || ''}></input>
                        </div>
                        <div className="contenedor-campo">
                            <label className="label-datos-personales">Correo Personal</label>
                            <input className="input-datos-personales" disabled type="text" value={persona?.ccorreo_personal || 'Sin datos registrados'}></input>
                        </div>
                    </div>
            </form>              
        </div>
    );
}

export default DatosPersonales;