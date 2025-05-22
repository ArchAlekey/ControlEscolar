import React, { useEffect, useState } from "react";
// Importa todos los servicios
import { consultarCarreras } from "../../../services/Administrador/HorarioMaterias/HorarioMaterias";
import { consultarSemestres } from "../../../services/Administrador/HorarioMaterias/HorarioMaterias";
import { consultarGrupos } from "../../../services/Administrador/HorarioMaterias/HorarioMaterias";
import { consultarHorarios } from "../../../services/Administrador/HorarioMaterias/HorarioMaterias";
import { consultarPeriodos } from "../../../services/Administrador/HorarioMaterias/HorarioMaterias";
import { consultarMateriasPorCarreraYSemestre } from "../../../services/Administrador/HorarioMaterias/HorarioMaterias";
import { consultarProfesores } from "../../../services/Administrador/HorarioMaterias/HorarioMaterias";
import Boton from "../../../components/boton/boton";
import toastr from 'toastr';
import 'toastr/build/toastr.min.css';

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
interface Grupo {
  idGrupo: number;
  grupo: string;
  habilitado?: boolean;
  fechaAlta?: string;
  fechaBaja?: string | null;
}
interface Horario {
  idHorario: number;
  horario: string;
  habilitado?: boolean;
  fechaAlta?: string;
  fechaBaja?: string | null;
}
interface Periodo {
  idPeriodo: number;
  periodo: string;
  anio: string;
  habilitado?: boolean;
  fechaBaja?: string;
  fechaAlta?: string | null;
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
interface Profesor {
  nid_academico_profesor: number;
  nid_persona: number;
  cnombre: string;
  capellidos: string;
  cnumero_cuenta: string;
  bhabilitado?: boolean;
}
function Horarios() {
  // Estados para cada select
  const [carreras, setCarreras] = useState<Carrera[]>([]);
  const [semestres, setSemestres] = useState<Semestre[]>([]);
  const [grupos, setGrupos] = useState<Grupo[]>([]);
  const [horarios, setHorarios] = useState<Horario[]>([]);
  const [periodos, setPeriodos] = useState<Periodo[]>([]);
  const [materias, setMaterias] = useState<Materia[]>([]);
  const [profesores, setProfesores] = useState<Profesor[]>([]);

  // Estados para selección
  const [selectedCarrera, setSelectedCarrera] = useState("");
  const [selectedSemestre, setSelectedSemestre] = useState("");
  const [selectedGrupo, setSelectedGrupo] = useState("");
  const [selectedHorario, setSelectedHorario] = useState("");
  const [selectedPeriodo, setSelectedPeriodo] = useState("");
  const [selectedMateria, setSelectedMateria] = useState("");
  const [selectedProfesor, setSelectedProfesor] = useState("");

  // Carga inicial de catálogos
  useEffect(() => {
    consultarCarreras().then(setCarreras);
    consultarSemestres().then(setSemestres);
    consultarGrupos().then(setGrupos);
    consultarHorarios().then(setHorarios);
    consultarPeriodos().then(setPeriodos);
    consultarProfesores().then(setProfesores);
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

/*   // Carga de materias cuando seleccionas carrera y semestre
  useEffect(() => {
    if (selectedCarrera && selectedSemestre) {
      consultarMateriasPorCarreraYSemestre(selectedCarrera, selectedSemestre).then(setMaterias);
    } else {
      setMaterias([]);
    }
  }, [selectedCarrera, selectedSemestre]); */

    // Enviar formulario
    async function handleSubmit(e) {
      e.preventDefault();
      const body = {
        nid_carrera: Number(selectedCarrera),
        nid_periodo: Number(selectedPeriodo),
        nid_semestre: Number(selectedSemestre),
        nid_grupo: Number(selectedGrupo),
        nid_academico_profesor: Number(selectedProfesor),
        nid_materia: Number(selectedMateria),
        nid_horario: Number(selectedHorario),
      };
      const response = await fetch("http://localhost:8082/horarios/asignar", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(body)
      });
      if (response.ok) {
        toastr.success("Horario Materia asignado correctamente");
        // Limpia el formulario si quieres
      } else {
        alert("Error al insertar horario-materia");
      }
    }

  return (
    <div className="container-main">
      <h1 className="h1-DP">Asigna un nuevo grupo</h1>
      <form onSubmit={handleSubmit} className="container-form">
        <label className="label">
          Carrera:
          <select value={selectedCarrera} onChange={e => setSelectedCarrera(e.target.value)} required className="select-grupos">
            <option value="">Selecciona una carrera</option>
            {carreras.map(c => <option key={c.idCarrera} value={c.idCarrera}>{c.carrera}</option>)}
          </select>
        </label>
        <label className="label">
          Semestre:
          <select value={selectedSemestre} onChange={e => setSelectedSemestre(e.target.value)} required className="select-grupos">
            <option value="">Selecciona un semestre</option>
            {semestres.map(s => <option key={s.idSemestre} value={s.idSemestre}>{s.semestre}</option>)}
          </select>
        </label>
        <label className="label">
          Materia:
          <select
            value={selectedMateria}
            onChange={e => setSelectedMateria(e.target.value)}
            required
            disabled={!selectedCarrera || !selectedSemestre} // <-- aquí el cambio
            className="select-grupos"
          >
            <option value="">Selecciona una materia</option>
            {materias.map(m => <option key={m.idMateria} value={m.idMateria}>{m.nombreMateria}</option>)}
          </select>
        </label>
        <label className="label">
          Grupo:
          <select value={selectedGrupo} onChange={e => setSelectedGrupo(e.target.value)} required className="select-grupos">
            <option value="">Selecciona un grupo</option>
            {grupos.map(g => <option key={g.idGrupo} value={g.idGrupo}>{g.grupo}</option>)}
          </select>
        </label>
        <label className="label">
          Horario:
          <select value={selectedHorario} onChange={e => setSelectedHorario(e.target.value)} required className="select-grupos">
            <option value="">Selecciona un horario</option>
            {horarios.map(h => <option key={h.idHorario} value={h.idHorario}>{h.horario}</option>)}
          </select>
        </label>
        <label className="label">
          Periodo:
          <select value={selectedPeriodo} onChange={e => setSelectedPeriodo(e.target.value)} required className="select-grupos">
            <option value="">Selecciona un periodo</option>
            {periodos.map(p => <option key={p.idPeriodo} value={p.idPeriodo}>{p.periodo}</option>)}
          </select>
        </label>
        <label className="label">
          Profesor:
          <select value={selectedProfesor} onChange={e => setSelectedProfesor(e.target.value)} required className="select-grupos">
            <option value="">Selecciona un profesor</option>
            {profesores.map(prof => (
              <option key={prof.nid_academico_profesor} value={prof.nid_academico_profesor}>
                {prof.cnombre + " " + prof.capellidos}
              </option>
            ))}
          </select>
        </label>
        <div className="container-btn">
          {/* <button type="submit">Guardar horario-materia</button> */}
          <Boton titulo="Guardar Grupo" />
        </div>
      </form>
    </div>
  );
}

export default Horarios;
