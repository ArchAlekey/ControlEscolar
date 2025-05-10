import React from "react";
import './BotonDashboard.css';

function BotonDashBoard({ titulo, onClick, icon }){

    return (
        <div className="contenedor_menu" onClick={onClick}>
            <span className="title-btn">{titulo}</span>
            {icon && <span className="icon-btn">{icon}</span>}
        </div>
    )
}

export default BotonDashBoard;