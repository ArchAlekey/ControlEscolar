package com.tramp.controlescolar.services;

import org.springframework.stereotype.Service;

import com.tramp.controlescolar.repository.PersonasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.transaction.Transactional;
import com.tramp.controlescolar.dto.PersonaUsuarioRequest;

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
    
}
