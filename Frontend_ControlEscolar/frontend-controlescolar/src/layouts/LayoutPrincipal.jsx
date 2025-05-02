import React, { use } from "react";
import BotonDashBoard from '../components/BotonesDashBoard/BotonDashBoard';
import { useAuth } from "../components/Auth/AuthProvider";
import { Link, Outlet, useNavigate, useLocation } from "react-router-dom";

function LayoutPrincipal(){

        /* Navegación */
        const { logout } = useAuth();
        const navigate = useNavigate();
        const idcat = Number(localStorage.getItem("idcategoria"));
        const posicion = useLocation();
        const rutaPadre = posicion.pathname === '/Alumno' || posicion.pathname === '/Profesor' || posicion.pathname === '/Administrador';        

        const handleLogout = () => {
            logout();
            navigate("/");
        };

        const switchBG = () => {
            switch(idcat){
                case 1: return "color-bg-alumno";
                case 2: return "color-bg-profesor";
                case 3: return "color-bg-admin";
                default: return "color-default";
            }
        };
        const switchMain = () => {
            switch(idcat){
                case 1: return "color-main-alumno";
                case 2: return "color-main-profesor";
                case 3: return "color-main-admin";
                default: return "color-main";
            }
        };

        const btnHome = () => {
            switch(idcat){
                case 1: return "/Alumno";
                case 2: return "/Profesor";
                case 3: return "/Administrador";
                default: return "/NaN";
            }
        }

    return(
        <div className="contenedor_layout">
            <header className={`${switchBG()}`}>
                <div className="contenedor_botones_header">
                    <i onClick={()=>navigate(`${btnHome()}`)} className="fa-solid fa-house"></i>
                </div>
                <div className="contenedor_botones_header">

                </div>
                <div className="contenedor_botones_header" >
                    <i onClick={handleLogout} className="fa-solid fa-right-from-bracket"></i>
                </div>
            </header>
            <main className = {`${switchMain()}`}>
                {idcat === 1 && rutaPadre &&(
                    <div className="contenedor-menus">
                        <BotonDashBoard titulo = "Datos Personales" onClick={() => navigate('datos')}/>
                        <BotonDashBoard titulo = "Consulta Horario" onClick={() => navigate('horarios')}/>
                        <BotonDashBoard titulo = "Inscripcion" onClick={() => navigate('inscripcion')}/>
                        <BotonDashBoard titulo = "Consulta Inscripcion" onClick={()=> navigate('consulta-inscripcion')}/>
                        <BotonDashBoard titulo = "Consulta Calificaciones" onClick={()=> navigate('consulta-calificaciones')}/>
                        <BotonDashBoard titulo = "Consulta Historial" onClick={()=> navigate('consulta-historial')}/>
                    </div>
                )}

                {idcat === 2 && rutaPadre &&(
                    <div className="contenedor-menus">
                        <BotonDashBoard titulo = "Datos Personales" onClick={() => navigate('datos')}/>
                        <BotonDashBoard titulo = "Consulta Grupos Asignados" onClick={() => navigate('gruposAsignados')}/>
                        <BotonDashBoard titulo = "Calificar Alumnos" onClick={() => navigate('calificarAlumnos')}/>
                    </div>
                )}
                {idcat === 3 && (
                    <div className="contenedor-menus">
                        <BotonDashBoard titulo = "Administrar Usuarios"/>
                        <BotonDashBoard titulo = "Administrar Grupos"/>
                        <BotonDashBoard titulo = "Administrar Periodos"/>
                        <BotonDashBoard titulo = "Administrar Materias"/>
                        <BotonDashBoard titulo = "Datos Personales"/>
                    </div>
                )}
                {idcat === 4 && (
                    <div className="contenedor-menus">
                        <BotonDashBoard titulo = "Administrar Usuarios"/>
                        <BotonDashBoard titulo = "Administrar Grupos"/>
                        <BotonDashBoard titulo = "Administrar Periodos"/>
                        <BotonDashBoard titulo = "Administrar Materias"/>
                        <BotonDashBoard titulo = "Datos Personales"/>
                    </div>
                )}
                <div className="contenedor_dinamico">
                    <Outlet />
                </div>
            </main>
            <footer className={`${switchBG()}`}>
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

export default LayoutPrincipal;