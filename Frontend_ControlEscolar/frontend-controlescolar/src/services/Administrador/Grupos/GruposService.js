export async function consultarGrupos () {
    const response = await fetch ("http://localhost:8082/grupos/mostrar")
    if(!response.ok) throw new Error("Error al obtener grupos");
    return await response.json();
}