import React, { useState } from "react";
import {consultarProfesores, buscarProfesores} from "../../../../services/Administrador/Usuarios/Profesor/ProfesorService"
function ProfesorFiltro ({profesores, setProfesores, filtroEstado, setFiltroEstado}){
    // Define la interfaz para los datos del profesor
    interface Profesor {
        nid_persona: number;
        nid_academico_profesor: number;
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
            // Si el campo está vacío, recarga todos los profesores
            const profesoresObtenidos = await consultarProfesores();
            setProfesores(profesoresObtenidos);
            return;
        }
    
        try {
            // Llama al servicio de búsqueda
            const profesoresFiltrados = await buscarProfesores(texto);
            setProfesores(profesoresFiltrados); // Actualiza la lista de profesores con los resultados de la búsqueda
        } catch (error) {
            console.error("Error al buscar profesores:", error);
        }
    };

    // Filtra los profesores según el filtro de estado
    const profesoresFiltrados = profesores.filter((profesor) => {
        if (filtroEstado === "habilitado") {
            return profesor.bhabilitado === true;
        } else if (filtroEstado === "inhabilitado") {
            return profesor.bhabilitado === false;
        }
        return true; // Si no hay filtro, muestra todos los profesores
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
export default ProfesorFiltro;