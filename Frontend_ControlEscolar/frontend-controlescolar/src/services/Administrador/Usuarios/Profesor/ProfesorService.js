
//Validar que la URL sea correcta 
const URL_CONSULTAR = "/api/profesores/academicosProfesores";
const URL_CARRERAS = "/api/carreras/mostrar";
const URL_REGISTRAR = "/api/registrar/profesor";

export const consultarProfesores = async () => {
    try {
        const response = await fetch(URL_CONSULTAR, {
            method: "GET",
            headers: {
                "Content-Type": "application/json",
            },
        });
        if (!response.ok) {
            throw new Error(`Error al consultar profesores: ${response.statusText}`);
        }
        const data = await response.json();
        console.log("Respuesta completa de consultarProfesores:", data);
        return data; // Devuelve la lista de profesores
    } catch (error) {
        console.error("Error al consultar profesores:", error);
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

// Servicio para registrar un profesor
export const registrarProfesor = async (datos) => {
    try {
        const response = await fetch(URL_REGISTRAR, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(datos),
        });
        if (!response.ok) { 
            throw new Error(`Error al registrar profesor (servicio): ${response.json().message}`);
        }

        const data = await response.json();
        return data; 
    } catch (error) {
        console.error("Error al registrar profesor:", error);
        throw error; 
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

// Servicio para buscar profesores
export const buscarProfesores = async (textoBusqueda) => {
    const URL_BUSCAR = `/api/profesores/buscar?texto=${textoBusqueda}`;
    try {
        const response = await fetch(URL_BUSCAR, {
            method: "GET",
            headers: {
                "Content-Type": "application/json",
            },
        });

        if (!response.ok) {
            throw new Error(`Error al buscar profesores: ${response.statusText}`);
        }

        const data = await response.json();
        return data; // Devuelve la lista de profesores filtrados
    } catch (error) {
        console.error("Error al buscar profesores:", error);
        throw error; // Lanza el error para manejarlo en el componente
    }
};

// Servicio para cambiar el estado de habilitación de un profesor
export const cambiarEstadoProfesor = async (idProfesor, habilitado) => {
    const URL_CAMBIAR_ESTADO = `/api/profesores/cambiarEstado/${idProfesor}?habilitado=${habilitado}`;
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