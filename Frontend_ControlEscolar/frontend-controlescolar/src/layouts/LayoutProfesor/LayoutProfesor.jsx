import React from "react";
/* import './LayoutProfesor.css'; */
import BotonDashBoard from "../../components/BotonesDashBoard/BotonDashBoard";

function LayoutProfesor(){

    return(
        <div className="contenedor_layout">
            <header>
                
            </header>
            <main>
                <div className="contenedor-menus">
                    <BotonDashBoard titulo="Datos Personales"/>
                    <BotonDashBoard titulo="Grupos"/>
                    <BotonDashBoard titulo="Calificar Alumnos"/>
                </div>
            </main>
            <footer>
                <div className="secciones_footer">Aviso de privacidad</div>
                <div className="secciones_footer">Contactanos</div>
                <div className="secciones_footer"><p className="info secciones_footer">Lorem ipsum dolor sit amet consectetur adipisicing elit</p></div>
                <div className="iconos_redes secciones_footer">
                    <i className="fa-brands fa-facebook"></i>
                    <i className="fa-brands fa-whatsapp"></i>
                    <i className="fa-brands fa-github"></i>
                </div>
            </footer>
        </div>
    )
}

export default LayoutProfesor;