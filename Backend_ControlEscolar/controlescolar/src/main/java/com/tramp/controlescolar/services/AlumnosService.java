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
    public List<Map<String, Object>> consultarAlumnosInscritos(Integer nid_grupo){
        List<Object[]> resultados = alumnosRepository.consultaAlumnosIns(nid_grupo);
        List<Map<String, Object>> alumnos = new ArrayList<>();

        //Iteramos sobre los resultados devueltos en el procedimiento
        for(Object[] fila: resultados){
            //Asignamos cada columna del resultado a su respectivo campo en el mapa
            Map<String, Object> alumno = new HashMap<>();
            alumno.put("cnumero_cuenta", fila[0]);
            alumno.put("ccorreo_institucional", fila[1]);
            alumno.put("ccorreo_personal", fila[2]); //Falta agregar al modelo (models) !!!

            //Agregamos el objecto alumno a la lista de resultados 
            alumnos.add(alumno);
        }
        return alumnos;
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
    
}