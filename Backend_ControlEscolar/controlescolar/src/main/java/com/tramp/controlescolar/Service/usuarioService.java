package com.tramp.controlescolar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import com.tramp.controlescolar.repository.UsuarioRepositorio;
import com.tramp.controlescolar.models.tablas.Usuarios;
import org.json.JSONObject ;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepositorio _usuarioRepositorio;

    @Transactional
    public JSONObject validaUsuario(String usuario, String contrasenia){
        JSONObject respuesta = new JSONObject();
        List<Usuarios> user = _usuarioRepositorio.validarUsuario(usuario, contrasenia);

        if(user == null || user.isEmpty()){
            respuesta.put("success", false);
            respuesta.put("message", "Usuario o contraseña invalido");
            
        } else {
            Usuarios usuarioEncontrado = user.get(0);
            respuesta.put("success", true);
            respuesta.put("message", "Usuario Valido");
            respuesta.put("usuario", usuarioEncontrado.getUsuario());
        }

        return respuesta;
    }
}
