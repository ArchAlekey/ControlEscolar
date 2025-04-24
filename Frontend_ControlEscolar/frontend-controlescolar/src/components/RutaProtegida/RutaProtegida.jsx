import { Navigate, Outlet } from "react-router-dom";
import { useAuth } from "../Auth/AuthProvider";


<<<<<<< HEAD
const RutaProtegida = ({idcategoria }) => {
    const { auth } = useAuth();
=======
const RutaProtegida = ({ children, idcategoria }) => {
    const { auth, loading } = useAuth();

    if (loading){
        return <div>Cargando...</div>
    }
>>>>>>> 60bc51c9c824a4e6d4c18bc228846c6d0b393c37

    if(!auth.token){
        return <Navigate to = "/" />
    }

    if(idcategoria && auth.idcategoria !== idcategoria){
        return <Navigate to = "/" replace/>
    }

    return <Outlet />;
}

export default RutaProtegida;