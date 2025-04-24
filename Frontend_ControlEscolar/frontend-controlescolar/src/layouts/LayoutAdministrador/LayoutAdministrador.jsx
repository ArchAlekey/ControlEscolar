import React from "react";
/* import './LayoutProfesor.css'; */
import BotonDashBoard from "../../components/BotonesDashBoard/BotonDashBoard";

function LayoutAdministrador(){

    return(
        <div className="contenedor_layout">
            <header>
                
            </header>
            <main>
                <div className="contenedor-menus">
                    <BotonDashBoard titulo="C-Carreras"/>
                    <BotonDashBoard titulo="C-Grupos"/>
                    <BotonDashBoard titulo="C-Horarios"/>
                    <BotonDashBoard titulo="C-Materias"/>
                    <BotonDashBoard titulo="C-Periodos"/>
                    <BotonDashBoard titulo="C-Semestres"/>
                    <BotonDashBoard titulo="P-Administrador"/>
                    <BotonDashBoard titulo="P-Profesor"/>
                    <BotonDashBoard titulo="P-Alumnos"/>
                    <BotonDashBoard titulo="P-Horario Materias"/>
                    <BotonDashBoard titulo="P-Alumnos Inscritos"/>
                    <BotonDashBoard titulo="C-Usuarios"/>
                    <BotonDashBoard titulo="P-Datos Personales"/>
                    
                    
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

export default LayoutAdministrador;