package com.tramp.controlescolar.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import com.tramp.controlescolar.repository.UsuarioRepository;
import com.tramp.controlescolar.dto.UsuarioValidaDTO;
//import com.tramp.controlescolar.models.tablas.Usuarios;
import org.json.JSONObject ;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository _usuarioRepositorio;

    @Transactional
    public JSONObject validaUsuario(String usuario, String contrasenia){
        JSONObject respuesta = new JSONObject();
        List<UsuarioValidaDTO> user = _usuarioRepositorio.validarUsuario(usuario, contrasenia);

        if(user == null || user.isEmpty()){
            respuesta.put("success", false);
            respuesta.put("message", "Usuario o contraseña invalido");
            
        } else {
            UsuarioValidaDTO usuarioEncontrado = user.get(0);
            respuesta.put("success", true);
            respuesta.put("message", "Usuario Valido");
            /* Datos para el Token */
            respuesta.put("id", usuarioEncontrado.getIdUsuario());
            respuesta.put("usuario", usuarioEncontrado.getusuario());
            respuesta.put("idcategoria", usuarioEncontrado.getnid_categoria());
        }

        return respuesta;
    }
}
