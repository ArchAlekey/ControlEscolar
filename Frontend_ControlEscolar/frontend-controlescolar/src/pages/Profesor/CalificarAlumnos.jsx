import React, { useEffect, useState } from "react";
import { Endpoints } from "../../api/ApiEndpoints";
import Boton from "../../components/boton/boton";
import Swal from "sweetalert2";

function CalificarAlumnos() {
    const [gruposAsignados, setGruposAsignados] = useState([]);
    const [alumnosPorGrupo, setAlumnosPorGrupo] = useState({});
    const [dialogData, setDialogData] = useState(null);

    const nid_persona = Number(localStorage.getItem("idPersona"));
    const [ncalificacion, setCalificacion] = useState(0);

    useEffect(() => {
        const handleGruposAsig = async () => {
            try {
                const respuesta = await fetch(Endpoints.consultaGruposAsig(nid_persona));
                const data = await respuesta.json();
                setGruposAsignados(data || []);
            } catch (e) {
                console.error("Error al consultar los grupos: ", e);
            }
        };
        handleGruposAsig();
    }, [nid_persona]);

    const handleListaAlumnos = async (nid_grupo, nid_materia) => {
        if (alumnosPorGrupo[nid_grupo]) return; // Ya se cargaron
        try {
            const respuesta = await fetch(Endpoints.consultaListaAlumnos(nid_grupo, nid_materia));
            const data = await respuesta.json();
            setAlumnosPorGrupo(prev => ({ ...prev, [nid_grupo]: data || [] }));
        } catch (e) {
            console.error("No se pudo recuperar la lista de alumnos inscritos: ", e);
        }
    };

    const asignaCalificacion = async () => {
        try {
            const respuesta = await fetch(Endpoints.calificar, {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify({
                    nid_horario_materia: dialogData.nid_horario_materia,
                    nid_usuario: dialogData.nid_usuario,
                    ncalificacion
                }),
            });
            const data = await respuesta.json();
            console.log(data);
            return true;
        } catch (e) {
            console.error("Error al tratar de insertar la calificación: ", e);
        }
    };

    const eliminaCalificacion = async (nid_horario_materia, nid_usuario, nombre) => {
        const confirm = await Swal.fire({
            icon: 'question',
            title: `¿Desea eliminar la calificación del alumn@: ${nombre}?`,
            showCancelButton: true,
            confirmButtonText: 'Sí, eliminar',
            cancelButtonText: 'Cancelar'
        });

        if (!confirm.isConfirmed) return;

        try {
            const respuesta = await fetch(Endpoints.eliminar, {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify({ nid_horario_materia, nid_usuario }),
            });
            const data = await respuesta.json();
            console.log(data);
            Swal.fire({
                icon: 'success',
                title: 'Eliminada',
                text: 'La calificación se eliminó correctamente.',
            });
        } catch (e) {
            console.error("No se pudo eliminar la calificación: ", e);
            Swal.fire({
                icon: 'error',
                title: 'Error',
                text: 'No se pudo eliminar la calificación.',
            });
        }
    };

    return (
        <div className="container-main">
            <h1 className="h1-DP">Calificar Alumnos</h1>
            {gruposAsignados.map((grupo, index) => (
                <details key={index} className="container-details" onClick={() => handleListaAlumnos(grupo.nid_grupo, grupo.nid_materia)}>
                    <summary className="container-summary">
                        {grupo.cnombre_materia} | {grupo.cgrupo}
                    </summary>
                    <div className="lista-alumnos">
                        {alumnosPorGrupo[grupo.nid_grupo] ? (
                            alumnosPorGrupo[grupo.nid_grupo].length > 0 ? (
                                <table className="table">
                                    <thead className="t-head">
                                        <tr>
                                            <th>Nombre</th>
                                            <th>Número de cuenta</th>
                                            <th>Calificación</th>
                                            <th>Calificar</th>
                                            <th>Eliminar</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        {alumnosPorGrupo[grupo.nid_grupo].map((alumno, idx) => (
                                            <tr key={idx} className="t-body">
                                                <td className="t-celda">{alumno.Nombre}</td>
                                                <td className="t-celda">{alumno.cnumero_cuenta}</td>
                                                <td className="t-celda">{alumno.ncalificacion}</td>
                                                <td className="icon-container calificar" onClick={() => {
                                                    setDialogData({
                                                        Nombre: alumno.Nombre,
                                                        nid_usuario: alumno.nid_usuario,
                                                        nid_horario_materia: alumno.nid_horario_materia
                                                    });
                                                }}>
                                                    <i className="icon fa-solid fa-plus"></i>
                                                </td>
                                                <td className="icon-container eliminar" onClick={() => eliminaCalificacion(alumno.nid_horario_materia, alumno.nid_usuario, alumno.Nombre)}>
                                                    <i className="icon fa-solid fa-trash-can"></i>
                                                </td>
                                            </tr>
                                        ))}
                                    </tbody>
                                </table>
                            ) : (
                                <p className="h1-DP">No hay alumnos inscritos en este grupo.</p>
                            )
                        ) : (
                            <p>Cargando alumnos...</p>
                        )}
                    </div>
                </details>
            ))}

            {dialogData && (
                <dialog open className="container-dialog-calif">
                    <div className="container-calif">
                        <p className="h1-DP">Asignar calificación del alumn@: {dialogData.Nombre}</p>
                        <div className="container-input">
                            <input
                                type="number"
                                value={ncalificacion}
                                onChange={(e) => setCalificacion(e.target.value)}
                                placeholder="Calificación"
                                className="input-calif"
                                min="0" max="10" step="0.1"
                            />
                        </div>
                        <div className="container-botones">
                            <Boton titulo="Calificar" onClick={async () => {
                                const exito = await asignaCalificacion();
                                if (exito) {
                                    Swal.fire({
                                        icon: 'success',
                                        title: 'Calificación guardada',
                                        text: "Refresque la ventana para visualizar los cambios.",
                                        timer: 3000,
                                        showConfirmButton: false
                                    });
                                    setDialogData(null);
                                }
                            }} />
                            <Boton titulo="Cancelar" onClick={() => setDialogData(null)} />
                        </div>
                    </div>
                </dialog>
            )}
        </div>
    );
}

export default CalificarAlumnos;
