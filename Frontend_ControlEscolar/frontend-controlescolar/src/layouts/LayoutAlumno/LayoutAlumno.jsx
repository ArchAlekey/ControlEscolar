import React from "react";
import './LayoutAlumno.css';
import BotonDashBoard from '../../components/BotonesDashBoard/BotonDashBoard';
import { useAuth } from "../../components/Auth/AuthProvider";
import { Link, useNavigate } from "react-router-dom";

function LayoutAlumno(){

        /* Navegación */
        const { logout } = useAuth();
        const navigate = useNavigate();

        const handleLogout = () => {
            logout();
            navigate("/");
        }

    return(
        <div className="contenedor_layout">
            <header>
                <div className="contenedor_botones_header">
                    <i className="fa-solid fa-house"></i>
                </div>
                <div className="contenedor_botones_header">

                </div>
                <div className="contenedor_botones_header" >
                    <i onClick={handleLogout} className="fa-solid fa-right-from-bracket"></i>
                </div>
            </header>
            <main>
                <div className="contenedor-menus">
                    <BotonDashBoard titulo="Datos Personales"><Link to="Datos-Personales"></Link></BotonDashBoard>
                    <BotonDashBoard titulo="Consulta horarios" />
                    <BotonDashBoard titulo="Inscripcion" />
                    <BotonDashBoard titulo="Consulta Inscripcion" />
                    <BotonDashBoard titulo="Historial Academico" />
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

export default LayoutAlumno;