import React from "react";
import './BotonDashBoard.css';

function BotonDashBoard({ titulo }){

    return (
        <div className="contenedor_menu">
            {titulo}
        </div>
    )
}

export default BotonDashBoard;