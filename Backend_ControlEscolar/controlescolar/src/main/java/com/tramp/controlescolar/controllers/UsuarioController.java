 package com.tramp.controlescolar.controllers;


import com.tramp.controlescolar.models.tablas.Usuarios;
import org.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tramp.controlescolar.security.jwt.jwtUtil;
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
    @Autowired
    private jwtUtil _jwt;

    @PostMapping("/valida")
    public ResponseEntity<?> validarUsuario(@RequestBody String body){
        JSONObject request = new JSONObject(body);

        String usuario = request.getString("usuario");
        String contrasenia = request.getString("contrasenia");

        JSONObject respuesta = _usuarioService.validaUsuario(usuario, contrasenia);

        if(respuesta.getBoolean("success")){

            Integer idPersona = respuesta.getInt("idPersona");
            Integer idUsuario = respuesta.getInt("idUsuario");
            /* String user = respuesta.getString("usuario"); */
            Integer categoria = respuesta.getInt("idcategoria");

            String Token = _jwt.generaToken(idPersona, idUsuario, usuario, categoria);

            respuesta.put("token", Token);

            return ResponseEntity.ok(respuesta.toString());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(respuesta.toString());
        }
    }

    @PostMapping("/cambiarContrasenia")
    public ResponseEntity<String> actualizarContrasenia(@RequestBody Usuarios usuario){
        try{
            _usuarioService.actualizarContrasenia(usuario.getIdUsuario(), usuario.getContrasenia());
            return ResponseEntity.ok("Contraseña actualiza correctamente");
        } catch (Exception e){
            return ResponseEntity.status(500).body("Error al cambiar contraseña: " + e.getMessage());
        }
    }
}
