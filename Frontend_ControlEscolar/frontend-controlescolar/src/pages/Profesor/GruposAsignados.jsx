import React, { useEffect, useState } from "react";
import { Endpoints } from "../../api/ApiEndpoints";
import Boton from "../../components/boton/boton";

function GruposAsignados(){

    const [gruposAsignados, setGruposAsignados] = useState([]);
    const [listaAlumnos, setListaAlumnos] = useState([]);
    const [nid_grupo, setIdGrupo] = useState(0);
    const [nid_materia, setIdMateria] = useState(0);

    const nid_persona = Number(localStorage.getItem("idPersona"));
    /* console.log(nid_persona); */

    useEffect(() => {
        const handleGruposAsig = async () =>{
            try{
                const respuesta = await fetch(Endpoints.consultaGruposAsig(nid_persona));
                const data = await respuesta.json();
                setGruposAsignados (data || "No hay materias asignadas para este profesor");
                
            } catch (e){
                console.error("Error al consultar los grupos: ", e);
            }
        }
        handleGruposAsig();
    }, [nid_persona]);

    const handleListaAlumnos = async (nid_grupo, nid_materia) => {
        try{
            const respuesta = await fetch(Endpoints.consultaListaAlumnos(nid_grupo, nid_materia));
            const data = await respuesta.json();
            setListaAlumnos(data || []);
            setIdGrupo(nid_grupo);
            setIdMateria(nid_materia);
        } catch (e){
            console.error("No se pudo recuperar la lista de almunos inscritos: ", e);
        }
    };

    return (
        <div className="container-main">
            <h1 className="h1-DP">Materias</h1>
            { gruposAsignados.map((grupos, index) => (
                <details key={index} className="container-details">
                    <summary className="container-summary">
                        {grupos.cnombre_materia} | {grupos.cgrupo}
                    </summary>
                    <div className="container-info-grupo">
                        <h2>{grupos.cnombre_materia}</h2>
                        <ul>
                            <li><strong>Clave: </strong>{grupos.cclave_materia}</li>
                            <li><strong>Periodo: </strong>{grupos.cperiodo}</li>
                            <li><strong>Grupo: </strong>{grupos.cgrupo}</li>
                            <li><strong>Horario: </strong>{grupos.chorario}</li>
                        </ul>
                    </div>
                    <Boton titulo="Alumnos Inscritos" onClick={() => handleListaAlumnos(grupos.nid_grupo, grupos.nid_materia)}/>
                    {/* Mostrar alumnos solo si este grupo fue seleccionado */}
                    {nid_grupo === grupos.nid_grupo && (
                        listaAlumnos.length > 0 ? (
                            <div className="lista-alumnos">
                                <h2 className="h1-DP">Alumnos inscritos</h2>
                                <table className="table-grupos">
                                    <thead className="t-head">
                                        <tr>
                                            <th>Nombre</th>
                                            <th>Número de cuenta</th>
                                            <th>Correo Institucional</th>
                                            <th>Correo Personal</th>
                                        </tr>
                                    </thead>
                                    <tbody className="t-body">
                                    {listaAlumnos.map((alumno, idx) => (
                                        <tr key={idx}>
                                            <td className="t-celda">{alumno.Nombre}</td>
                                            <td className="t-celda">{alumno.cnumero_cuenta}</td>
                                            <td className="t-celda">{alumno.ccorreo_institucional}</td>
                                            <td className="t-celda">{alumno.ccorreo_personal}</td>
                                        </tr>
                                    ))}
                                    </tbody>
                                </table>
                                <Boton titulo="Cerrar la lista" onClick={() => {
                                    setListaAlumnos([]);
                                    setIdGrupo(0);
                                }}/>
                                <Boton titulo="Imprimir Lista" />
                            </div>
                        ) : (
                            <div className="lista-alumnos">
                                <h2 className="h1-DP">No hay alumnos inscritos en este grupo.</h2>
                                <Boton titulo="Cerrar" onClick={() => {
                                    setListaAlumnos([]);
                                    setIdGrupo(0);
                                }}/>
                            </div>
                        )
                    )}
                </details>
            ))}  
        </div>
    );
};

export default GruposAsignados;