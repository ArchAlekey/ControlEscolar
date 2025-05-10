import React, { useEffect, useState } from "react";
import { Endpoints } from "../../api/ApiEndpoints";

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
        </div>
    );
};

export default GruposAsignados;