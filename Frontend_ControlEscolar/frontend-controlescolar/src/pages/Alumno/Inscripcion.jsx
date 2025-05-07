import React, { useRef } from "react";
import Boton from "../../components/boton/boton";

function Inscripcion(){

    const DialoggRef = useRef(null);
    const AbrirDialogo = () => {
        DialoggRef.current.showModal();
    };

    const CerrarDialogo = () => {
        DialoggRef.current.close();
    };

    return(
        <div className="contenedor-inscripcion">
            <h1 className="h1-DP">Inscripciones</h1>
                <div className="contenedor-form-inscripcion">
                    <Boton titulo="Inscribirse" onClick={AbrirDialogo}/>
                    <dialog className="modal-dialogo" ref={DialoggRef}>
                        <form>
                            <label htmlFor="">Grupos</label>
                            <select name="" id="">
                                <option value="">-- Selecciona un grupo --</option>
                                <option value="">A-11</option>
                                <option value="">A-12</option>
                                <option value="">A-13</option>
                                <option value="">A-14</option>
                            </select>
                            <Boton titulo="Inscribirse" onClick={CerrarDialogo}/>
                        </form>
                    </dialog>
                </div>
        </div>
    )
};

export default Inscripcion;