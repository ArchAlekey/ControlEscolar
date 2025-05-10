import React, { useState, useEffect, FormEvent } from 'react';
import {consultarProfesores} from '../../../../services/Administrador/Usuarios/Profesor/ProfesorService';


function ProfesoresTable() {

    interface Profesor {
    nid_persona: number;
    nid_academico_profesor: number;
    cnombre: string;
    capellidos: string;
    cnumero_cuenta: string;
    bhabilitado: boolean;
   }

    const [profesores, setProfesores] = useState<Profesor[]>([]);
    const [mostrarFormulario, setMostrarFormulario] = useState(false);
    const [filtroEstado, setFiltroEstado] = useState("");

    // Filtra los profesores según el filtro de estado
    const profesoresFiltrados = profesores.filter((profesor) => {
        if (filtroEstado === "habilitado") {
            return profesor.bhabilitado === true;
        } else if (filtroEstado === "inhabilitado") {
            return profesor.bhabilitado === false;
        }
        return true; // Si no hay filtro, muestra todos los profesores
    });
    // Carga inicial de carreras y alumnos
    useEffect(() => {
            
    const cargarProfesores = async () => {
        try {
            const profesoresObtenidos = await consultarProfesores();
            setProfesores(profesoresObtenidos);
        } catch (error) {
            alert("Error al cargar los profesores. Intenta nuevamente.");
        }
    };
    cargarProfesores();
    }, []);

    useEffect(() => {
        if (mostrarFormulario) {
            document.body.classList.add("modal-open");
            } else {
                document.body.classList.remove("modal-open");
            }
                }, [mostrarFormulario]);
    // Manejador para el filtro de habilitado/inhabilitado
    const handleFiltroEstado = (e: React.ChangeEvent<HTMLSelectElement>) => {
    setFiltroEstado(e.target.value); // Actualiza el estado del filtro
    };

    return (
        <>
        <select onChange={handleFiltroEstado} value={filtroEstado}>
            <option value="">Todos</option>
            <option value="habilitado">Habilitado</option>
            <option value="inhabilitado">Inhabilitado</option>
        </select>
        <table className="tabla">
            <thead>
                <th>ID</th>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Número de Cuenta</th>
                <th>Estado</th>
                <th>Acciones</th>   
            </thead>
            <tbody>
                {profesoresFiltrados.map((profesor, index) => (
                    <tr key={index}>
                        <td>{profesor.nid_academico_profesor}</td>
                        <td>{profesor.cnombre}</td>
                        <td>{profesor.capellidos}</td>
                        <td>{profesor.cnumero_cuenta}</td>
                        <td>{profesor.bhabilitado ? "Habilitado" : "Inhabilitado"}</td>
                        <td>
                            <button>Editar</button>
                            <button>{profesor.bhabilitado ? "Deshabilitar" : "Habilitar"}</button>
                        </td>
                    </tr>
                )
            )}|
            </tbody>
        </table>
        </>
    )
}
export default ProfesoresTable;
