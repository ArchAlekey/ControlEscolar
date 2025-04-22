import React from "react";
import './BotonLogin.css';

function Boton({ titulo }){
    return(
        <button className="btnLogin">
            { titulo }
        </button>
    )
}

export default Boton;