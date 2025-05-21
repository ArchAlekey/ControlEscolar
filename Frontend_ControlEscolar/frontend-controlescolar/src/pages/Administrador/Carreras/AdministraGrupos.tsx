import { useEffect, useState } from "react";
import {consultarGrupos} from "../../../services/Administrador/Grupos/GruposService.js"
import { error } from "toastr";

interface Grupo {
    idGrupo: number;
    grupo: string;
    habilitado: boolean;
    fechaAlta?: string;
    fechaBaja?: string | null;
}

function AdministraGrupo(){

    const [grupos, setGrupos] = useState<Grupo[]>([]);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        consultarGrupos()
        .then(data => {
            setGrupos(data);
            setLoading(false);
        })
        .catch(error => {
            console.error(error);
            setLoading(false);
        });
    }, []);

    return(
        <div>
            <h1>Administra Grupos</h1>
            <h2>Grupos</h2>
            <ul>
                {grupos.map((grupo) => (
                    <li key={grupo.idGrupo}>
                        <b>{grupo.grupo}</b> - {grupo.habilitado ? "Habilitado" : "Inhabilitado"}
                    </li>
                ))}
            </ul>
        </div>
    )
}
export default AdministraGrupo;