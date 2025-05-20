import React, { useState, useEffect } from "react";
import {cambiarEstadoAlumno, 
        consultarAlumnos,
        consultarCarreras

} from "../../../../services/Administrador/Usuarios/Alumno/AlumnoService";
import toastr from 'toastr';


function AlumnoTable({alumnos, setAlumnos, personaSeleccionada, setPersonaSeleccionada, seleccionarPersona}){

// Define la interfaz para las carreras
interface Carrera {
    idCarrera: number;
    carrera: string;
}
// Define la interfaz para los datos del alumno
interface Alumno {
    nid_persona: number;
    nid_academico_alumno: number;
    cnombre: string;
    capellidos: string;
    cnumero_cuenta: string;
    bhabilitado: boolean;
}

interface Persona {
    nid_persona: number;
    cnombre: string;
    capellidos: string;
    bsexo: boolean;
    nedad: number;
    dfecha_nacimiento: string;
    getcCURP: string;
    getcRFC: string;
    cnumero_celular: string;
}
    const [filtroEstado, setFiltroEstado] = useState("");
    /* const [alumnos, setAlumnos] = useState<Alumno[]>([]); */
    const [mostrarFormularioRegistro, setMostrarFormularioRegistro] = useState(false);
    /* const [personaSeleccionada, setPersonaSeleccionada] = useState<Persona | null>(null); */ // Persona seleccionada para editar

        // Filtra los alumnos según el filtro de estado
    const alumnosFiltrados = alumnos.filter((alumno) => {
        if (filtroEstado === "habilitado") {
            return alumno.bhabilitado === true;
        } else if (filtroEstado === "inhabilitado") {
            return alumno.bhabilitado === false;
        }
        return true; // Si no hay filtro, muestra todos los alumnos
    });

/*     // Maneja la selección de una persona para editar
    const seleccionarPersona = (persona: Persona) => {
        setPersonaSeleccionada(persona);
        setMostrarFormulario(true); // Muestra el formulario de edición
    }; */

        // Maneja el cambio de habilitación/inhabilitación de un alumno
        const toggleHabilitado = async (idAlumno: number, index: number, habilitado: boolean) => {
            try {
                // Llama al servicio para cambiar el estado en el backend
                await cambiarEstadoAlumno(idAlumno, habilitado);
    
                // Actualiza el estado local de los alumnos
                setAlumnos((prevAlumnos) =>
                    prevAlumnos.map((alumno, i) =>
                        i === index ? { ...alumno, bhabilitado: habilitado } : alumno
                    )
                );
    
    /*             alert(`Estado del alumno actualizado a ${habilitado ? "Habilitado" : "Inhabilitado"}`); */
                toastr.success(`Estado del alumno actualizado a ${habilitado ? "Habilitado" : "Inhabilitado"}`);
            } catch (error) {
                console.error("Error al cambiar el estado del alumno:", error);
                toastr.error("Error al cambiar el estado del alumno. Intenta nuevamente.");
            }
        };

        
            // Carga inicial de carreras y alumnos
            useEffect(() => {
        
                const cargarAlumnos = async () => {
                    try {
                        const alumnosObtenidos = await consultarAlumnos();
                        setAlumnos(alumnosObtenidos);
                    } catch (error) {
                        alert("Error al cargar los alumnos. Intenta nuevamente.");
                    }
                };
                cargarAlumnos();
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

            
    return(
        <table className="tabla">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Número de Cuenta</th>
                        <th>Estado</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    {alumnosFiltrados.map((alumno, index) => (
                        <tr key={index}>
                            <td>{alumno.nid_academico_alumno}</td>
                            <td>{alumno.cnombre}</td>
                            <td>{alumno.capellidos}</td>
                            <td>{alumno.cnumero_cuenta}</td>
                            <td>{alumno.bhabilitado ? "Activo" : "Inactivo"}</td>
                            <td>
                                <button className="btn-actualizar" onClick={() =>
                                    seleccionarPersona({
                                        nid_persona: alumno.nid_persona,
                                        cnombre: alumno.cnombre,
                                        capellidos: alumno.capellidos,
                                        bsexo: true, // Puedes ajustar esto según los datos reales
                                        nedad: 25, // Ajusta según los datos reales
                                        dfecha_nacimiento: "1999-05-03", // Ajusta según los datos reales
                                        getcCURP: "CURP", // Ajusta según los datos reales
                                        getcRFC: "RFC", // Ajusta según los datos reales
                                        cnumero_celular: "5555555555", // Ajusta según los datos reales
                                    })
                                }>Actualizar</button>
                                <button
                                    className={alumno.bhabilitado ? "btn-inhabilitar" : "btn-habilitar"}
                                    onClick={() =>
                                        toggleHabilitado(
                                            alumno.nid_academico_alumno,
                                            index,
                                            !alumno.bhabilitado
                                        )
                                    }
                                >
                                    {alumno.bhabilitado ? "Inhabilitar" : "Habilitar"}
                                </button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
    )
}
export default AlumnoTable;