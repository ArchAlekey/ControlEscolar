 package com.tramp.controlescolar.controllers.Usuario;


import org.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tramp.controlescolar.services.UsuarioService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin (origins = "*")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService _usuarioService;

    @PostMapping("/valida")
    public ResponseEntity<?> validarUsuario(@RequestBody String body){
        JSONObject request = new JSONObject(body);

        String usuario = request.getString("usuario");
        String contrasenia = request.getString("contrasenia");

        JSONObject respuesta = _usuarioService.validaUsuario(usuario, contrasenia);

        if(respuesta.getBoolean("success")){
            return ResponseEntity.ok(respuesta.toString());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(respuesta.toString());
        }
    }
}
