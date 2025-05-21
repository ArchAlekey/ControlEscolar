export async function consultarPeriodos() {
  const response = await fetch("http://localhost:8082/periodos/mostrar");
  if (!response.ok) throw new Error("Error al obtener periodos");
return await response.json();
}

export async function consultarCarreras() {
  const response = await fetch("http://localhost:8082/carreras/mostrar");
  if (!response.ok) throw new Error("Error al obtener carreras");
  return await response.json();
}

export async function consultarSemestres() {
  const response = await fetch("http://localhost:8082/semestres/mostrar");
  if (!response.ok) throw new Error("Error al obtener semestres");
  return await response.json();
}

export async function consultarGrupos() {
  const response = await fetch("http://localhost:8082/grupos/mostrar");
  if (!response.ok) throw new Error("Error al obtener grupos");
  return await response.json();
}

export async function consultarMateriasPorCarreraYSemestre(nid_carrera, nid_semestre) {
  const response = await fetch(`http://localhost:8082/materias/mostrarMaterias?idCarrera=${nid_carrera}&idSemestre=${nid_semestre}`);
  console.log("Llamando api:");
  if (!response.ok) throw new Error("Error al obtener materias");
  return await response.json();
}

export async function consultarHorarios() {
  const response = await fetch("http://localhost:8082/horarios/mostrarHorarios");
  if (!response.ok) throw new Error("Error al obtener horarios");
  return await response.json();
}

export async function consultarProfesores() {
  const response = await fetch("http://localhost:8082/profesores/academicosProfesores");
  if(!response.ok) throw new Error("Error al obtener profesores");
  return await response.json();
}