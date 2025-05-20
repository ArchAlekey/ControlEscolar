package com.tramp.controlescolar.services;
import com.tramp.controlescolar.repository.AlumnosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AlumnosService {
    @Autowired
    private AlumnosRepository alumnosRepository;

    @Transactional 
    public void insertaInscripcion(Integer nid_usuario, Integer nid_grupo){
        alumnosRepository.insertarInscripcion(nid_usuario, nid_grupo);
    }

    @Transactional 
    public List<Map<String, Object>> consultaInscripcion(Integer nid_usuario){
        List<Object[]> resultados = alumnosRepository.consultarInscripcion(nid_usuario);
        List<Map<String, Object>> inscripciones = new ArrayList<>();

        //Iteramos sobre los resultados devueltos en el procedimiento 
        for(Object[] file: resultados){
            //Asignamos cada comlumna del resultado a su respectivo campo en el mapa
            Map<String, Object> inscripcion = new HashMap<>();
            inscripcion.put("cnombre_materia", file[0]);
            inscripcion.put("cclave_materia", file[1]);
            inscripcion.put("ccarrera", file[2]);
            inscripcion.put("cgrupo", file[3]);
            inscripcion.put("profesor", file[4]);
            inscripcion.put("ccorreo_institucional", file[5]);
            inscripcion.put("chorario", file[6]);
            
            //Agregamos el objecto inscripcion a la lista de resultados 
            inscripciones.add(inscripcion);
        }
        return inscripciones;
    }

    @Transactional
    public List<Map<String, Object>> obtenerAcademicosAlumnosConPersonas() {
        List<Object[]> resultados = alumnosRepository.findAcademicosAlumnosWithPersonas();
        List<Map<String, Object>> lista = new ArrayList<>();

        for (Object[] fila : resultados) {
            Map<String, Object> registro = new HashMap<>();
            registro.put("nid_persona", fila[0]);
            registro.put("nid_academico_alumno", fila[1]);
            registro.put("cnombre", fila[2]);
            registro.put("capellidos", fila[3]);
            registro.put("cnumero_cuenta", fila[4]);
            registro.put("bhabilitado", fila[5]);
            lista.add(registro);
        }

        return lista;
    }

    @Transactional
    public void cambiarEstadoHabilitado(Integer idAlumno, boolean habilitado) {
        alumnosRepository.actualizarEstadoHabilitado(idAlumno, habilitado);
    }

    @Transactional
    public List<Map<String, Object>> buscarAlumnos(String textoBusqueda) {
        List<Object[]> resultados = alumnosRepository.buscarAlumnos(textoBusqueda);

        // Convierte los resultados en una lista de mapas para facilitar su uso en el frontend
        List<Map<String, Object>> alumnos = new ArrayList<>();
        for (Object[] fila : resultados) {
            Map<String, Object> alumno = new HashMap<>();
            alumno.put("nid_academico_alumno", fila[0]);
            alumno.put("cnombre", fila[1]);
            alumno.put("capellidos", fila[2]);
            alumno.put("cnumero_cuenta", fila[3]);
            alumno.put("bhabilitado", fila[4]);
            alumnos.add(alumno);
        }
        return alumnos;
    }

    @Transactional
    public List<Map<String, Object>> consultarHistorial(Integer nid_usuario){
        List<Object[]> resultado = alumnosRepository.consultaHistorial(nid_usuario);
        List<Map<String, Object>> lista = new ArrayList<>();

        for(Object[] fila : resultado){
            Map<String, Object> regMaterias = new HashMap<>();
            regMaterias.put("nid_insc_alumno", fila[0]);
            regMaterias.put("nid_horario_materia", fila[1]);
            regMaterias.put("cnombre_materia", fila[2]);
            regMaterias.put("cclave_materia", fila[3]);
            regMaterias.put("ncalificación", fila[4]);
            regMaterias.put("nsemestre", fila[5]);
            regMaterias.put("cperiodo", fila[6]);
            regMaterias.put("canio", fila[7]);
            lista.add(regMaterias);
        }
        return lista;
    }
    

}