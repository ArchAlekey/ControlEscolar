import { createContext, use, useContext, useEffect, useState } from "react";

const AuthContext = createContext();

export function AuthProvider({ children }){
    const [auth, setAuth] = useState({
        token: null,
        idcategoria: null,
        usuario: null,
        id: null
    });

    useEffect(()=>{
        const token = localStorage.getItem("token");
        const idcategoria = localStorage.getItem("idcategoria");
        const usuario = localStorage.getItem("usuario");
        const id = localStorage.getItem("id");

        if(token && idcategoria){
            setAuth({token, idcategoria: Number(idcategoria), usuario, id});
        };
    },[]);

    return (
        <AuthContext.Provider value={{auth, setAuth}}>
            {children}
        </AuthContext.Provider>
    );
}

export function useAuth(){
    return useContext(AuthContext);
}