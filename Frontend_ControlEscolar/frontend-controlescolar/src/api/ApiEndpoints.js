const API_BASE = '/api';

export const Endpoints = {
    /* Generales */
    login: `${API_BASE}/usuario/valida`,
    datosPersonales: (nid_persona) => `${API_BASE}/consulta/datosPersonales?nid_persona=${nid_persona}`,

    /* End points para el modulo de alumnos */
    horarios: (IntCarrera, IntGrupo) => `${API_BASE}/horarios/consulta?IntCarrera=${IntCarrera}&IntGrupo=${IntGrupo}`,
    horariosInsc: () => `${API_BASE}/horarios/inscripcion`,
    inscribirse: `${API_BASE}/alumnos/insertaInscripcion`,
    consultaInscripcion: (nid_usuario) => `${API_BASE}/alumnos/consultaInscripcion?nid_usuario=${nid_usuario}`,
    
    /* End points para el modulo de profesores */
    consultaGruposAsig: (nid_persona) => `${API_BASE}/profesores/consultarGruposAsignados?nid_persona=${nid_persona}`

}