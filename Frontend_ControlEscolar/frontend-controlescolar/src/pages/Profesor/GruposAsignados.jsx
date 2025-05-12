import React, { useEffect, useState } from "react";
import { Endpoints } from "../../api/ApiEndpoints";
import Boton from "../../components/boton/boton";

function GruposAsignados(){

    const [gruposAsignados, setGruposAsignados] = useState([]);
    const nid_persona = Number(localStorage.getItem("idPersona"));
    /* console.log(nid_persona); */

    useEffect(() => {
        const handleGruposAsig = async () =>{
            try{
                const respuesta = await fetch(Endpoints.consultaGruposAsig(nid_persona));
                const data = await respuesta.json();
                setGruposAsignados (data || []);
                console.log(data);
            } catch (e){
                console.error("Error al consultar los grupos: ", e);
            }
        }
        handleGruposAsig();
    }, []);
    
    return (
        <div className="container-main">
            <h1 className="h1-DP">Grupos</h1>
            { gruposAsignados.map((grupos, index) => (
                <details key={index} className="container-details">
                    <summary className="container-summary">
                        {grupos.cnombre_materia} || {grupos.cgrupo}
                    </summary>
                    <h2>{grupos.cnombre_materia}</h2>
                    <ul>
                        <li><strong>Clave: </strong>{grupos.cclave_materia}</li>
                        <li><strong>Periodo: </strong>{grupos.cperiodo}</li>
                        <li><strong>Grupo: </strong>{grupos.cgrupo}</li>
                        <li><strong>Horario: </strong>{grupos.chorario}</li>
                    </ul>
                    <Boton titulo="Alumnos Inscritos"/>
                </details>
            ))}
        </div>
    );
};

export default GruposAsignados;