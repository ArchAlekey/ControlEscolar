import React, { useEffect, useRef, useState } from "react";
import { Endpoints } from "../../api/ApiEndpoints";import Boton from "../../components/boton/boton";
import { useNavigate } from "react-router-dom";
import html2pdf from "html2pdf.js";

function ConsultaInscripcion(){

    const [inscripciones, setInscripciones] = useState([]);
    const idUsuario = Number(localStorage.getItem("id"));
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

    const handlePrint = () => {
        const element = pdfRef.current;
        const opt = {
          margin:       0.5,
          filename:     `Inscripcion_${usuario}.pdf`,
          image:        { type: 'jpeg', quality: 0.98 },
          html2canvas: { scale: 1.5, windowWidth: 1200 },
          jsPDF:        { unit: 'in', format: 'letter', orientation: 'landscape' }
        };
        html2pdf().set(opt).from(element).save();
      };

    return(
        <div className="contenedor-main-insc" >
            <h1 className="h1-DP">Tu Inscripción</h1>
            <h2 className="h1-DP">Usuario: {usuario}</h2>
            <div className="contenedor-tabla">
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
                    <Boton titulo="Imprimir" onClick={handlePrint}/>
                    <Boton titulo="Regresar" onClick={() => navigate(home())}/>
                </div>
            </div>
        </div>
    )
};

export default ConsultaInscripcion;