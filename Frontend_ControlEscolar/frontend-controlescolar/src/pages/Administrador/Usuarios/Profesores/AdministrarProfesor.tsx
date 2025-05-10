import React, { useState } from "react";
import ProfesoresTable from "../../../../components/Administrador/Usuarios/Profesores/ProfesoresTable.js";
import "../Alumnos/AdministraAlumno.css"
import BotonRegresar from "../../../../components/Administrador/BotonRegresar.js"
import ProfesorRegistro from "../../../../components/Administrador/Usuarios/Profesores/ProfesorRegistro.js";
import {registrarProfesor, enviarCorreo} from "../../../../services/Administrador/Usuarios/Profesor/ProfesorService.js";
function AdministrarProfesor(){

    const [mostrarFormulario, setMostrarFormulario] = useState(false);
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
            setMostrarFormulario(false); // Oculta el formulario
        } catch (error) {
            alert("Error al registrar alumno o enviar correo. Revisa los datos e intenta nuevamente.");
        }
    };
    return(
        <div className="container">
            <h1>Administrar Profesor</h1>
            <BotonRegresar textoBoton="Agregar Profesor" />
            <button className="btn-agregar" onClick={() => setMostrarFormulario(true)}>
                Agregar Profesor
            </button>
            <ProfesoresTable />

            <ProfesorRegistro
                mostrarFormulario={mostrarFormulario}
                setMostrarFormulario={setMostrarFormulario}
            />
        </div>

    )
}
export default AdministrarProfesor;