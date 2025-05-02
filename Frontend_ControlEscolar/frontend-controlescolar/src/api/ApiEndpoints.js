const API_BASE = '/api';

export const Endpoints = {
    login: `${API_BASE}/usuario/valida`,
    datosPersonales: (nid_persona) => `${API_BASE}/consulta/datosPersonales?nid_persona=${nid_persona}`,
    horarios: (IntCarrera, IntGrupo) => `${API_BASE}/horarios/consulta?IntCarrera=${IntCarrera}&IntGrupo=${IntGrupo}`
}