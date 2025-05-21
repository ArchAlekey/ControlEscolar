import BotonDashBoard from '../../../components/BotonesDashBoard/BotonDashBoard';
import BotonRegresar from '../../../components/Administrador/BotonRegresar'
import { useAuth } from "../../../components/Auth/AuthProvider";
import { Outlet, useNavigate, useLocation } from "react-router-dom";

function Carreras(){
    /* Navegación */
    const { logout } = useAuth();
    const navigate = useNavigate();
    const location = useLocation(); // Hook para obtener la ruta actual

    const handleLogout = () => {
    logout();
    navigate("/");
    };

    // Verifica si estás en la ruta base
    const isRootPath = location.pathname === "/Administrador/carrera";
    return (

        <div>
            {isRootPath && (   
                <div className="contenedor-menus">
                    <h1>Administra Carreras</h1>
                    <BotonRegresar />
                    <BotonDashBoard titulo="Carreras" onClick={() => navigate('carreras')} icon={<i className="fa-solid fa-graduation-cap"></i>} />
                    <BotonDashBoard titulo="Grupos" onClick={() => navigate('grupos')} icon={<i className="fa-solid fa-chalkboard-user"></i>} />
                    <BotonDashBoard titulo="Materias" onClick={() => navigate('materias')} icon={<i className="fa-solid fa-book"></i>} />
                    <BotonDashBoard titulo="Horarios" onClick={() => navigate('horarios')} icon={<i className="fa-solid fa-clock"></i>} />
                </div>
            )}
            <Outlet />
        </div>
    );
}
export default Carreras;