import React, { useEffect, useState } from "react";
import { consultarPeriodos } from "../../../services/Administrador/HorarioMaterias/HorarioMaterias";

interface Periodo {
  idPeriodo: number;
  periodo: string;
  anio: string;
  habilitado: boolean;
  fechaAlta?: string;   // si viene del backend, puedes ponerlas opcionales
  fechaBaja?: string | null;
}

function Periodos (){
const [periodos, setPeriodos] = useState<Periodo[]>([]);
const [loading, setLoading] = useState(true);

useEffect(() => {
    consultarPeriodos()
      .then(data => {
        setPeriodos(data);
        setLoading(false);
      })
      .catch(error => {
        console.error(error);
        setLoading(false);
      });
    }, []);

  if (loading) return <p>Cargando periodos...</p>;
    return (
    <div>
      <h2>Periodos</h2>
      <ul>
        {periodos.map((periodo) => (
          <li key={periodo.idPeriodo}>
            <b>{periodo.periodo}</b> ({periodo.anio}) - {periodo.habilitado ? "Habilitado" : "Inhabilitado"}
          </li>
        ))}
      </ul>
    </div>
        

    )
}
export default Periodos;