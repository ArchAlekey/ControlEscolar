import React, { useEffect, useState } from "react";
import { Endpoints } from "../../api/ApiEndpoints";
import Swal from "sweetalert2";
import Boton from "../../components/boton/boton"
import { useNavigate } from "react-router-dom";

function Inscripcion() {
  const [opciones, setOpciones] = useState([]);
  const [seleccion, setSeleccion] = useState("");
  const [mostrarFormulario, setMostrarFormulario] = useState(false);
  const [mostrarDialogo, setMostrarDialogo] = useState(false);
  const [mostrarInsc, setMostrarInsc] = useState(false);
  const navigate = useNavigate();

  const nid_usuario = localStorage.getItem("id");
  const idcat = Number(localStorage.getItem("idcategoria"));

  useEffect(() => {
    const fetchOpciones = async () => {
      try {
        const res = await fetch(Endpoints.horariosInsc());
        const data = await res.json();
        setOpciones(data.data);
      } catch (error) {
        console.error("Error al obtener los datos: ", error);
      }
    };

    fetchOpciones();
  }, []);

  const handleInscribirse = async () => {
    if (!seleccion) {
        Swal.fire({
          icon: "warning",
          title: "Grupo no seleccionado",
          text: "Por favor, selecciona un grupo antes de inscribirte.",
          timer: 3000,
          showConfirmButton: false,
        });
        return;
    }
    try {
      const res = await fetch(Endpoints.inscribirse, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
          nid_usuario: nid_usuario,
          nid_grupo: seleccion,
        }),
      });

      const data = await res.json();
      console.log(data);
      setMostrarDialogo(true);
      
    } catch (err) {

      Swal.fire({
        icon: "error",
        title: "Error al tratar de hacer el registro.",
        text: "Contacte a su administrador.",
        timer: 3000,
        showConfirmButton: false,
      });
    }
    /* setMostrarDialogo(false); */
/*     setMostrarFormulario(false);
    setMostrarInsc(false); */
    
  };

  const finalizar = () => {
    setMostrarDialogo(false);
    setMostrarFormulario(false);
    setSeleccion("");
  };

  const home = () =>{
    switch(idcat){
      case 1: return "/Alumno";
      case 2: return "/Profesor";
      case 3: return "/Administrador";
      case 4: return "/SuperUs";
      default: return "/NaN";
    }
  }

  return (
    <div className="contenedor-main">
      <div className={`contenedor-insc ${mostrarFormulario ? "hidden" : ""}`}>
        <div className="element-info">
          <h1 className="h1-DP">Inscripciones</h1>
        </div>
        <div className="element-info-t">
          <h2>Importante</h2>
          <p>Solo puede realizar una inscripción</p>
          <p>Una vez finalizado su proceso de inscripción, no hay cambios ni bajas</p>
        </div>
        <div className="element-info">
          <Boton titulo="Realizar Inscripción" onClick={() => setMostrarFormulario(true)} />
        </div>
      </div>

      <div className={`contenedor-insc-form ${!mostrarFormulario ? "hidden" : ""}`}>
      <div className="elemento-insc-form-label"><h2 className="h1-DP">Selecciona un grupo</h2></div>
          <div className="elemento-insc-form-select">
            <select value={seleccion} onChange={(e) => setSeleccion(e.target.value)} className="select-form">
              <option value="" disabled>-- Selecciona un grupo --</option>
              {opciones.map((grupo) => (<option key={grupo.idGrupo} value={grupo.idGrupo}>
                  {grupo.strGrupo}
                </option>
              ))}
            </select>
          </div>
          <div className="elemento-insc-form-btn">
              <Boton titulo="Inscribirme" onClick={handleInscribirse} />
              <Boton titulo="Cancelar" onClick={() => navigate(home())}/>
          </div>
      </div>

      {mostrarDialogo && (
        <div className="contenedor-modal">
          <dialog open className="dialog-insc">
            <h1 className="h1-DP">Felicidades</h1>
            <div className="elemento-dialog"><p>Haz concluido tu inscripción</p></div>
            <div className="elemento-dialog"><Boton titulo="Finalizar" onClick={() => navigate(home())} /></div>
          </dialog>
        </div>
      )}
    </div>
  );
}

export default Inscripcion;
