package com.tramp.controlescolar.services;

import org.springframework.stereotype.Service;

import com.tramp.controlescolar.repository.PersonasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.transaction.Transactional;
import com.tramp.controlescolar.dto.PersonaUsuarioRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PersonasService {

    @Autowired
    private PersonasRepository personasRepository;

    @Transactional
    public void insertarAdministrador(PersonaUsuarioRequest request){
        personasRepository.insertaPersonaAdministrador(
                request.getCnombre(),
                request.getCapellidos(),
                request.getBsexo(),
                request.getNedad(),
                request.getDfecha_nacimiento(),
                request.getcCURP(),
                request.getcRFC(),
                request.getCnumero_celular(),
                request.getNid_carrera(),
                request.getContrasenia()
        );

    }
    @Transactional
    public void insertarProfesor(PersonaUsuarioRequest request) {
        personasRepository.insertaPersonaProfesor(
                request.getCnombre(),
                request.getCapellidos(),
                request.getBsexo(),
                request.getNedad(),
                request.getDfecha_nacimiento(),
                request.getcCURP(),
                request.getcRFC(),
                request.getCnumero_celular(),
                request.getNid_carrera(),
                request.getContrasenia()
        );
    }

    @Transactional
    public void insertarAlumno(PersonaUsuarioRequest request) {
        personasRepository.insertaPersonaAlumno(
                request.getCnombre(),
                request.getCapellidos(),
                request.getBsexo(),
                request.getNedad(),
                request.getDfecha_nacimiento(),
                request.getcCURP(),
                request.getcRFC(),
                request.getCnumero_celular(),
                request.getNid_carrera(),
                request.getContrasenia()
        );
    }

    @Transactional 
    public void actualizaPersona(PersonaUsuarioRequest request) {
        personasRepository.actualizaDatosPersonale(
            request.getNid_persona(),
            request.getCnombre(),
            request.getCapellidos(),
            request.getBsexo(),
            request.getNedad(),
            request.getDfecha_nacimiento(),
            request.getcCURP(),
            request.getcRFC(),
            request.getCnumero_celular()
        );
    }

    @Transactional
    public List<Map<String, Object>> consultarDatosPersonales(Integer nid_persona){
        List<Object[]> resultados = personasRepository.consultarDatosPersonales(nid_persona);
        List<Map<String, Object>> datos = new ArrayList<>();

        //Iteramos sobre los resultados devueltos en el procedimiento
        for(Object[] fila: resultados){
            //Asignamos cada columna del resultado a su respectivo campo en el mapa
            Map<String, Object> dato = new HashMap<>();
            dato.put("cnombre_materia", fila[0]);
            dato.put("cclave_materia", fila[1]);
            dato.put("ncalificación", fila[2]);
            dato.put("cperiodo", fila[3]);
            dato.put("cgrupo", fila[4]);

            //Agregamos el objecto calificacion a la lista de resultados
            datos.add(dato);
        }
        return datos;
    }


    
}
