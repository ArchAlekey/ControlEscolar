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
    public List<Map<String, Object>> consultarCalificaciones(Integer nid_usuario){
        List<Object[]> resultados = alumnosRepository.consultarCalificaciones(nid_usuario);
        List<Map<String, Object>> calificaciones = new ArrayList<>();

        //Iteramos sobre los resultados devueltos en el procedimiento
        for(Object[] fila: resultados){
            //Asignamos cada columna del resultado a su respectivo campo en el mapa
            Map<String, Object> calificacion = new HashMap<>();
            calificacion.put("cnombre_materia", fila[0]);
            calificacion.put("cclave_materia", fila[1]);
            calificacion.put("ncalificación", fila[2]);
            calificacion.put("cperiodo", fila[3]);
            calificacion.put("cgrupo", fila[4]);

            //Agregamos el objecto calificacion a la lista de resultados
            calificaciones.add(calificacion);
        }
        return calificaciones;
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
}