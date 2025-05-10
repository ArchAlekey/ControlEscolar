import React, { useState, useEffect } from "react";
import {
    consultarCarreras,
    registrarProfesor,
    enviarCorreo,
} from "../../../../services/Administrador/Usuarios/Profesor/ProfesorService";
import "../../../../pages/Administrador/Usuarios/Alumnos/AdministraAlumno.css";
import toastr from "toastr";

interface Carrera {
    idCarrera: number;
    carrera: string;
}
function ProfesorRegistro({ mostrarFormulario, setMostrarFormulario }) {


/*     const [mostrarFormulario, setMostrarFormulario] = useState(false); */
    const [carreras, setCarreras] = useState<Carrera[]>([]);
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

    const handleChange = (e: React.ChangeEvent<HTMLInputElement | HTMLSelectElement>) => {
        const { name, value } = e.target;
        setDatos({
            ...datos,
            [name]: name === "bsexo" || name === "nedad" || name === "nid_carrera" ? parseInt(value) : value,
        });
    };

    useEffect(() => {
        const cargarCarreras = async () => {
            try {
                const carrerasObtenidas = await consultarCarreras();
                setCarreras(carrerasObtenidas);
            } catch (error) {
                alert("Error al cargar las carreras. Intenta nuevamente.");
            }
        };
        cargarCarreras();
    }, []);

    const generarNumeroCuenta = (curp: string): string => {
        if (!curp || curp.length < 10) {
            throw new Error("El CURP debe tener al menos 10 caracteres.");
        }
        return `20${curp.substring(0, 10)}`;
    };

    const handleRegistrar = async (e: React.FormEvent) => {
        e.preventDefault();
        try {
            const numeroCuenta = generarNumeroCuenta(datos.cCURP);
            const datosProfesor = { ...datos, cnumero_cuenta: numeroCuenta };

            const respuesta = await registrarProfesor(datosProfesor);
            toastr.success("Profesor registrado correctamente", "Éxito");

            const asunto = "Registro exitoso";
            const contenido = `Hola ${datos.cnombre} ${datos.capellidos}, tu número de cuenta es ${numeroCuenta} y tu contraseña es ${numeroCuenta}. Al iniciar sesión se te pedirá que la cambies.`;
            await enviarCorreo(datos.ccorreo_personal, asunto, contenido);

            toastr.success(`Correo enviado a ${datos.ccorreo_personal}`, "Éxito");

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
            setMostrarFormulario(false);
        } catch (error) {
            alert("Error al registrar profesor o enviar correo. Revisa los datos e intenta nuevamente.");
        }
    };

    useEffect(() => {
        if (mostrarFormulario) {
            document.body.classList.add("modal-open");
        } else {
            document.body.classList.remove("modal-open");
        }
    }, [mostrarFormulario]);

    return (
        <>
            {mostrarFormulario && (
                <div className="modal-overlay">
                    <div className="modal">
                        <h2>Registrar Profesor</h2>
                        <form onSubmit={handleRegistrar}>
                            <div className="form-row">
                                <label>
                                    Nombre:
                                    <input
                                        type="text"
                                        name="cnombre"
                                        value={datos.cnombre}
                                        onChange={handleChange}
                                        required
                                    />
                                </label>
                                <label>
                                    Apellidos:
                                    <input
                                        type="text"
                                        name="capellidos"
                                        value={datos.capellidos}
                                        onChange={handleChange}
                                        required
                                    />
                                </label>
                                <label>
                                    Sexo:
                                    <select name="bsexo" value={datos.bsexo} onChange={handleChange} required>
                                        <option value={1}>Masculino</option>
                                        <option value={0}>Femenino</option>
                                    </select>
                                </label>
                            </div>
                            <div className="form-row">
                                <label>
                                    Edad:
                                    <input
                                        type="number"
                                        name="nedad"
                                        value={datos.nedad}
                                        onChange={handleChange}
                                        required
                                    />
                                </label>
                                <label>
                                    Fecha de Nacimiento:
                                    <input
                                        type="date"
                                        name="dfecha_nacimiento"
                                        value={datos.dfecha_nacimiento}
                                        onChange={handleChange}
                                        required
                                    />
                                </label>
                                <label>
                                    CURP:
                                    <input
                                        type="text"
                                        name="cCURP"
                                        value={datos.cCURP}
                                        onChange={handleChange}
                                        required
                                    />
                                </label>
                            </div>
                            <div className="form-row">
                                <label>
                                    RFC:
                                    <input
                                        type="text"
                                        name="cRFC"
                                        value={datos.cRFC}
                                        onChange={handleChange}
                                        required
                                    />
                                </label>
                                <label>
                                    Número Celular:
                                    <input
                                        type="text"
                                        name="cnumero_celular"
                                        value={datos.cnumero_celular}
                                        onChange={handleChange}
                                        required
                                    />
                                </label>
                                <label>
                                    Carrera:
                                    <select name="nid_carrera" value={datos.nid_carrera} onChange={handleChange} required>
                                        <option value="">Seleccione una carrera</option>
                                        {carreras.map((carrera) => (
                                            <option key={carrera.idCarrera} value={carrera.idCarrera}>
                                                {carrera.carrera}
                                            </option>
                                        ))}
                                    </select>
                                </label>
                            </div>
                            <div className="form-row">
                                <label>
                                    Correo Personal:
                                    <input
                                        type="email"
                                        name="ccorreo_personal"
                                        value={datos.ccorreo_personal}
                                        onChange={handleChange}
                                        required
                                    />
                                </label>
                            </div>
                            <button type="submit">Registrar Profesor</button> <br />
                            <button type="button" onClick={() => setMostrarFormulario(false)}>
                                Cancelar
                            </button>
                        </form>
                    </div>
                </div>
            )}
        </>
    );
}

export default ProfesorRegistro;

