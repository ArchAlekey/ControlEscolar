import React, { useEffect, useState } from "react";
import { Endpoints } from "../../../api/ApiEndpoints";
import BotonDashBoard from '../../../components/BotonesDashBoard/BotonDashBoard';
import { useAuth } from "../../../components/Auth/AuthProvider";
import { Outlet, useNavigate, useLocation } from "react-router-dom";
import BotonRegresar from "../../../components/Administrador/BotonRegresar"

function AdministraUsuarios() {
    /* Navegación */
    const { logout } = useAuth();
    const navigate = useNavigate();
    const location = useLocation(); // Hook para obtener la ruta actual

    const handleLogout = () => {
        logout();
        navigate("/");
    };

    const [persona, setPersona] = useState(null);
    const nid_persona = localStorage.getItem('id');

    useEffect(() => {
        fetch(Endpoints.datosPersonales(nid_persona))
            .then((res) => res.json())
            .then((data) => {
                setPersona(data.data);
                console.log(data);
            })
            .catch(err => console.log('Error al recuperar datos', err));
    }, [nid_persona]);

    // Verifica si estás en la ruta base
    const isRootPath = location.pathname === "/Administrador/usuario";

    return (
        <div>
            {isRootPath && (
                
                <div className="contenedor-menus">
                    <BotonRegresar />
                    <BotonDashBoard titulo="Alumno" onClick={() => navigate('alumno')} icon={<i className="fa-solid fa-user"></i>} />
                    <BotonDashBoard titulo="Profesor" onClick={() => navigate('profesor')} icon={<i className="fa-solid fa-chalkboard-teacher"></i>} />
                </div>
            )}
            {/* Aquí se renderizan las subrutas */}
            <Outlet />
        </div>
    );
}

export default AdministraUsuarios;