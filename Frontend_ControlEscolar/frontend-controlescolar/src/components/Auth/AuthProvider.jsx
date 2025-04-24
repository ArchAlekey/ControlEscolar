import { createContext, use, useContext, useEffect, useState } from "react";

const AuthContext = createContext();

export function AuthProvider({ children }){
    const [auth, setAuth] = useState({
        token: null,
        idcategoria: null,
        usuario: null,
        id: null
    });

    const [loading, setLoading] = useState(true);

    useEffect(()=>{
        const token = localStorage.getItem("token");
        const idcategoria = localStorage.getItem("idcategoria");
        const usuario = localStorage.getItem("usuario");
        const id = localStorage.getItem("id");

        if(token && idcategoria){
            setAuth({token, idcategoria: Number(idcategoria), usuario, id});
        };
        setLoading(false);
    },[]);

    const logout = () => {
        localStorage.removeItem("token");
        localStorage.removeItem("idcategoria");
        localStorage.removeItem("usuario");
        localStorage.removeItem("id");

        setAuth({
            token: null,
            idcategoria: null,
            usuario: null,
            id: null
        });
    };

    return (
        <AuthContext.Provider value={{auth, setAuth, loading, logout}}>
            {children}
        </AuthContext.Provider>
    );
}

export function useAuth(){
    return useContext(AuthContext);
}