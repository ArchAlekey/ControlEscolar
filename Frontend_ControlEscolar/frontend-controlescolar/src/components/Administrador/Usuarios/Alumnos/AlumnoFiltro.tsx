import React, { useState } from "react";
import {consultarAlumnos, buscarAlumnos} from "../../../../services/Administrador/Usuarios/Alumno/AlumnoService.js"
function AlumnoFiltro ({alumnos, setAlumnos, filtroEstado, setFiltroEstado}){
    // Define la interfaz para los datos del alumno
    interface Alumno {
        nid_persona: number;
        nid_academico_alumno: number;
        cnombre: string;
        capellidos: string;
        cnumero_cuenta: string;
        bhabilitado: boolean;
    }
    const [textoBusqueda, setTextoBusqueda] = useState(""); // Estado para el texto de búsqueda
    /* const [alumnos, setAlumnos] = useState<Alumno[]>([]); */
    /* const [filtroEstado, setFiltroEstado] = useState("");  */// Estado para el filtro de habilitado/inhabilitado

    // Manejador para el campo de búsqueda
    const handleBusqueda = async (e: React.ChangeEvent<HTMLInputElement>) => {
        const texto = e.target.value;
        setTextoBusqueda(texto);
    
        if (texto.trim() === "") {
            // Si el campo está vacío, recarga todos los alumnos
            const alumnosObtenidos = await consultarAlumnos();
            setAlumnos(alumnosObtenidos);
            return;
        }
    
        try {
            // Llama al servicio de búsqueda
            const alumnosFiltrados = await buscarAlumnos(texto);
            setAlumnos(alumnosFiltrados); // Actualiza la lista de alumnos con los resultados de la búsqueda
        } catch (error) {
            console.error("Error al buscar alumnos:", error);
        }
    };

    // Filtra los alumnos según el filtro de estado
    const alumnosFiltrados = alumnos.filter((alumno) => {
        if (filtroEstado === "habilitado") {
            return alumno.bhabilitado === true;
        } else if (filtroEstado === "inhabilitado") {
            return alumno.bhabilitado === false;
        }
        return true; // Si no hay filtro, muestra todos los alumnos
    });

    // Manejador para el filtro de habilitado/inhabilitado
    const handleFiltroEstado = (e: React.ChangeEvent<HTMLSelectElement>) => {
        setFiltroEstado(e.target.value); // Actualiza el estado del filtro
    };

    return (
    <>
        <div className="filtros-container">
            <input
                type="text"
                placeholder="Buscar por nombre o número de cuenta"
                className="input-busqueda"
                value={textoBusqueda}
                onChange={handleBusqueda} // Llama al manejador de búsqueda
            />
            <select className="select-filtro" value={filtroEstado} onChange={handleFiltroEstado}>
                <option value="">Todos</option>
                <option value="habilitado">Activo</option>
                <option value="inhabilitado">Inactivo</option>
            </select>
        </div>
    </>
    )
}
export default AlumnoFiltro;