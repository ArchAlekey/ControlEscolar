import React, { useEffect, useState } from "react";
import { Endpoints } from "../../api/ApiEndpoints";
import BotonLogin from "../../components/boton/boton"

function ConsultaHorario(){

    const [horarios, setHorarsio] = useState([]);
    const [loading, setLoading] = useState (false);
    const [Carrera, setCarrera] = useState("");
    const [Orden, setOrden] = useState("1");
    const [MostrarTabla, setMostrarTabla] = useState(false);

    const handleSubmit = (e) => {
      e.preventDefault();
      setLoading(true);

      const IdCarrera = Carrera;
      const OrdenSeleccionado = Orden;

      fetch(Endpoints.horarios(IdCarrera, OrdenSeleccionado))
      .then(response => response.json())
      .then(data => {
          setHorarsio(data.data || []);
          setLoading(false);
          setMostrarTabla(true)
          console.log(data.data);
      })
      .catch(err => {
          console.log("Error al consultar los horarios", err);
          setLoading(false);
      });
    }

    
    return (
      <div className="contenedor-tbl">
      {!MostrarTabla ? (
        <form onSubmit={handleSubmit} className="form-filtro">
          <h1 className="h1-DP">Consultar horarios</h1>
          <div className="contenedor-input-select">
            <label htmlFor="carrera" className="label-form-horarios">Carrera:</label>
            <select
              id="carrera"
              value={Carrera}
              onChange={(e) => setCarrera(e.target.value)}
              required
              className="input-select"
            >
              <option value="">-- Selecciona una carrera --</option>
              <option value="1">MAC</option>
              {/* Agrega más carreras según tu sistema */}
            </select>
          </div>
          <div className="contenedor-input-select">
            <label htmlFor="orden" className="label-form-horarios">Orden:</label>
            <select
              id="orden"
              value={Orden}
              onChange={(e) => setOrden(e.target.value)}
              className="input-select"
            >
              <option value="1">Ascendente</option>
              <option value="2">Descendente</option>
            </select>
          </div>
          <BotonLogin titulo="Buscar"/>
        </form>
      ) : (
        <>
          <h1 className="h1-DP">
            Horarios correspondientes al Periodo: {horarios[0]?.cperiodo}
          </h1>
          {loading ? (
            <p>Cargando...</p>
          ) : horarios.length > 0 ? (
            <table className="tbl-horarios">
              <thead>
                <tr className="h-table">
                  <th>Materia</th>
                  <th>Clave</th>
                  <th>Carrera</th>
                  <th>Periodo</th>
                  <th>Semestre</th>
                  <th>Grupo</th>
                  <th>Profesor</th>
                  <th>Número de cuenta</th>
                  <th>Correo</th>
                  <th>Horario</th>
                </tr>
              </thead>
              <tbody>
                {horarios.map((horario, index) => (
                  <tr key={index} className="c-tbl">
                    <td>{horario.cnombre_materia}</td>
                    <td>{horario.cclave_materia}</td>
                    <td>{horario.ccarrera}</td>
                    <td>{horario.cperiodo}</td>
                    <td>{horario.nsemestre}</td>
                    <td>{horario.cgrupo}</td>
                    <td>{horario.profesor}</td>
                    <td>{horario.cnumero_cuenta}</td>
                    <td>{horario.ccorreo_institucional}</td>
                    <td>{horario.chorario}</td>
                  </tr>
                ))}
              </tbody>
            </table>
          ) : (
            <p>No se encontraron horarios.</p>
          )}
        </>
      )}
    </div>
  );
    
};

export default ConsultaHorario;