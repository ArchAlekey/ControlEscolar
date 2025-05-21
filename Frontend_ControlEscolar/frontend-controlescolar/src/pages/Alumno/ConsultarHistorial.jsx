import React, { useEffect, useState } from "react";
import { Endpoints } from "../../api/ApiEndpoints";
import Boton from "../../components/boton/boton";
import { useNavigate } from "react-router-dom";

function ConsultarHistorial() {
    const [historialLista, setHistorialLista] = useState([]);
    const [promedio, setPromedio] = useState(null);
    const nid_usuario = Number(localStorage.getItem("idUsuario"));
    const navigate = useNavigate();

    useEffect(() => {
        const consultarHistorial = async () => {
            try {
                const respuesta = await fetch(Endpoints.consultaHistorial(nid_usuario));
                const data = await respuesta.json();
                setHistorialLista(data || []);

                // Calcular promedio aquí directamente
                if (data && data.length > 0) {
                    const calificaciones = data.map(item => item.ncalificación);
                    const suma = calificaciones.reduce((acc, cal) => acc + cal, 0);
                    const promedioFinal = (suma / calificaciones.length).toFixed(2);
                    setPromedio(promedioFinal);
                }

            } catch (e) {
                console.error("No se pudo recuperar tu historial, por favor, contacta a tu administrador.", e);
            }
        };

        consultarHistorial();
    }, []);

    const idcat = Number(localStorage.getItem("idcategoria"));
    const home = () => {
        switch (idcat) {
            case 1: return "/Alumno";
            case 2: return "/Profesor";
            case 3: return "/Administrador";
            case 4: return "/SuperUs";
            default: return "/NaN";
        }
    };

    return (
        <div className="container-main">
            <div className="container-main-historial">
                <h1 className="h1-DP">Historial Académico</h1>
                <div className="container-table">
                    <table className="table">
                        <thead className="t-head">
                            <tr className="t-promedio">
                                <th colSpan="7">Promedio: {promedio ?? "Sin calificaciones"}</th>
                            </tr>
                            <tr>
                                <th>Id Inscripción</th>
                                <th>Materia</th>
                                <th>Clave</th>
                                <th>Calificación</th>
                                <th>Semestre</th>
                                <th>Periodo</th>
                                <th>Año</th>
                            </tr>
                        </thead>
                        <tbody>
                            {historialLista.map((historial, index) => (
                                <tr key={index} className="t-body">
                                    <td className="t-celda">{historial.nid_insc_alumno}</td>
                                    <td className="t-celda">{historial.cnombre_materia}</td>
                                    <td className="t-celda">{historial.cclave_materia}</td>
                                    <td className="t-celda">{historial.ncalificación}</td>
                                    <td className="t-celda">{historial.nsemestre}</td>
                                    <td className="t-celda">{historial.cperiodo}</td>
                                    <td className="t-celda">{historial.canio}</td>
                                </tr>
                            ))}
                        </tbody>
                    </table>
                </div>
                <div className="elemento-insc-form-btn">
                    <Boton titulo="Guardar Historial" />
                    <Boton titulo="Regresar al Inicio" onClick={() => navigate(home())} />
                </div>
            </div>
        </div>
    );
};

export default ConsultarHistorial;
