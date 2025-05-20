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
            grupo.put("nid_grupo", fila[0]);
            grupo.put("cgrupo", fila[1]);
            grupo.put("nid_materia", fila[2]);
            grupo.put("cnombre_materia", fila[3]);
            grupo.put("cclave_materia", fila[4]);
            grupo.put("cperiodo", fila[5]);
            grupo.put("chorario", fila[6]);

            //Agregamos el objecto calificacion a la lista de resultados
            grupos.add(grupo);
        }
        return grupos;
    }

    @Transactional 
    public void insertaCalificaciones(Integer nid_horario_materia, Integer nid_usuario, Float ncalificacion){
        profesoresRepository.insertaCalificaciones(nid_horario_materia, nid_usuario, ncalificacion);
    };

    @Transactional 
    public void eliminaCalificacion(Integer nid_horario_materia, Integer nid_usuario){
        profesoresRepository.eliminaCalificacion(nid_horario_materia, nid_usuario);
    }

    @Transactional 
    public List<Map<String, Object>> consultarAlumnosInscritos(Integer nid_grupo, Integer nid_materia){
        List<Object[]> resultados = profesoresRepository.consultaAlumnosIns(nid_grupo, nid_materia);
        List<Map<String, Object>> alumnos = new ArrayList<>();

        //Iteramos sobre los resultados devueltos en el procedimiento
        for(Object[] fila: resultados){
            //Asignamos cada columna del resultado a su respectivo campo en el mapa
            Map<String, Object> alumno = new HashMap<>();
            alumno.put("nid_usuario", fila[0]);
            alumno.put("nid_horario_materia", fila[1]);
            alumno.put("nid_grupo", fila[2]);
            alumno.put("nid_materia", fila[3]);
            alumno.put("Nombre", fila[4]);
            alumno.put("cnumero_cuenta", fila[5]);
            alumno.put("ncalificacion", fila[6]);
            alumno.put("ccorreo_institucional", fila[7]);
            alumno.put("ccorreo_personal", fila[8]); //Falta agregar al modelo (models) !!!
            //Agregamos el objecto alumno a la lista de resultados 
            alumnos.add(alumno);
        }
        return alumnos;
    }

    @Transactional
    public List<Map<String, Object>> obtenerAcademicosProfesoresConPersonas() {
        List<Object[]> resultados = profesoresRepository.obtenerAcademicosProfesoresConPersonas();
        List<Map<String, Object>> datos = new ArrayList<>();

        for (Object[] fila : resultados) {
            Map<String, Object> dato = new HashMap<>();
            dato.put("nid_persona", fila[0]);
            dato.put("nid_academico_profesor", fila[1]);
            dato.put("cnombre", fila[2]);
            dato.put("capellidos", fila[3]);
            dato.put("cnumero_cuenta", fila[4]);
            dato.put("bhabilitado", fila[5]);
            datos.add(dato);
        }

        return datos;
    }

    @Transactional
    public void cambiarEstadoHabilitado(Integer idProfesor, boolean habilitado) {
        profesoresRepository.actualizarEstadoHabilitado(idProfesor, habilitado);
    }

     @Transactional
    public List<Map<String, Object>> buscarProfesores(String textoBusqueda) {
        List<Object[]> resultados = profesoresRepository.buscarProfesores(textoBusqueda);

        // Convierte los resultados en una lista de mapas para facilitar su uso en el frontend
        List<Map<String, Object>> profesores = new ArrayList<>();
        for (Object[] fila : resultados) {
            Map<String, Object> profesor = new HashMap<>();
            profesor.put("nid_academico_profesor", fila[0]);
            profesor.put("cnombre", fila[1]);
            profesor.put("capellidos", fila[2]);
            profesor.put("cnumero_cuenta", fila[3]);
            profesor.put("bhabilitado", fila[4]);
            profesores.add(profesor);
        }
        return profesores;
    }

}
