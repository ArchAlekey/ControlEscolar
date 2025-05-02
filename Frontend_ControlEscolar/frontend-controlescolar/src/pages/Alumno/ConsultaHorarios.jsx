import React, { useEffect, useState } from "react";
import { Endpoints } from "../../api/ApiEndpoints";

function ConsultaHorario(){

    const [horarios, setHorarsio] = useState([]);
    const [loading, setLoading] = useState (false);

    useEffect(() => {
        fetch(Endpoints.horarios(1, 1))
            .then(response => response.json())
            .then(data => {
                setHorarsio(data.data);
                setLoading(false);
            })
            .catch(err => {
                console.log("Error al consultar los horarios", err);
                setLoading(false);
            });
    }, []);
    return (
        <div>
          <h1>Horarios</h1>
          {horarios.length > 0 ? (
            <ul>
              {horarios.map((horario, index) => (
                <li key={index}>{horario.cnombre_materia} - {horario.profesor}</li>
              ))}
            </ul>
          ) : (
            <p>No se encontraron horarios.</p>
          )}
        </div>
      );
    
};

export default ConsultaHorario;