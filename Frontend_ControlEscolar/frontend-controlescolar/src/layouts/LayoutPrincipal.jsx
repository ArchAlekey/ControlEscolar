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
        const rutaPadre = posicion.pathname === '/Alumno' || posicion.pathname === '/Profesor' || posicion.pathname === '/Administrador' || posicion.pathname === '/SuperUs';        

        const handleLogout = () => {
            logout();
            navigate("/");
        };

        const switchBG = () => {
            switch(idcat){
                case 1: return "color-bg-alumno";
                case 2: return "color-bg-profesor";
                case 3: return "color-bg-admin";
                case 4: return "color-bg-superus"
                default: return "color-default";
            }
        };
        const switchMain = () => {
            switch(idcat){
                case 1: return "color-main-alumno";
                case 2: return "color-main-profesor";
                case 3: return "color-main-admin";
                case 4: return "color-main-superus";
                default: return "color-main";
            }
        };

        const btnHome = () => {
            switch(idcat){
                case 1: return "/Alumno";
                case 2: return "/Profesor";
                case 3: return "/Administrador";
                case 4: return "/SuperUs";
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
                        <div className="contenedor-presetacion">
                            <p className="h1-DP">Bienvenido al sistema de</p>
                            <h1 className="h1-DP">Control Escolar</h1>
                        </div>
                        <div className="contenedor-btns">
                            <BotonDashBoard titulo = "Datos Personales" icon={<i className="fa-solid fa-user"></i>} onClick={() => navigate('datos')} />
                            <BotonDashBoard titulo = "Consulta Horario" icon={<i className="fa-solid fa-clock"></i>} onClick={() => navigate('horarios')}/>
                            <BotonDashBoard titulo = "Inscripcion" icon={<i className="fa-solid fa-school"></i>} onClick={() => navigate('inscripcion')}/>
                            <BotonDashBoard titulo = "Consulta Inscripcion" icon={<i className="fa-solid fa-table-list"></i>} onClick={()=> navigate('consulta-inscripcion')}/>
                            <BotonDashBoard titulo = "Consulta Calificaciones" icon={<i className="fa-solid fa-trophy"></i>} onClick={()=> navigate('consulta-calificaciones')}/>
                            <BotonDashBoard titulo = "Consulta Historial" icon={<i className="fa-solid fa-book-skull"></i>} onClick={()=> navigate('consulta-historial')}/>
                        </div>
                    </div>
                )}

                {idcat === 2 && rutaPadre &&(
                    <div className="contenedor-menus">
                        <div className="contenedor-presentacion">
                            <p className="h1-DP">Bienvenido al sistema de</p>
                            <h1 className="h1-DP">Control Escolar</h1>
                        </div>
                        <div className="contenedor-btns">
                            <BotonDashBoard titulo = "Datos Personales" icon={<i className="fa-solid fa-graduation-cap"></i>} onClick={() => navigate('datos')}/>
                            <BotonDashBoard titulo = "Consulta Grupos Asignados" icon={<i className="fas fa-list"></i>} onClick={() => navigate('gruposAsignados')}/>
                            <BotonDashBoard titulo = "Calificar Alumnos" icon={<i className="fa-solid fa-pencil"></i>} onClick={() => navigate('calificarAlumnos')}/>
                        </div>
                    </div>
                )}
                {idcat === 3 && rutaPadre &&(
                    <div className="contenedor-menus">
                        <div className="contenedor-presentacion">
                            <p className="h1-DP">Bienvenido al sistema de</p>
                            <h1 className="h1-DP">Control Escolar</h1>
                        </div>
                        <div className="contenedor-btns">
                            <BotonDashBoard titulo = "Administrar Usuarios"/>
                            <BotonDashBoard titulo = "Administrar Grupos"/>
                            <BotonDashBoard titulo = "Administrar Periodos"/>
                            <BotonDashBoard titulo = "Administrar Materias"/>
                            <BotonDashBoard titulo = "Datos Personales"/>
                        </div>
                    </div>
                )}
                {idcat === 4 && rutaPadre &&(
                    <div className="contenedor-menus">
                        <div className="contenedor-presentacion">
                            <p className="h1-DP">Bienvenido al sistema de</p>
                            <h1 className="h1-DP">Control Escolar</h1>
                        </div>
                        <div className="contenedor-btns">
                            <BotonDashBoard titulo = "Administrar Usuarios" icon={<i className="fa-solid fa-user-group"></i>}/>
                            <BotonDashBoard titulo = "Administrar Grupos"/>
                            <BotonDashBoard titulo = "Administrar Periodos"/>
                            <BotonDashBoard titulo = "Administrar Materias"/>
                            <BotonDashBoard titulo = "Datos Personales" icon={<i className="fa-solid fa-user-gear"></i>} onClick={() => navigate('datos')}/>
                        </div>
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

