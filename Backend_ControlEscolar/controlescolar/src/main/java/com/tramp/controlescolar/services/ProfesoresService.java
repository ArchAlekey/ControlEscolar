package com.tramp.controlescolar.services;

import com.tramp.controlescolar.repository.ProfesoresRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProfesoresService {

    @Autowired
    private ProfesoresRepository profesoresRepository;
    @Transactional
    public List<Map<String, Object>> consultaGruposAsignados(Integer nid_persona){

        List<Object[]> resId = profesoresRepository.consultaIdAcademico(nid_persona);

        if(resId.isEmpty()){
            throw new RuntimeException("No se encontro profesor con ese id de persona");
        }
        Integer nid_academico_profesor = (Integer) resId.get(0)[0];

        List<Object[]> resultados = profesoresRepository.consultaGruposAsignados(nid_academico_profesor);
        List<Map<String, Object>> grupos = new ArrayList<>();

        //Iteramos sobre los resultados devueltos en el procedimiento
        for(Object[] fila: resultados){
            //Asignamos cada columna del resultado a su respectivo campo en el mapa
            Map<String, Object> grupo = new HashMap<>();
            grupo.put("cgrupo", fila[0]);
            grupo.put("cnombre_materia", fila[1]);
            grupo.put("cclave_materia", fila[2]);
            grupo.put("cperiodo", fila[3]);
            grupo.put("chorario", fila[4]);

            //Agregamos el objecto calificacion a la lista de resultados
            grupos.add(grupo);
        }
        return grupos;
    }

    @Transactional 
    public void insertaCalificaciones(Integer nid_materia, Integer nid_usuario, Float ncalificacion){
        profesoresRepository.insertaCalificaciones(nid_materia, nid_usuario, ncalificacion);
    }

    @Transactional 
    public List<Map<String, Object>> consultarAlumnosInscritos(Integer nid_grupo){
        List<Object[]> resultados = profesoresRepository.consultaAlumnosIns(nid_grupo);
        List<Map<String, Object>> alumnos = new ArrayList<>();

        //Iteramos sobre los resultados devueltos en el procedimiento
        for(Object[] fila: resultados){
            //Asignamos cada columna del resultado a su respectivo campo en el mapa
            Map<String, Object> alumno = new HashMap<>();
            alumno.put("Nombre", fila[0]);
            alumno.put("cnumero_cuenta", fila[1]);
            alumno.put("ccorreo_institucional", fila[2]);
            alumno.put("ccorreo_personal", fila[3]); //Falta agregar al modelo (models) !!!

            //Agregamos el objecto alumno a la lista de resultados 
            alumnos.add(alumno);
        }
        return alumnos;
    }
}
