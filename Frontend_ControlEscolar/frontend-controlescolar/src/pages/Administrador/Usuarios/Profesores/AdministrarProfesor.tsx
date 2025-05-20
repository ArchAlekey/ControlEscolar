import React, { useState } from "react";
import ProfesorTable from "../../../../components/Administrador/Usuarios/Profesores/ProfesorTable.tsx";
import "../Alumnos/AdministraAlumno.css"
import BotonRegresar from "../../../../components/Administrador/BotonRegresar.js"
import ProfesorFiltro from "../../../../components/Administrador/Usuarios/Profesores/ProfesorFiltro.js";
import ProfesorRegistro from "../../../../components/Administrador/Usuarios/Profesores/ProfesorRegistro.js";
import ProfesorActualiza from "../../../../components/Administrador/Usuarios/Profesores/ProfesorActualiza.js";
import {registrarProfesor, enviarCorreo, actualizarPersona} from "../../../../services/Administrador/Usuarios/Profesor/ProfesorService.js";
import toastr from "toastr";

function AdministrarProfesor(){

    // Define la interfaz para los datos del profesor
    interface Profesor {
        nid_persona: number;
        nid_academico_profesor: number;
        cnombre: string;
        capellidos: string;
        cnumero_cuenta: string;
        bhabilitado: boolean;
    }

    // Define la interfaz para los datos de una persona
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

    const [profesores, setProfesores] = useState<Profesor[]>([]);
    const [mostrarFormularioRegistro, setMostrarFormularioRegistro] = useState(false);
    const [mostrarFormularioActualiza, setMostrarFormularioActualiza] = useState(false); // Estado para mostrar el formulario de actualización
    const [personaSeleccionada, setPersonaSeleccionada] = useState<Persona | null>(null); // Persona seleccionada para editar
    const [filtroEstado, setFiltroEstado] = useState(""); // Estado para el filtro de habilitado/inhabilitado
    const [datos, setDatos] = useState({
        cnombre: "",
        capellidos: "",
        bsexo: 1,
        nedad: 0,
        dfecha_nacimiento: "",
        cCURP: "",
        cRFC: "",
        cnumero_celular: "",
        nid_carrera: 0,
        ccorreo_personal: "",
        });

    // Función para generar el número de cuenta basado en el CURP
    const generarNumeroCuenta = (curp: string): string => {
        if (!curp || curp.length < 10) {
            throw new Error("El CURP debe tener al menos 10 caracteres.");
        }
        return `10${curp.substring(0, 10)}`; // Concatenar '10' con los primeros 10 caracteres del CURP
    };

    // Maneja el envío del formulario para registrar un alumno
    const handleRegistrar = async (e: React.FormEvent) => {
        e.preventDefault();
        try {
            // Genera el número de cuenta basado en el CURP
            const numeroCuenta = generarNumeroCuenta(datos.cCURP);
    
            // Asigna el número de cuenta al objeto `datos`
            const datosAlumno = { ...datos, cnumero_cuenta: numeroCuenta };
    
            // Realiza la petición para registrar al alumno
            const respuesta = await registrarProfesor(datosAlumno);
            toastr.success('Alumno registrado correctamente', 'Éxito');
            // Si el registro es exitoso, envía el correo electrónico
            const asunto = "Registro exitoso";
            const contenido = `Hola ${datos.cnombre} ${datos.capellidos}, tu número de cuenta es ${numeroCuenta} y tu contraseña es ${numeroCuenta}. Al iniciar sesión se te pedirá que la cambies.`;
            await enviarCorreo(datos.ccorreo_personal, asunto, contenido);
    
            toastr.success(`Correo enviado a ${datos.ccorreo_personal}`, 'Éxito');
    
            // Limpia el formulario
            setDatos({
                cnombre: "",
                capellidos: "",
                bsexo: 1,
                nedad: 0,
                dfecha_nacimiento: "",
                cCURP: "",
                cRFC: "",
                cnumero_celular: "",
                nid_carrera: 0,
                ccorreo_personal: "",
            });
            setMostrarFormularioRegistro(false); // Oculta el formulario
        } catch (error) {
            alert("Error al registrar alumno o enviar correo. Revisa los datos e intenta nuevamente.");
        }
    };

    // Manejador para el filtro de habilitado/inhabilitado
    const handleFiltroEstado = (e: React.ChangeEvent<HTMLSelectElement>) => {
        setFiltroEstado(e.target.value); // Actualiza el estado del filtro
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

    // Maneja la selección de una persona para editar
    const seleccionarPersona = (persona: Persona) => {
        setPersonaSeleccionada(persona);
        setMostrarFormularioActualiza(true); // Muestra el formulario de edición
    };

    // Maneja el envío del formulario para actualizar la persona
    const handleSubmitPersona = async (e: React.FormEvent) => {
        e.preventDefault();
        if (personaSeleccionada) {
            try {
                const respuesta = await actualizarPersona(personaSeleccionada);
                toastr.success('Persona actualizada correctamente');
                setMostrarFormularioActualiza(false); // Oculta el formulario
            } catch (error) {
                toastr.error('Error al actualizar la persona. Intenta nuevamente.');
            }
        }
    };

    // Maneja el cambio en los campos del formulario de edición
    const handleChangePersona = (e: React.ChangeEvent<HTMLInputElement | HTMLSelectElement>) => {
        if (personaSeleccionada) {
            setPersonaSeleccionada({
                ...personaSeleccionada,
                [e.target.name]: e.target.value,
            });
        }
    };
    
    return(
        <div className="container">
            <h1>Administrar Profesor</h1>
            <BotonRegresar />
            <button className="btn-agregar" onClick={() => setMostrarFormularioRegistro(true)}>
                Agregar Profesor
            </button>

            <ProfesorFiltro
                profesores={profesores}
                setProfesores={setProfesores}
                filtroEstado={filtroEstado}
                setFiltroEstado={setFiltroEstado}
            />

            <ProfesorTable 
                profesores={profesoresFiltrados}
                setProfesores={setProfesores}
                personaSeleccionada={personaSeleccionada}
                setPersonaSeleccionada={setPersonaSeleccionada}
                seleccionarPersona={seleccionarPersona}
            />

            <ProfesorRegistro
                mostrarFormulario={mostrarFormularioRegistro}
                setMostrarFormulario={setMostrarFormularioRegistro}
                datos={datos}
                setDatos={setDatos}
            />
            <ProfesorActualiza
                personaSeleccionada={personaSeleccionada}
                setPersonaSeleccionada={setPersonaSeleccionada}
                mostrarFormularioActualiza={mostrarFormularioActualiza}
                setMostrarFormularioActualiza={setMostrarFormularioActualiza}
                handleSubmitPersona={handleSubmitPersona}
                handleChangePersona={handleChangePersona}
            />

        </div>

    )
}
export default AdministrarProfesor;