import axios from "axios";

// Base URL para las peticiones relacionadas con alumnos
const URL_REGISTRAR = "/api/registrar/alumno";
const URL_CARRERAS = "/api/carreras/mostrar"; // Usa el prefijo "/api" para que el proxy funcione
const URL_CONSULTAR = "/api/alumnos/academicosAlumnos";

// Servicio para registrar un alumno
export const registrarAlumno = async (datos) => {
    try {
        const response = await fetch(URL_REGISTRAR, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(datos),
        });
        if (!response.ok) { //cual deberia ser el mensaje?
            throw new Error(`Error al registrar alumno (servicio): ${response.json().message}`);
        }

        const data = await response.json();
        return data; // Devuelve la respuesta de la API
    } catch (error) {
        console.error("Error al registrar alumno:", error);
        throw error; // Lanza el error para manejarlo en el componente
    }
};

//Servicio para consultar los datos de un alumno
export const consultarAlumnos = async () => {
    try {
        const response = await fetch(URL_CONSULTAR, {
            method: "GET",
            headers: {
                "Context-Type": "application/json",
            },
        });
        if (!response.ok) {
            throw new Error(`Error al consultar alumnos: ${response.statusText}`);
        }
        const data = await response.json();
        console.log("Respuesta completa de consultarAlumnos:", data);
        return data; // Devuelve la lista de alumnos
    } catch (error) {
        console.error("Error al consultar alumnos:", error);
        throw error;
    }
    
};

// Servicio para consultar las carreras
export const consultarCarreras = async () => {
    try {
        const response = await fetch(URL_CARRERAS, {
            method: "GET",
            headers: {
                "Content-Type": "application/json",
            },
        });

        if (!response.ok) {
            throw new Error(`Error al consultar carreras (desde el servicio): ${response.statusText}`);
        }

        const data = await response.json();
        console.log("Respuesta completa de consultarCarreras:", data); // Muestra los datos
        return data; // Devuelve la lista de carreras
    } catch (error) {
        console.error("Error al consultar carreras:", error.message);
        throw error; // Lanza el error para manejarlo en el componente
    }
};

// Servicio para actualizar un alumno (puedes implementar más adelante)

const URL_ACTUALIZAR = " ";
export const actualizarAlumno = async (datos) => {
    try {
        const response = await axios.put(URL_ACTUALIZAR, datos);
        return response.data;
    } catch (error) {
        console.error("Error al actualizar alumno:", error);
        throw error;
    }
};

// Servicio para eliminar un alumno (puedes implementar más adelante)

const URL_ELIMINAR = " ";

export const eliminarAlumno = async (id) => {
    try {
        const response = await axios.delete(`${URL_ELIMINAR}/${id}`);
        return response.data;
    } catch (error) {
        console.error("Error al eliminar alumno:", error);
        throw error;
    }
};

// Servicio para cambiar el estado de habilitación de un alumno
export const cambiarEstadoAlumno = async (idAlumno, habilitado) => {
    const URL_CAMBIAR_ESTADO = `/api/alumnos/cambiarEstado/${idAlumno}?habilitado=${habilitado}`;
    try {
        const response = await fetch(URL_CAMBIAR_ESTADO, {
            method: "PUT",
            headers: {
                "Content-Type": "application/json",
            },
        });

        if (!response.ok) {
            const errorData = await response.json();
            throw new Error(`Error al cambiar el estado: ${errorData.message || response.statusText}`);
        }
        // Procesa la respuesta exitosa
        const data = await response.json();
        return data; // Devuelve la respuesta de la API
    } catch (error) {
        console.error("Error al cambiar el estado del alumno:", error);
        throw error; // Lanza el error para manejarlo en el componente
    }
};

// Servicio para buscar alumnos
export const buscarAlumnos = async (textoBusqueda) => {
    const URL_BUSCAR = `/api/alumnos/buscar?texto=${textoBusqueda}`;
    try {
        const response = await fetch(URL_BUSCAR, {
            method: "GET",
            headers: {
                "Content-Type": "application/json",
            },
        });

        if (!response.ok) {
            throw new Error(`Error al buscar alumnos: ${response.statusText}`);
        }

        const data = await response.json();
        return data; // Devuelve la lista de alumnos filtrados
    } catch (error) {
        console.error("Error al buscar alumnos:", error);
        throw error; // Lanza el error para manejarlo en el componente
    }
};

// Servicio para actualizar los datos de una persona
export const actualizarPersona = async (datos) => {
    const URL_ACTUALIZAR_PERSONA = "/api/actualiza/persona";
    try {
        const response = await fetch(URL_ACTUALIZAR_PERSONA, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(datos), // Envía los datos en el cuerpo de la solicitud
        });

        if (!response.ok) {
            throw new Error(`Error al actualizar persona: ${response.statusText}`);
        }

        const data = await response.json();
        return data; // Devuelve la respuesta de la API
    } catch (error) {
        console.error("Error al actualizar persona:", error);
        throw error; // Lanza el error para manejarlo en el componente
    }
};

// Servicio para enviar correos electrónicos
export const enviarCorreo = async (destinatario, asunto, contenido) => {
    const URL_CORREO = `/api/correo/enviar?destinatario=${encodeURIComponent(
        destinatario
    )}&asunto=${encodeURIComponent(asunto)}&contenido=${encodeURIComponent(contenido)}`;
    try {
        const response = await fetch(URL_CORREO, {
            method: "POST",
        });

        if (!response.ok) {
            throw new Error(`Error al enviar correo: ${response.statusText}`);
        }

        const data = await response.json(); // El backend devuelve un JSON
        return data; // Devuelve la respuesta del backend
    } catch (error) {
        console.error("Error al enviar correo:", error);
        throw error; // Lanza el error para manejarlo en el componente
    }
};

