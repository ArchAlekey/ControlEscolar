import React from "react";
import './BotonLogin.css';

function Boton({ titulo, onClick }){
    return(
        <button className="btnLogin" onClick={onClick}>
            { titulo }
        </button>
    )
}

export default Boton;