import React, { useState } from "react";
import { actualizarPersona } from "../../../../services/Administrador/Usuarios/Alumno/AlumnoService";
import toastr from "toastr";

function AlumnoActualiza({personaSeleccionada, setPersonaSeleccionada, mostrarFormulario, setMostrarFormulario, handleSubmitPersona, handleChangePersona }) {
    // Define la interfaz para los datos del alumno
    interface Alumno {
        nid_persona: number;
        nid_academico_alumno: number;
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
   /*  const [mostrarFormulario, setMostrarFormulario] = useState(false); */
    /* const [personaSeleccionada, setPersonaSeleccionada] = useState<Persona | null>(null); */

    // Maneja la selección de una persona para editar
    const seleccionarPersona = (persona: Persona) => {
        setPersonaSeleccionada(persona);
        setMostrarFormulario(true); // Muestra el formulario de edición
    };

    // Maneja el envío del formulario para actualizar la persona
/*     const handleSubmitPersona = async (e: React.FormEvent) => {
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
    }; */

    // Maneja el cambio en los campos del formulario de edición
/*     const handleChangePersona = (e: React.ChangeEvent<HTMLInputElement | HTMLSelectElement>) => {
    if (personaSeleccionada) {
        setPersonaSeleccionada({
            ...personaSeleccionada,
            [e.target.name]: e.target.value,
            });
        }
    }; */
    // Reorganizar las líneas para mejorar la estructura y legibilidad
    return (
        <>
            {mostrarFormulario && personaSeleccionada && (
                <div className="modal-overlay">
                    <div className="modal">
                        <h2>Editar Persona</h2>
                        <form onSubmit={handleSubmitPersona}>
                            <div className="form-row">
                                <label>
                                    Nombre:
                                    <input
                                        type="text"
                                        name="cnombre"
                                        value={personaSeleccionada.cnombre}
                                        onChange={handleChangePersona}
                                    />
                                </label>
                                <label>
                                    Apellidos:
                                    <input
                                        type="text"
                                        name="capellidos"
                                        value={personaSeleccionada.capellidos}
                                        onChange={handleChangePersona}
                                    />
                                </label>
                                <label>
                                    Sexo:
                                    <select
                                        name="bsexo"
                                        value={personaSeleccionada.bsexo ? "true" : "false"}
                                        onChange={handleChangePersona}
                                    >
                                        <option value="true">Masculino</option>
                                        <option value="false">Femenino</option>
                                    </select>
                                </label>
                            </div>
                            <div className="form-row">
                                <label>
                                    Edad:
                                    <input
                                        type="number"
                                        name="nedad"
                                        value={personaSeleccionada.nedad}
                                        onChange={handleChangePersona}
                                    />
                                </label>
                                <label>
                                    Fecha de Nacimiento:
                                    <input
                                        type="date"
                                        name="dfecha_nacimiento"
                                        value={personaSeleccionada.dfecha_nacimiento}
                                        onChange={handleChangePersona}
                                    />
                                </label>
                                <label>
                                    CURP:
                                    <input
                                        type="text"
                                        name="getcCURP"
                                        value={personaSeleccionada.getcCURP}
                                        onChange={handleChangePersona}
                                    />
                                </label>
                            </div>
                            <div className="form-row">
                                <label>
                                    RFC:
                                    <input
                                        type="text"
                                        name="getcRFC"
                                        value={personaSeleccionada.getcRFC}
                                        onChange={handleChangePersona}
                                    />
                                </label>
                                <label>
                                    Número de Celular:
                                    <input
                                        type="text"
                                        name="cnumero_celular"
                                        value={personaSeleccionada.cnumero_celular}
                                        onChange={handleChangePersona}
                                    />
                                </label>
                            </div>
                            <button type="submit">Guardar</button>
                            <button type="button" onClick={() => setMostrarFormulario(false)}>
                                Cancelar
                            </button>
                        </form>
                    </div>
                </div>
            )}
        </>
    )
}

export default AlumnoActualiza;