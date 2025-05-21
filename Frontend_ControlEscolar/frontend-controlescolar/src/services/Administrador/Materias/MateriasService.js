/* export async function consultarMaterias(idCarrera: number, idSemestre: number){
    const url = `http://localhost:8082/materias/mostrarMaterias?idCarrera=${idCarrera}&idSemestre=${idSemestre}`;
    const response = await fetch(url);
    if(!response.ok) throw new Error("Error al obtener materias");
    return await response.json();
}

 */