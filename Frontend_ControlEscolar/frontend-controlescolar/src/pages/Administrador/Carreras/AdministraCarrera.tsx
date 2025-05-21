import React, { useEffect, useState } from "react";
import { consultarCarreras } from "../../../services/Administrador/Carreras/Carreras";
interface Carrera {
  idCarrera: number;
  carrera: string;
  habilitado: boolean;
  fechaAlta?: string;   // si viene del backend, puedes ponerlas opcionales
  fechaBaja?: string | null;
}
function AdministraCarrera ()
{
    const [carreras, setCarreras] = useState<Carrera[]>([]);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        consultarCarreras()
          .then(data => {
            setCarreras(data);
            setLoading(false);
          })
          .catch(error => {
            console.error(error);
            setLoading(false);
          });
        }, []);

    return(
    <div>
        <h1>Administra Carrera</h1>
    <div>
      <h2>Carreras</h2>
      <ul>
        {carreras.map((carrera) => (
          <li key={carrera.idCarrera}>
            <b>{carrera.carrera}</b>  - {carrera.habilitado ? "Habilitado" : "Inhabilitado"}
          </li>
        ))}
      </ul>
    </div>
            
        </div>
    )
}
export default AdministraCarrera;