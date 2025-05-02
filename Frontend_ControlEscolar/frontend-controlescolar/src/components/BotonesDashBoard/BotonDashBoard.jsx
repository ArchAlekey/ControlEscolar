import React from "react";
import './BotonDashboard.css';

function BotonDashBoard({ titulo, onClick }){

    return (
        <div className="contenedor_menu" onClick={onClick}>
            {titulo}
        </div>
    )
}

export default BotonDashBoard;