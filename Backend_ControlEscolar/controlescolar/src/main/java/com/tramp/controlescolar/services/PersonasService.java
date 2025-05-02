package com.tramp.controlescolar.services;

import org.springframework.stereotype.Service;

import com.tramp.controlescolar.repository.PersonasRepository;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.transaction.Transactional;
import com.tramp.controlescolar.dto.PersonaUsuarioRequest;
import java.util.List;

@Service
public class PersonasService {

    @Autowired
    private PersonasRepository _personasRepository;

    @Transactional
    public void insertarAdministrador(PersonaUsuarioRequest request){
        _personasRepository.insertaPersonaAdministrador(
                request.getCnombre(),
                request.getCapellidos(),
                request.getBsexo(),
                request.getNedad(),
                request.getDfecha_nacimiento(),
                request.getcCURP(),
                request.getcRFC(),
                request.getCnumero_celular(),
                request.getNid_carrera(),
                request.getCcorreo_personal()
        );

    }
    @Transactional
    public void insertarProfesor(PersonaUsuarioRequest request) {
        _personasRepository.insertaPersonaProfesor(
                request.getCnombre(),
                request.getCapellidos(),
                request.getBsexo(),
                request.getNedad(),
                request.getDfecha_nacimiento(),
                request.getcCURP(),
                request.getcRFC(),
                request.getCnumero_celular(),
                request.getNid_carrera(),
                request.getCcorreo_personal()
        );
    }

    @Transactional
    public void insertarAlumno(PersonaUsuarioRequest request) {
        _personasRepository.insertaPersonaAlumno(
                request.getCnombre(),
                request.getCapellidos(),
                request.getBsexo(),
                request.getNedad(),
                request.getDfecha_nacimiento(),
                request.getcCURP(),
                request.getcRFC(),
                request.getCnumero_celular(),
                request.getNid_carrera(),
                request.getCcorreo_personal()
        );
    }

    @Transactional 
    public void actualizaPersona(PersonaUsuarioRequest request) {
        _personasRepository.actualizaDatosPersonale(
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
    public PersonaUsuarioRequest consultaDatosPersonales(Integer nid_persona){
        List<Object[]> resultados = _personasRepository.consultarDatosPersonales(nid_persona);
    
        if(resultados == null || resultados.isEmpty()){
            return null;
        }
    
        Object[] fila = resultados.get(0);
        
        PersonaUsuarioRequest dto = new PersonaUsuarioRequest();
        dto.setNid_persona((Integer) fila[0]);
        dto.setCnombre((String) fila[1]);
        dto.setCapellidos((String) fila[2]);
        dto.setBsexo((Boolean) fila[3]);
        dto.setNedad((Integer) fila[4]);
        dto.setDfecha_nacimiento((Date) fila[5]);
        dto.setcCURP((String) fila[6]);
        dto.setcRFC((String) fila[7]);
        dto.setCnumero_celular((String) fila[8]);
        dto.setCcorreo_institucional((String) fila[9]);
        dto.setCcorreo_personal((String) fila[10]);
    
        return dto;
    }
    
}
