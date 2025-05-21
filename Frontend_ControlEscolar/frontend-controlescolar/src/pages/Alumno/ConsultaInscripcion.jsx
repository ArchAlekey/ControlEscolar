import React, { useEffect, useRef, useState } from "react";
import { Endpoints } from "../../api/ApiEndpoints";import Boton from "../../components/boton/boton";
import { useNavigate } from "react-router-dom";

function ConsultaInscripcion(){

    const [inscripciones, setInscripciones] = useState([]);
    const idUsuario = Number(localStorage.getItem("idUsuario"));
    const usuario = localStorage.getItem("usuario");
    const navigate = useNavigate();
    const pdfRef = useRef();

    useEffect(() => {
        const handleInscripcion = async () => {
            try{
                const res = await fetch(Endpoints.consultaInscripcion(idUsuario));
                const data = await res.json();
                setInscripciones(data || []);
                console.log(data);
            } catch (err){
                console.error("Error al obtener los datos: ", err);
            }
        };
        handleInscripcion();
    }, []);

    const idcat = Number(localStorage.getItem("idcategoria"))
    const home = () =>{
        switch(idcat){
          case 1: return "/Alumno";
          case 2: return "/Profesor";
          case 3: return "/Administrador";
          case 4: return "/SuperUs";
          default: return "/NaN";
        }
    };


    return(
        <div className="contenedor-main-insc" >
            <div className="contenedor-tabla">
                <h1 className="h1-DP">Tu Inscripción</h1>
                <h2 className="h1-DP">Usuario: {usuario}</h2>
                <table className="tbl-horarios" ref={pdfRef}>
                    <thead>
                        <tr className="h-table">
                            <th>Materia</th>
                            <th>Clave</th>
                            <th>Carrera</th>
                            <th>Grupo</th>
                            <th>Profesor</th>
                            <th>Correo de contacto</th>
                            <th>Horario</th>
                        </tr>
                    </thead>
                    <tbody>
                        {inscripciones.map((insc, index) => (
                            <tr key={index} className="c-tbl">
                                <td>{insc.cnombre_materia}</td>
                                <td>{insc.cclave_materia}</td>
                                <td>{insc.ccarrera}</td>
                                <td>{insc.cgrupo}</td>
                                <td>{insc.profesor}</td>
                                <td>{insc.ccorreo_institucional}</td>
                                <td>{insc.chorario}</td>
                            </tr>
                        ))}
                    </tbody>
                </table>
                <div className="elemento-insc-form-btn">
                    <Boton titulo="Imprimir" />
                    <Boton titulo="Regresar" onClick={() => navigate(home())}/>
                </div>
            </div>
        </div>
    )
};

export default ConsultaInscripcion;