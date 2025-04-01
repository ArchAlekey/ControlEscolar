 package com.tramp.controlescolar.controllers.Usuario;


import org.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tramp.controlescolar.services.UsuarioService;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService _usuarioService;

    @PostMapping("/valida")
    public String validarUsuario(@RequestBody String body){
        JSONObject request = new JSONObject(body);

        String usuario = request.getString("usuario");
        String contrasenia = request.getString("contrasenia");

        JSONObject respuesta = _usuarioService.validaUsuario(usuario, contrasenia);

        return respuesta.toString();
    }
}
