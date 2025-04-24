import { Navigate, Outlet } from "react-router-dom";
import { useState } from "react";
import { useAuth } from "../Auth/AuthProvider";


const RutaProtegida = ({ children, idcategoria }) => {
    const { auth, loading } = useAuth();

    if (loading){
        return <div>Cargando...</div>
    }

    if(!auth.token){
        return <Navigate to = "/" />
    }

    if(idcategoria && auth.idcategoria !== idcategoria){
        return <Navigate to = "/" replace/>
    }

    return <Outlet />;
}

export default RutaProtegida;