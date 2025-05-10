
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