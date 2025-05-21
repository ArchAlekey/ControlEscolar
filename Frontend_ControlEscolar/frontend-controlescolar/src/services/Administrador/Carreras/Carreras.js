export async function consultarCarreras() { 
    const response = await fetch ("http://localhost:8082/carreras/mostrar");
    if(!response.ok) throw new Error("Error al obtener carreras");
    return await response.json(); 
}