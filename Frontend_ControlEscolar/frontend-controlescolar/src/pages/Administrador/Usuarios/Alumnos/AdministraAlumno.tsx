import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import {
    consultarAlumnos,
    consultarCarreras,
    registrarAlumno,
    cambiarEstadoAlumno,
    buscarAlumnos,
    actualizarPersona,
    enviarCorreo,
} from "../../../../services/Administrador/Usuarios/Alumno/AlumnoService";
import "./AdministraAlumno.css";
import toastr from 'toastr';
import 'toastr/build/toastr.min.css';
import BotonRegresar from "../../../../components/Administrador/BotonRegresar.tsx";
import AlumnoTable from "../../../../components/Administrador/Usuarios/Alumnos/AlumnoTable.tsx";
import AlumnoRegistro from "../../../../components/Administrador/Usuarios/Alumnos/AlumnoRegistro.tsx";
import AlumnoActualiza from "../../../../components/Administrador/Usuarios/Alumnos/AlumnoActualiza.tsx";
import AlumnoFiltro from "../../../../components/Administrador/Usuarios/Alumnos/AlumnoFiltro.tsx";

// Define la interfaz para los datos del alumno
interface Alumno {
    nid_persona: number;
    nid_academico_alumno: number;
    cnombre: string;
    capellidos: string;
    cnumero_cuenta: string;
    bhabilitado: boolean;
}
// Define la interfaz para las carreras
interface Carrera {
    idCarrera: number;
    carrera: string;
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

function AdministraAlumno() {
    const navigate = useNavigate();
    const [mostrarFormulario, setMostrarFormulario] = useState(false);
    const [carreras, setCarreras] = useState<Carrera[]>([]);
    const [alumnos, setAlumnos] = useState<Alumno[]>([]);
    const [textoBusqueda, setTextoBusqueda] = useState(""); // Estado para el texto de búsqueda
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
    const [personaSeleccionada, setPersonaSeleccionada] = useState<Persona | null>(null); // Persona seleccionada para editar

    // Carga inicial de carreras y alumnos
    useEffect(() => {
        const cargarCarreras = async () => {
            try {
                const carrerasObtenidas = await consultarCarreras();
                /* alert("Carreras obtenidas correctamente."); */
                setCarreras(carrerasObtenidas);
            } catch (error) {
                alert("Error al cargar las carreras. Intenta nuevamente.");
            }
        };

        const cargarAlumnos = async () => {
            try {
                const alumnosObtenidos = await consultarAlumnos();
                setAlumnos(alumnosObtenidos);
            } catch (error) {
                alert("Error al cargar los alumnos. Intenta nuevamente.");
            }
        };

        cargarCarreras();
        cargarAlumnos();
    }, []);

    useEffect(() => {
        if (mostrarFormulario) {
            // Agrega la clase "modal-open" al body cuando el formulario está visible
            document.body.classList.add("modal-open");
        } else {
            // Elimina la clase "modal-open" del body cuando el formulario está oculto
            document.body.classList.remove("modal-open");
        }
    }, [mostrarFormulario]);

    // Función para generar el número de cuenta basado en el CURP
    const generarNumeroCuenta = (curp: string): string => {
        if (!curp || curp.length < 10) {
            throw new Error("El CURP debe tener al menos 10 caracteres.");
        }
        return `10${curp.substring(0, 10)}`; // Concatenar '10' con los primeros 10 caracteres del CURP
    };

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

    // Manejador para el filtro de habilitado/inhabilitado
    const handleFiltroEstado = (e: React.ChangeEvent<HTMLSelectElement>) => {
        setFiltroEstado(e.target.value); // Actualiza el estado del filtro
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

    // Maneja el cambio en los campos del formulario
    const handleChange = (e: React.ChangeEvent<HTMLInputElement | HTMLSelectElement>) => {
        const { name, value } = e.target;
        setDatos({ ...datos, [name]: name === "bsexo" || name === "nedad" || name === "nid_carrera" ? parseInt(value) : value });
    };

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

    // Maneja el envío del formulario para registrar un alumno
    const handleRegistrar = async (e: React.FormEvent) => {
        e.preventDefault();
        try {
            // Genera el número de cuenta basado en el CURP
            const numeroCuenta = generarNumeroCuenta(datos.cCURP);

            // Asigna el número de cuenta al objeto `datos`
            const datosAlumno = { ...datos, cnumero_cuenta: numeroCuenta };

            // Realiza la petición para registrar al alumno
            const respuesta = await registrarAlumno(datosAlumno);
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
            setMostrarFormulario(false); // Oculta el formulario
        } catch (error) {
            alert("Error al registrar alumno o enviar correo. Revisa los datos e intenta nuevamente.");
        }
    };

    // Maneja la selección de una persona para editar
    const seleccionarPersona = (persona: Persona) => {
        setPersonaSeleccionada(persona);
        setMostrarFormulario(true); // Muestra el formulario de edición
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

    // Maneja el envío del formulario para actualizar la persona
    const handleSubmitPersona = async (e: React.FormEvent) => {
        e.preventDefault();
        if (personaSeleccionada) {
            try {
                const respuesta = await actualizarPersona(personaSeleccionada);
                toastr.success('Persona actualizada correctamente');
                setMostrarFormulario(false); // Oculta el formulario
            } catch (error) {
                toastr.error('Error al actualizar la persona. Intenta nuevamente.');
            }
        }
    };

    return (
        <div>
            <h1>Administrar Alumnos</h1>
            <BotonRegresar
                textoBoton="Agregar Alumno"
            />
            <button className="btn-agregar" onClick={() => setMostrarFormulario(true)}>
                Agregar Alumno
            </button>

            <AlumnoFiltro 
                alumnos={alumnos}
                setAlumnos={setAlumnos}
                filtroEstado={filtroEstado}
                setFiltroEstado={setFiltroEstado}
            />
            <AlumnoTable
                alumnos={alumnosFiltrados}
                setAlumnos={setAlumnos}
                personaSeleccionada={personaSeleccionada}
                setPersonaSeleccionada={setPersonaSeleccionada}
                seleccionarPersona={seleccionarPersona}

            />
            <AlumnoRegistro
                mostrarFormulario={mostrarFormulario}
                setMostrarFormulario={setMostrarFormulario}
            />
            <AlumnoActualiza
                personaSeleccionada={personaSeleccionada}
                setPersonaSeleccionada={setPersonaSeleccionada}
                mostrarFormulario={mostrarFormulario}
                setMostrarFormulario={setMostrarFormulario}
                handleSubmitPersona={handleSubmitPersona}
                handleChangePersona={handleChangePersona}
            />
        </div>
    );
}

export default AdministraAlumno;