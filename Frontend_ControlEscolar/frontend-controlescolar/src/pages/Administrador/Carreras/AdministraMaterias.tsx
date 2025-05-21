import React, { useEffect, useState } from "react";
import { consultarCarreras } from "../../../services/Administrador/Carreras/Carreras";
import { consultarSemestres } from "../../../services/Administrador/HorarioMaterias/HorarioMaterias";
import { consultarMateriasPorCarreraYSemestre } from "../../../services/Administrador/HorarioMaterias/HorarioMaterias";

interface Carrera {
  idCarrera: number;
  carrera: string;
  habilitado?: boolean;    
  fechaBaja?: string;      
  fechaAlta?: string | null;
}

interface Semestre {
  idSemestre: number;
  semestre: number;
  bpar_impar: boolean;
  habilitado?: boolean;     
  fechaAlta?: string;       
  fechaBaja?: string | null;
}

interface Materia {
  idMateria: number;
  idCarrera: number;
  idSemestre: number;
  nombreMateria: string;
  claveMateria: string;
  habilitado?: boolean;
  fechaBaja?: string;
  fechaAlta?: string | null;
}

function AdministraMaterias(){

      const [carreras, setCarreras] = useState<Carrera[]>([]);
      const [semestres, setSemestres] = useState<Semestre[]>([]);
      const [materias, setMaterias] = useState<Materia[]>([]);

      // Estados para selección
      const [selectedCarrera, setSelectedCarrera] = useState("");
      const [selectedSemestre, setSelectedSemestre] = useState("");
      const [selectedMateria, setSelectedMateria] = useState("");

      // Carga inicial de catálogos
        useEffect(() => {
          consultarCarreras().then(setCarreras);
          consultarSemestres().then(setSemestres);
        }, []);
      
         // Cargar materias cuando seleccionas carrera Y semestre
        useEffect(() => {
          if (selectedCarrera && selectedSemestre) {
            consultarMateriasPorCarreraYSemestre(selectedCarrera, selectedSemestre)
              .then(setMaterias)
              .catch(() => setMaterias([])); // Si hay error, deja materias vacío
          } else {
            setMaterias([]); // Si no hay selección, deja materias vacío
          }
          // Limpia materia seleccionada si cambias carrera o semestre
          setSelectedMateria("");
        }, [selectedCarrera, selectedSemestre]);
    return (

        <div>
            <h1>Administra Materias</h1>
            <form>
      {/* Select de Carrera */}
      <div>
        <label htmlFor="carrera">Carrera:</label>
        <select
          id="carrera"
          value={selectedCarrera}
          onChange={(e) => setSelectedCarrera(e.target.value)}
        >
          <option value="">Seleccione una carrera</option>
          {carreras.map((carrera) => (
            <option key={carrera.idCarrera} value={carrera.idCarrera}>
              {carrera.carrera}
            </option>
          ))}
        </select>
      </div>

      {/* Select de Semestre */}
      <div>
        <label htmlFor="semestre">Semestre:</label>
        <select
          id="semestre"
          value={selectedSemestre}
          onChange={(e) => setSelectedSemestre(e.target.value)}
        >
          <option value="">Seleccione un semestre</option>
          {semestres.map((sem) => (
            <option key={sem.idSemestre} value={sem.idSemestre}>
              {sem.semestre}
            </option>
          ))}
        </select>
      </div>
    </form>

    {/* Lista de materias */}
    <div>
      <h2>Materias disponibles</h2>
      {materias.length === 0 ? (
        <p>No hay materias disponibles para esta combinación.</p>
      ) : (
        <ul>
          {materias.map((materia) => (
            <li key={materia.idMateria}>
              {materia.nombreMateria} ({materia.claveMateria})
            </li>
          ))}
        </ul>
      )}
    </div>
        </div>
    )
}
export default AdministraMaterias;