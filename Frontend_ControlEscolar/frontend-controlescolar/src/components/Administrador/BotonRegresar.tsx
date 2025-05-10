import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import "../../pages/Administrador/Usuarios/Alumnos/AdministraAlumno.css"

function BotonRegresar({ textoBoton }: { textoBoton: string}) {
    const navigate = useNavigate();
    /* const [mostrarFormulario, setMostrarFormulario] = useState(false); */
    return (
    <div className="botones-superiores">
        <button className="btn-regresar" onClick={() => navigate(-1)}>
            ⭠ Regresar
        </button>
    </div>
    )
}
export default BotonRegresar;