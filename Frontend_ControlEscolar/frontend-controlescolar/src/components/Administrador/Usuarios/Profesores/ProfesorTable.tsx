import React, { useState, useEffect, FormEvent } from 'react';
import {consultarProfesores, cambiarEstadoProfesor} from '../../../../services/Administrador/Usuarios/Profesor/ProfesorService';


function ProfesorTable({profesores, setProfesores, personaSeleccionada, setPersonaSeleccionada, seleccionarPersona}) {

    interface Profesor {
    nid_persona: number;
    nid_academico_profesor: number;
    cnombre: string;
    capellidos: string;
    cnumero_cuenta: string;
    bhabilitado: boolean;
   }

    /* const [profesores, setProfesores] = useState<Profesor[]>([]); */
    const [mostrarFormularioRegistro, setMostrarFormularioRegistro] = useState(false);
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
        if (mostrarFormularioRegistro) {
            document.body.classList.add("modal-open");
        } else {
            document.body.classList.remove("modal-open");
        }
    }, [mostrarFormularioRegistro]);
    // Manejador para el filtro de habilitado/inhabilitado
    const handleFiltroEstado = (e: React.ChangeEvent<HTMLSelectElement>) => {
    setFiltroEstado(e.target.value); // Actualiza el estado del filtro
    };

    // Maneja el cambio de habilitación/inhabilitación de un profesor
    const toggleHabilitado = async (idProfesor: number, index: number, habilitado: boolean) => {
        try {
            // Llama al servicio para cambiar el estado en el backend
            await cambiarEstadoProfesor(idProfesor, habilitado);

            // Actualiza el estado local de los profesores
            setProfesores((prevProfesores) =>
                prevProfesores.map((profesor, i) =>
                    i === index ? { ...profesor, bhabilitado: habilitado } : profesor
                )
            );

    /*   alert(`Estado del profesor actualizado a ${habilitado ? "Habilitado" : "Inhabilitado"}`); */
            toastr.success(`Estado del profesor actualizado a ${habilitado ? "Habilitado" : "Inhabilitado"}`);
        } catch (error) {
            console.error("Error al cambiar el estado del profesor:", error);
            toastr.error("Error al cambiar el estado del profesor. Intenta nuevamente.");
        }
     };

    return (
        <>
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
                        <button className="btn-actualizar" onClick={() =>
                            seleccionarPersona({
                                nid_persona: profesor.nid_persona,
                                cnombre: profesor.cnombre,
                                capellidos: profesor.capellidos,
                                bsexo: true, // Puedes ajustar esto según los datos reales
                                nedad: 25, // Ajusta según los datos reales
                                dfecha_nacimiento: "1999-05-03", // Ajusta según los datos reales
                                getcCURP: "CURP", // Ajusta según los datos reales
                                getcRFC: "RFC", // Ajusta según los datos reales
                                cnumero_celular: "5555555555", // Ajusta según los datos reales
                            })
                        }>Actualizar</button>
                        <button
                            className={profesor.bhabilitado ? "btn-inhabilitar" : "btn-habilitar"}
                            onClick={() =>
                                toggleHabilitado(
                                    profesor.nid_academico_profesor,
                                    index,
                                    !profesor.bhabilitado
                                )
                            }
                        >
                            {profesor.bhabilitado ? "Inhabilitar" : "Habilitar"}
                        </button>
                    </td>
                    </tr>
                )
            )}
            </tbody>
        </table>
        </>
    )
}
export default ProfesorTable;
