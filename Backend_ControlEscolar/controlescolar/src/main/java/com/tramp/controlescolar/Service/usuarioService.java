package com.tramp.controlescolar.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.tramp.controlescolar.repository.usuarioRepositorio;
import com.tramp.controlescolar.models.tablas.Usuarios;

@Service
public class usuarioService {
    @Autowired
    private usuarioRepositorio _usuarioRepositorio;

    public List<Usuarios> validateUsuarios(String cusario, String ccontrasenia){
        return _usuarioRepositorio.validateUsuarios(cusario, ccontrasenia);
    }
}
